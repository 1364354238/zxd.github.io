package com.transaction;

import com.mysql.cj.jdbc.JdbcConnection;
import com.test.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dzx
 * @date 2021/9/15 -12:30
 * 事务
 * DDL默认提交，不能修改默认值
 * DML默认提交，可以修改默认值
 * 默认在关闭连接时，会提交数据
 */

public class TransactionTest {
    @Test
    public void testUpdate(){
        String properties = "jdbc.properties";
        Connection con = null;
        try {
            con = JDBCUtils.getConnection(properties);
//        关闭自动连接
            con.setAutoCommit(false);

            String sql1="update user_table set balance=balance+200 where user=?";
            updateWithTX(con,sql1,"AA");

//        模拟提交异常
//            System.out.println(10/0);
            String sql2="update user_table set balance=balance+100 where user=?";
            updateWithTX(con,sql2,"BB");
            System.out.println("成功");
//        提交数据
            con.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
//            出现异常就回滚
            try {
                con.rollback();
                System.out.println("回滚");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("异常");
            }
        } finally {
            JDBCUtils.closeResourse(con,null);
        }
    }
//    通用增删改
    public int commentModify(String sql,Object ...args) {
        String properties = "jdbc.properties";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtils.getConnection(properties);
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,ps);

        }
        return 0;


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
            try {
                con.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JDBCUtils.closeResourse(null,ps);
        }
    }
}
