package com.example.shirotest.service;

import com.example.shirotest.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author dzx
 * @data 2021/11/22 -16:01
 */
public interface UserService {
    public User updateUser(User user);

    public Collection<User> queryUserList();

    User queryUserByName(String username);
}
