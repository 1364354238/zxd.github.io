package com.example.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dzx
 * @data 2021/10/27 -11:16
 */
@Controller
public class HelloController {
//    mvc注解，指定接受的URL，真实访问地址：项目名/hello
//    如果对类使用，真实访问地址：项目名/类/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        System.out.println("fangwen");
//        封装数据
        model.addAttribute("msg", "hello,msg");
//        返回给视图解析器
        return "hello";

    }
}
