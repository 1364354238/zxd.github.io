package com.connectionPool;

/**
 * @author dzx
 * @date 2021/9/16 -10:03
 */
import com.mchange.v2.c3p0.DataSources;
import com.test.util.JDBCUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    @Test
    public void getConnection() throws SQLException {
//        创建数据库连接池
        BasicDataSource dataSource = new BasicDataSource();
//        设置基本信息
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("510510");
//        还可以设置数据池其他相关属性
        dataSource.setMaxActive(50);
//        获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
//    使用配置文件
    @Test
    public void dbcpXMLTest() throws Exception{
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("DBCP.properties");
//        Properties properties = new Properties();
//        properties.load(is);
//        DataSource dataSource= BasicDataSourceFactory.createDataSource(properties);
//        Connection connection=dataSource.getConnection();
        Connection connection = JDBCUtils.getDBCPConnection();
        System.out.println(connection);
    }
}
