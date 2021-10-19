package com.example.book.filter; /**
 * @author dzx
 * @data 2021/10/16 -14:42
 */

import com.example.book.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "TransactionFilter")
public class TransactionFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(request, response);
            JDBCUtils.commitAndClose();
        }catch (Exception e){
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
