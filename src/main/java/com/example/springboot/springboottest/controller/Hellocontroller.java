package com.example.springboot.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzx
 * @data 2021/11/10 -20:58
 */
@Controller
public class Hellocontroller {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "你好";
    }
    @RequestMapping("a")
    public String a(Model model){
        model.addAttribute("msg", "你好");
        model.addAttribute("msg2", "<li>转义</li>");
        List<String> l = new ArrayList<>();
        l.add("123");
        l.add("2312");
        model.addAttribute("list", l);
        return "a";
    }
}
