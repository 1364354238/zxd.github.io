package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/7 -19:57
 */

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String passwprd = request.getParameter("password");
        if(userService.login(new User(null, username, passwprd, null))==null){
            System.out.println("登陆失败");
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }

    }
}
