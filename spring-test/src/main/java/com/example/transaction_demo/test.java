package com.example.transaction_demo;

import com.example.mybatis_demo.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/10/26 -12:46
 */
public class test {
    @Test
    public void test(){
        ApplicationContext contex = new ClassPathXmlApplicationContext("transaction.xml");
        UserMapper userDao = contex.getBean("userMapper3", UserMapper.class);
        userDao.selectUser().forEach(System.out::println);
    }
}
