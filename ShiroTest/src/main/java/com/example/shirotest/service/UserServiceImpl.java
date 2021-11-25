package com.example.shirotest.service;

import com.example.shirotest.mapper.UserMapper;
import com.example.shirotest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author dzx
 * @data 2021/11/22 -16:02
 */
@Service
public class UserServiceImpl implements UserService{
    @Resource
    UserMapper userMapper;
    @Override
    public User updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Collection<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
