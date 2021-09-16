package com.baseDao;

import com.bean.Customers;
import com.test.util.JDBCUtils;

import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dzx
 * @date 2021/9/15 -16:26
 */
class CustomersDaoImplTest {

    private CustomersDaoImpl test = new CustomersDaoImpl();
    private String properties = "jdbc.properties";

    @org.junit.jupiter.api.Test

    void insert() {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection(properties);
            Customers cust = new Customers(1, "wang", "234@163", new Date(546355645L));
            test.insert(con,cust);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,null);
        }

    }

    @org.junit.jupiter.api.Test
    void deleteById() {
    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void select() {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection(properties);

            System.out.println(test.select(con,1));
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,null);
        }
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }

    @org.junit.jupiter.api.Test
    void getCount() {
        Connection con = null;
        try {
            con = JDBCUtils.getConnection(properties);

            System.out.println(test.getCount(con));
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,null);
        }
    }

    @org.junit.jupiter.api.Test
    void getMaxBirth() {
    }
}