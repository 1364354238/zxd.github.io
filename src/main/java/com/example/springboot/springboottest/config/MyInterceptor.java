package com.example.springboot.springboottest.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dzx
 * @data 2021/11/16 -9:28
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登陆成功之后应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
