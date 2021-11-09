package com.example.SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author dzx
 * @data 2021/10/29 -13:38
 */
@Controller
public class RestFulTest {
    @RequestMapping("/restful/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }

    @PostMapping(value="/post/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }
    @GetMapping(value="/post/{a}/{b}")
    public String test3(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }
    @GetMapping(value="/redirect/{a}/{b}")
    public String test4(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "redirect:/index.jsp";
    }
    @PostMapping(value="/post")
    public String test2(String name,Model model) {
        System.out.println(name);
        model.addAttribute("msg", "结果为" + name);
        return "hello";
    }
}
