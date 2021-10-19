package com.example.FilterTest; /**
 * @author dzx
 * @data 2021/10/14 -20:54
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "adminFilter")
public class adminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        System.out.println("f1s");
//        =null代表没有登陆
        if (user==null){
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }else{
//            让程序继续往下访问
            chain.doFilter(request,response);
            System.out.println("f1e");
        }
    }
}
