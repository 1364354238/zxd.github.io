package com.example.test_demo;

import com.example.pojo.People;
import com.example.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzx
 * @data 2021/10/20 -19:34
 */
public class autowired {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowired.xml");
        People people = (People) context.getBean("people");
        people.getCat().shout();
        people.getDog().shout();
        System.out.println(people);
        User user = (User) context.getBean("user");
    }

}
