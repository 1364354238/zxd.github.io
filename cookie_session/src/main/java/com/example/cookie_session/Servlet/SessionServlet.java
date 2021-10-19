package com.example.cookie_session.Servlet; /**
 * @author dzx
 * @data 2021/10/13 -20:25
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SessionServlet", value = "/SessionServlet")
public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        boolean isNew =session.isNew();
        String id = session.getId();
        response.getWriter().write(id+isNew);
        HttpSession session1 = request.getSession();
        response.getWriter().write(session1.getId()+session1.isNew());
    }
//    与数据的存取
    protected void setSAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("key","v");
        response.getWriter().write("yes");
    }
    protected void getSAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("key");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(""+obj);
    }
    protected void getLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        response.getWriter().write(""+session.getMaxInactiveInterval());
    }
}
