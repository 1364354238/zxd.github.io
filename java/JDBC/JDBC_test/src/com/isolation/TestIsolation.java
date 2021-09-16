package com.isolation;

import com.bean.User;
import com.test.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

/**
 * @author dzx
 * @date 2021/9/15 -14:47
 * 设置数据库的隔离级别
 */
public class TestIsolation {
    @Test
    public void testTsSelect()throws Exception{
        String properties = "jdbc.properties";
        Connection con = JDBCUtils.getConnection(properties);
//        查看隔离级别read uncommitted(读未提交数据):1
//read commited(读已提交数据) :避免脏读:2
//repeatable read(可重复读) 避免脏读，可重复读:4
//serializable(串行化): 8
        System.out.println(con.getTransactionIsolation());
//        设置数据库的隔离级别
        con.setTransactionIsolation(1);
        con.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user=?";
        User user1=tsCommentSelect(con, User.class, sql, "CC");
        System.out.println(user1);

    }
    @Test
    public void testTsUpdate()throws Exception{
        String properties = "jdbc.properties";
        Connection con = JDBCUtils.getConnection(properties);
        con.setAutoCommit(false);
        String sql = "update user_table set balance=? where user=?";
        updateWithTX(con,sql,4000,"CC");
        Thread.sleep(10000);

        System.out.println("修改结束");
    }
//    通用查询操作+事务
    public <T>T tsCommentSelect(Connection con,Class<T>cls,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            ResultSetMetaData resultSetMetaData = ps.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            if (resultSet.next()){
                T table = cls.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    String columnName=resultSetMetaData.getColumnLabel(i+1);
                    Field field = table.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(table,columnValue);
                }
                return table;
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            JDBCUtils.closeResourse(null,ps,resultSet);
        }
        return null;



    }
    //    通用增删改+事务
    public void updateWithTX(Connection con,String sql,Object ...args){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                con.rollback();
                System.out.println("回滚2");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
//            修改为自动提交数据
//            针对数据库连接池的使用
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            JDBCUtils.closeResourse(null,ps);
        }
    }
}
