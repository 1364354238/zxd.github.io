package com.example.Servlettest; /**
 * @author dzx
 * @date 2021/10/7 -11:15
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "redirect", value = "/redirect")
public class redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置状态码302，表示重定向
        response.setStatus(302);
//        设置响应头，说明新地址
        response.setHeader("Location","/webapp/response");
//        方式二：
        response.sendRedirect("/webapp/response");
        System.out.println("旧地址");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
