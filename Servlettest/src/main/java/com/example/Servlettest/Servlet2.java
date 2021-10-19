package com.example.Servlettest; /**
 * @author dzx
 * @data 2021/10/6 -21:05
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        System.out.println("在Servlet2中查看请求:"+username);
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        System.out.println("Servlet1是否收到请求："+request.getAttribute("flag"));
        request.getRequestDispatcher("/test1.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
