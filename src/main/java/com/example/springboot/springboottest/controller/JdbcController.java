package com.example.springboot.springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/16 -16:26
 */
@RestController
public class JdbcController {
    @Resource
    JdbcTemplate jdbcTemplate;
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from mybatis.user";
        return jdbcTemplate.queryForList(sql);
    }
    @GetMapping("/updateUser")
    public List<Map<String,Object>> updateUser(){
        String sql = "update mybatis.user set name=? ,psw=? where id=?";
        String sql2 = "select * from mybatis.user";
        Object[] objects = new Object[3];
        objects[0] = "钱";
        objects[1] = "334";
        objects[2] = 6;
        jdbcTemplate.update(sql, objects);
        return jdbcTemplate.queryForList(sql2);
    }
}
