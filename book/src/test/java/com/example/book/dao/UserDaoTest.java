package com.example.book.dao;

import org.junit.Test;

/**
 * @author dzx
 * @data 2021/10/7 -17:47
 */
public class UserDaoTest {
    @Test
    public void queryUserByUsername(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
    }
}