package com.example.Servlettest;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
//}
public class HelloServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
//        ServletConfig类的作用：
//  - 获取Servlet程序的别名servlet-name；
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
//  - 获取初始化参数init-param
        System.out.println("初始化参数名："+servletConfig.getInitParameterNames().nextElement());
        System.out.println(servletConfig.getInitParameterNames()+"的初始化参数值是："+servletConfig.getInitParameter(String.valueOf(servletConfig.getInitParameterNames())));
//  - 获取ServletContext对象
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


// service方法专门用来处理请求和响应
   @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
       System.out.println("service");
//       打印在浏览器上
       PrintWriter pw = servletResponse.getWriter();
       pw.println("hello Servlet3");
//      类型转换
       HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//       获取请求的方式
       String method = httpServletRequest.getMethod();

       if(method.equals("POST")){
           doPost();
       }else if ("GET".equals(method)){
           doGet();
       }
    }
    public void doGet(){
        System.out.println("get请求");
    }
    public void doPost(){
        System.out.println("Post请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
    public HelloServlet(){
        System.out.println("构造方法");
    }
}