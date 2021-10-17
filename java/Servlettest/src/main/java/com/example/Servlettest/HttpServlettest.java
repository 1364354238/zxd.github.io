package com.example.Servlettest; /**
 * @author dzx
 * @data 2021/10/6 -20:20
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class HttpServlettest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求的资源路径
        System.out.println("URI:" + request.getRequestURI());
//        获取请求的统一资源定位符（绝对路径）
        System.out.println("URL:" + request.getRequestURL());
//        获取客户端的IP地址
        System.out.println("ip:"+request.getRemoteHost());
//        获取请求头
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            System.out.println("请求头name："+name+"---请求头value:"+request.getHeader(name));
        }
//        获取请求参数,s:对应标签属性name
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:"+username+"--密码："+password);
//        当有多个值的时候
        request.getParameterValues("username");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取请求参数,s:对应标签属性name
//        在post请求时，如果请求数据含有中文时，需要将请求字体的字符集设置为utf-8
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("用户名:"+username+"--密码："+password);
    }
}
