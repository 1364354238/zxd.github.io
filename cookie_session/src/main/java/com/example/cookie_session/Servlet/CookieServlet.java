package com.example.cookie_session.Servlet; /**
 * @author dzx
 * @data 2021/10/13 -16:44
 */

import com.example.cookie_session.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CookieServlet", value = "/CookieServlet")
public class CookieServlet extends BaseServlet{

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        创建Cookie对象
        Cookie cookie = new Cookie("key1", "name");
        Cookie cookie2 = new Cookie("key1", "name1");
//        通知客户端保存Cookie
        response.addCookie(cookie);
        response.addCookie(cookie2);
//
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Cookie保存成功");
    }
    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取Cookie对象
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            response.getWriter().write(cookie.getName()+"="+cookie.getValue());
        }
    }
    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取指定Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
//        赋予新值,base64编码
        cookie.setValue("newName");
//        保存修改
        response.addCookie(cookie);

    }
    protected void defaultLift(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取指定Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取指定Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
//       得到工程路径
        String contextPath = request.getContextPath();
        cookie.setPath(contextPath+"/abc");
//        创建一个带有path的cookie
        response.addCookie(cookie);
    }
}
