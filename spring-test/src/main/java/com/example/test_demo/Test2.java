package com.example.test_demo;

import com.example.pojo.Student1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/10/20 -15:52
 */
public class Test2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Student1 student1 = (Student1) context.getBean("student");
        System.out.println(student1);


    }
}
