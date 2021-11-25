package com.example.springboot.springboottest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author dzx
 * @data 2021/11/15 -21:02
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(String username, String password, Model model, HttpSession session){
        if("123".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        model.addAttribute("msg", "登陆失败");
        return "index";
    }
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
