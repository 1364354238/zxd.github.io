package com.example.book.test;

import com.example.book.dao.UserDao;
import com.example.book.dao.UserDaoImpl;
import com.example.book.pojo.User;
import org.junit.Test;


/**
 * @author dzx
 * @data 2021/10/7 -17:53
 */
public class UserDaoTest {
    @Test
    public void queryUserByUsername(){
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));
        System.out.println(userDao.saveUser(new User(null,"test","124124","213@213.com")));
    }

}
