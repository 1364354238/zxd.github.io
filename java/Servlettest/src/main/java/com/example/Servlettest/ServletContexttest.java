package com.example.Servlettest; /**
 * @author dzx
 * @data 2021/10/6 -18:18
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ServletContexttest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletContext();
        String username = servletContext.getInitParameter("userContext");
        System.out.println(username);
        servletContext.setAttribute("userContext","rootContext444");
        System.out.println(servletContext.getAttribute("userContext"));
//  - 获取当前的工程路径，格式：/工程路径
        String path = servletContext.getContextPath();
        System.out.println("工程路径"+path);
//  - 获取工程部署后在服务器硬盘上的绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("真实路径：" + realPath);
//  - 像Map一样存取数据
//        servletContext.setInitParameter("url", "localhost:8080");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
