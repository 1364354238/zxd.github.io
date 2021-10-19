package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/13 -14:55
 */

import com.example.book.pojo.Book;
import com.example.book.pojo.Page;
import com.example.book.service.BookService;
import com.example.book.service.impl.BookServiceImpl;
import com.example.book.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ClientBookServlet", value = "/Client/BookServlet")
public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.getPageSize());
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("Client/BookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if("".equals(request.getParameter("min"))||"".equals(request.getParameter("max"))){
          page(request,response);
        }else{
            int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
            int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.getPageSize());
            int min = WebUtils.parseInt(request.getParameter("min"), 0);
            int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
            Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
            page.setUrl("Client/BookServlet?action=pageByPrice&min="+min+"&max="+max);
            request.setAttribute("page",page);
            request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
        }

    }
}
