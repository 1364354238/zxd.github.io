package com.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author dzx
 * @date 2021/9/14 -11:38
 * 操作数据库的工具类
 */
public class JDBCUtils {
//    创建一个c3p0数据库连接池
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("c3p0config");
    public static Connection getC3P0ConnectionFromPoll() throws SQLException{
        Connection con = comboPooledDataSource.getConnection();
        return con;
    }

//    dbcp数据库连接池
    private static DataSource dataSource;
    static {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("DBCP.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            dataSource= BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getDBCPConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        return connection;
    }

//Druid数据库连接（常用）
    private static DataSource DruidDataSource;
    static {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            DruidDataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getDruidConnection() throws SQLException {
        Connection connection = DruidDataSource.getConnection();
        return connection;
    }

    public  static Connection getConnection(String properties) throws IOException, ClassNotFoundException, SQLException {
//        读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(properties);
        Properties pros=new Properties();
        pros.load(is);
        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String driverClass = pros.getProperty("driverClass");
//        加载驱动
        Class.forName(driverClass);
//        获取连接
        Connection con = DriverManager.getConnection(url,user,password);
        return con;

    }
    public static void closeResourse(Connection con, Statement ps){
        try {
            if(ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeResourse(Connection con, Statement ps,ResultSet resultSet){
        try {
            if(ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if (con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(resultSet!=null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
