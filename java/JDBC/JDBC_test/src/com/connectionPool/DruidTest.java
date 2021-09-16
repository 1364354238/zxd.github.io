package com.connectionPool;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.test.util.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author dzx
 * @date 2021/9/16 -10:44
 */
public class DruidTest {
//    测试Druid
    @Test
    public void getConnection() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("510510");
        dataSource.setInitialSize(5);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
//    使用配置文件
    @Test
    public void DruidXMLTest() throws Exception{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("Druid.properties");
        Properties properties = new Properties();
        properties.load(is);
        DataSource dataSource= DruidDataSourceFactory.createDataSource(properties);
        Connection connection=dataSource.getConnection();
//        Connection connection = JDBCUtils.getDruidConnection();
        System.out.println(connection);
    }
}
