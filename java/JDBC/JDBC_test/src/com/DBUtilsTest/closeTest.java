package com.DBUtilsTest;

import com.test.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author dzx
 * @date 2021/9/16 -14:25
 * 使用dbutils提供的DbUtils类关闭连接
 */
public class closeTest {
//    方式一：DbUtils.close
    @Test
    public void test(){
        try {
            Connection connection = JDBCUtils.getDruidConnection();
            DbUtils.close(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    方式二：DbUtils.closeQuietly
    @Test
    public void test2(Connection con, Statement statement, ResultSet resultSet){
        DbUtils.closeQuietly(con);
        DbUtils.closeQuietly(statement);
        DbUtils.closeQuietly(resultSet);

    }
}
