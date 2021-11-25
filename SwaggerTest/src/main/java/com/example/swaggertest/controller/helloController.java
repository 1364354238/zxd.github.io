package com.example.swaggertest.controller;

import com.example.swaggertest.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dzx
 * @data 2021/11/23 -20:18
 */
@Controller
@RequestMapping("/swagger")
public class helloController {
    @RequestMapping("/hello")
    @ResponseBody
    public User hello(){
        return new User();
    }
}
