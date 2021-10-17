package com.example.Servlettest; /**
 * @author dzx
 * @data 2021/10/6 -21:04
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        System.out.println("在Servlet1中查看请求:"+username);
//        设置flag来判定Servlet是否收到请求
        request.setAttribute("flag", 1);
//        调用其他Servlet程序,s:服务器地址/工程名/资源名
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
//        向其他Servlet发送请求
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
