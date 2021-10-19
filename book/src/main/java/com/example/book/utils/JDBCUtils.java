package com.example.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author dzx
 * @date  2021/10/7 -15:11
 */
public class JDBCUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
//    将配置加载到数据池
    static {
        Properties properties = new Properties();
        try {
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    获取连接
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if(connection==null){
            try {
                connection = dataSource.getConnection();
//                保存到ThreadLocal中，给后面的JDBCUtils使用
                threadLocal.set(connection);
//                设置为手动管理
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    //      提交事务并关闭连接
    public static void commitAndClose() {
        Connection connection = threadLocal.get();
        if(connection!=null){
            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
//        一定要执行remove操作，因为Tomcat底层使用了线程池，避免内存泄露
        threadLocal.remove();
    }
//    回滚事务
    public static void rollbackAndClose() {
        Connection connection = threadLocal.get();
        if(connection!=null){
            try {
                connection.rollback();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        threadLocal.remove();
    }
    public static void main(String[] args) {

    }


}
