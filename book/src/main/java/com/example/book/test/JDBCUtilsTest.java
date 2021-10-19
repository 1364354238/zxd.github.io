package com.example.book.test;

import com.example.book.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author dzx
 * @date 2021/10/7 -17:00
 */
public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        for (int i = 0; i < 12; i++) {
            Connection connection = JDBCUtils.getConnection();
            System.out.println(connection);
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
