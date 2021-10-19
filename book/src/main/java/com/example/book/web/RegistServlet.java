package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/7 -18:30
 */

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistServlet", value = "/RegistServlet")
public class RegistServlet extends HttpServlet {
//    连接Service层
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        获取请求信息
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String repwd = request.getParameter("repwd");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
//        检查验证码
        if ("abcde".equalsIgnoreCase(code)) {
            if(userService.existUsername(username)){
                System.out.println("用户名已存在");
                request.setAttribute("msg", "用户名已存在");
                request.setAttribute("username", username);
                request.setAttribute("email",email);
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else{
                if(password.equals(repwd)){
                    userService.registUser(new User(null, username, password, email));
                    System.out.println("注册成功");
                    request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
                }else{
                    System.out.println("密码不一致");
                    request.setAttribute("msg", "密码不一致");
                    request.setAttribute("username", username);
                    request.setAttribute("email",email);
                    request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
                }
            }
        }else{
            System.out.println("验证码错误");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

        }
    }
}
