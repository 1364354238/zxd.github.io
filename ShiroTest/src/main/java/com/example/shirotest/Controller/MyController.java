package com.example.shirotest.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dzx
 * @data 2021/11/22 -10:08
 */
@Controller
@RequestMapping("/shiro")
public class MyController {
    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
    @RequestMapping({"/add"})
    public String add(){
        return "user/add";
    }
    @RequestMapping({"/update"})
    public String update(){
        return "user/update";
    }
    @RequestMapping({"/login"})
    public String login(String username, String password, Model model){
//        获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //       令牌 封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        System.out.println("登录"+username);
//      执行登录
        try {
            subject.login(usernamePasswordToken);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg", "用户名不存在");
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg", "密码错误");
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }
    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "login";
    }

    @RequestMapping({"/unauthorized"})
    @ResponseBody
    public String unauthorized(){
        return "未经授权401";
    }
}
