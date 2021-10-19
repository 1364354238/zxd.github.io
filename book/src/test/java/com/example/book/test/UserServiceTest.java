package com.example.book.test;

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author dzx
 * @date 2021/10/7 -18:12
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"admin2","123","213@w1.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin3", "123", "213@w1.com")));
    }

    @Test
    public void existUsername() {
    }
}