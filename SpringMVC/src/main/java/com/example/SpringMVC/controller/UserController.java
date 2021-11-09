package com.example.SpringMVC.controller;

import com.example.SpringMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dzx
 * @data 2021/10/29 -15:37
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(String name, Model model){
//        接受前端参数
        System.out.println("前端参数："+name);
//      将结果传给前端
        model.addAttribute("msg", name);
        return "hello";
    }
//    前端接受一个对象
    @GetMapping("/t2")
    public String test2(User user, Model model){
//        接受前端参数
        System.out.println("前端参数："+user);
//      将结果传给前端
        model.addAttribute("msg", user);
        return "hello";
    }
}
