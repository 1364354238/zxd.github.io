package com.connectionPool;

import com.baseDao.CustomersDaoImpl;
import com.test.util.JDBCUtils;
import org.junit.Test;
import com.mchange.v2.c3p0.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author dzx
 * @date 2021/9/15 -20:06
 * 数据库连接池技术：为数据库连接建立一个缓冲池，预先在缓冲池当中放入一定数量的连接
 * 当需要建立数据库连接时，只需要从“缓冲池”当中取出一个，使用完毕再放回去。
 * 主要方法有：1.C3P0
 * 2.DBCP
 * 3.Druid
 */
public class C3P0Test {
//    测试c3p0
    @Test
    public void C3P0() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8" );
        cpds.setUser("root");
        cpds.setPassword("510510");
//        设置连接池当中的初始连接数
        cpds.setInitialPoolSize(10);
//        获取连接
        Connection con = cpds.getConnection();
        System.out.println(con);
//        销毁数据连接池（一般不做）
//        DataSources.destroy(cpds);
        CustomersDaoImpl test = new CustomersDaoImpl();
        System.out.println(test.select(con, 2));
    }
//    使用配置文件获取连接
    @Test
    public void C3P0XMLTest() throws SQLException {
//        ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0config");
//        Connection con = cpds.getConnection();
//        System.out.println(con);
        Connection con = JDBCUtils.getC3P0ConnectionFromPoll();
        System.out.println(con);
    }
}
