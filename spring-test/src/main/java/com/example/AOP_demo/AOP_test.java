package com.example.AOP_demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/10/23 -15:24
 */
public class AOP_test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("AOP_demo.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

    }
//    方式二
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("AOP_demo.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
