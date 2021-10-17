package com.example.JSONAndAJAXTest.servlet; /**
 * @author dzx
 * @data 2021/10/16 -16:37
 */


import com.example.JSONAndAJAXTest.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AjaxServlet", value = "/AjaxServlet")
public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        System.out.println("Ajax请求");
        Gson gson = new Gson();
        Person person = new Person(1, "李");
        String jsonString = gson.toJson(person);
        response.getWriter().write(jsonString);
    }
    protected void jqueryAjax(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        System.out.println("jquery调用了");
        Gson gson = new Gson();
        Person person = new Person(1, "李");
        String jsonString = gson.toJson(person);
        response.getWriter().write(jsonString);
    }
}
