package com.example.Servlettest; /**
 * @author dzx
 * @data 2021/10/7 -10:45
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "response", value = "/response")
public class response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        如果浏览器的字符集与响应的字符集不一致中文会乱码
//        通过响应头来修改浏览器的字符集
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        response.setCharacterEncoding("GBK");
//        方式2：同时设置浏览器和服务器的字符集(获取流对象之前才能使用）
        response.setContentType("text/html;charset=UTF-8");
        System.out.println(response.getCharacterEncoding());
        PrintWriter printWriter = response.getWriter();
        printWriter.write("hello3");
        printWriter.write("你好");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
