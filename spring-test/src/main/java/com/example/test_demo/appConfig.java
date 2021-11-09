package com.example.test_demo;

import com.example.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;

/**
 * @author dzx
 * @date 2021/10/22 -10:28
 */
@Configuration //代表一个配置类就和beans.xml一样
@ComponentScan("com.example.pojo")
public class appConfig {
//    @Bean   //注册一个bean 相当于<bean>,这个方法的名字就相当于bean标签中的id，方法的返回值就相当于class
//    public User getUser() {
//        return new User();
//    }

}
class myTest{
    public static void main(String[] args) {
//        如果完全使用配置类的方式.就只能使用AnnotationConfigApplicationContext来获取容器
        ApplicationContext context = new AnnotationConfigApplicationContext(appConfig.class);
        User user = (User) context.getBean("user");
        User user2 = (User) context.getBean(User.class);
        System.out.println(user.getName());
        System.out.println(user2.getName());
    }
}

