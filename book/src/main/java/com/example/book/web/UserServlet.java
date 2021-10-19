package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/11 -17:40
 */

import com.example.book.pojo.User;
import com.example.book.service.UserService;
import com.example.book.service.impl.UserServiceImpl;
import com.example.book.utils.WebUtils;
import com.google.gson.Gson;
import com.mysql.cj.Session;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

//    登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String passwprd = request.getParameter("password");
        User loginUser = userService.login(new User(null, username, passwprd, null));
        if(loginUser==null){
            System.out.println("登陆失败");
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }else{
            Cookie cookie = new Cookie(username, passwprd);
            response.addCookie(cookie);
            request.getSession().setAttribute("user",loginUser);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }
//    注册
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        把所有的请求参数注入到User对象中,与对象的set方法有关，键值对当中的键有对应的方法，才会赋予对象该键值对
        User user=WebUtils.copyParamToBean(request.getParameterMap(), new User());
        String username = user.getUsername();
        String password = user.getPassword();
        String repwd = request.getParameter("repwd");
        String email = user.getEmail();
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("KAPTCHA_SESSION_ANY");
//        删除Session中的验证码
        session.removeAttribute("KAPTCHA_SESSION_ANY");
        String codeUser = request.getParameter("code");
//        检查验证码
        if (code!=null&&code.equalsIgnoreCase(codeUser)) {
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
//    注销
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
//    ajax判断用户名是否存在
    protected void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean existUsername = userService.existUsername(username);
//        把结果封装为map对象
        Map<String, Object> map = new HashMap<>();
        map.put("existUsername", existUsername);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }
}
