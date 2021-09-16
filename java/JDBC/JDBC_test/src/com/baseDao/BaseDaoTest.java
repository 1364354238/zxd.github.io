package com.baseDao;

import com.test.util.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dzx
 * @date 2021/9/15 -15:33
 * 封装了针对数据表的通用的操作
 */
public abstract class BaseDaoTest<T> {
    private Class<T>cls;
//子类创建实例时，会自动执行
    {
//        带泛型的父类,这里的this是实例对应的类
        Type genericSuperclass = this.getClass().getGenericSuperclass();
//        获取父类的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Type[] types = parameterizedType.getActualTypeArguments();
        cls = (Class<T>) types[0];

    }
    public <E>E getValue(Connection con,String sql,Object ...args){
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(null,ps,resultSet);
        }
        return null;
    }
    //    通用查询操作+事务
    public <T>T tsCommentSelect(Connection con, String sql, Object ...args){
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
                T table = (T) cls.getConstructor().newInstance();
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
    //    返回多行查询结果
    public <T> List<T> selectMore(Connection con, String sql, Object ...args) {
        PreparedStatement ps= null;
        ResultSet resultSet = null;
        try {
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[0]);
            }
            resultSet = ps.executeQuery();
            //            获取结果集的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //            通过原数据获取列数
            int columnCount = rsmd.getColumnCount();
            List<T> l = new ArrayList<>();
            while (resultSet.next()){
                //                获取表对应的类
                //                Class<?> cls = Class.forName(table);
                //                创建对象
                T tableInstance = (T) cls.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i+1);
                    //                    获取每个列的列名
                    //                    String columnName = rsmd.getColumnName(i+1);
                    //                    获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);
                    //                    找到指定列对应的属性
                    Field field = cls.getDeclaredField(columnName);
                    field.setAccessible(true);
                    //                    给对象指定属性赋值
                    field.set(tableInstance,columnValue);

                }
                l.add(tableInstance);
            }
            return l;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResourse(null, ps, resultSet);
        }
        return null;

    }
}
