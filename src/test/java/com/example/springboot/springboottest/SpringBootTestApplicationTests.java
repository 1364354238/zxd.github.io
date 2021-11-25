package com.example.springboot.springboottest;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springboot.springboottest.pojo.Dog;
import com.example.springboot.springboottest.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Period;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Autowired
    DataSource dataSource;
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void contextLoads() throws SQLException {
//        Connection connection = dataSource.getConnection();
//        System.out.println(dataSource.getClass());
//        System.out.println(connection);
    }
    @Test
//    简单邮件
    void contextLoads2()  {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("主题");
        mailMessage.setText("测试文本");
        mailMessage.setTo("1364354238@qq.com");
        mailMessage.setFrom("1364354238@qq.com");
        javaMailSender.send(mailMessage);
    }
//    复杂邮件
    @Test
    void contextLoads3() throws MessagingException {

        MimeMessage mailMessage = javaMailSender.createMimeMessage();
//        组装
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
        helper.setSubject("主题1");
        helper.setText("文本","index.html");
        helper.setText("<h1 style='color:red'>html</h1>",true);
//        附件
        helper.addAttachment("1.jpg",new File("c:\\2.jpg"));
        javaMailSender.send(mailMessage);
    }

}
