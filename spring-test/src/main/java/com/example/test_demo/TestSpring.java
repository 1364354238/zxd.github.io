package com.example.test_demo;

import com.example.Dao.UserDaoImpl;
import com.example.Service.UserService;
import com.example.Service.UserServiceImpl;
import com.example.pojo.Hello;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/10/20 -14:22
 */
public class TestSpring {
    @Test
    public void testAdd(){
//        1.加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        获取配置创建的对象
        UserDaoImpl userDaoImpl =context.getBean("userDaoImpl", UserDaoImpl.class);
        System.out.println(userDaoImpl);
        userDaoImpl.add();
        Hello hello = context.getBean("hello", Hello.class);
        System.out.println(hello);
        UserService userService = (UserService) context.getBean("UserServiceImpl");
        userService.getUser();
    }
}
