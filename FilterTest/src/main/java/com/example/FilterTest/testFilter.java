package com.example.FilterTest; /**
 * @author dzx
 * @data 2021/10/15 -10:47
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "testFilter")
public class testFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("f2s");
        chain.doFilter(request, response);
        System.out.println("f2e");
    }
}
