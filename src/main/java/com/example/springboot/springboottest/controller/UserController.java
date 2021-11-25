package com.example.springboot.springboottest.controller;

import com.example.springboot.springboottest.mapper.UserMapper;
import com.example.springboot.springboottest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/17 -18:47
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("user/queryList")
    public List<User> queryUserList(){
        return userMapper.queryUserList();
    }

}
