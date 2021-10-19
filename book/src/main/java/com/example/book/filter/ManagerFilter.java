package com.example.book.filter; /**
 * @author dzx
 * @data 2021/10/16 -11:34
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ManagerFilter")
public class ManagerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        Object user = servletRequest.getSession().getAttribute("user");
        if(user==null){
            servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else{
            chain.doFilter(request, response);
        }
    }
}
