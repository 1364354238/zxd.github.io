package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/12 -11:34
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
import java.util.List;

@WebServlet(name = "BookServlet", value = "/manager/BookServlet")
public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 处理分页内容
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取请求参数的pageSize和pageNo
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.getPageSize());
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/BookServlet?action=page");
        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      将请求对象封装成Bean对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//        保存图书
        bookService.addBook(book);
//        响应，跳转到图书列表页面
        response.sendRedirect(request.getContextPath()+"/manager/BookServlet?action=page&pageNo="+(WebUtils.parseInt(request.getParameter("pageNo"),0)+1));
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取删除的id
        bookService.deleteBookById(Integer.parseInt((request.getParameter("id"))));
//        重定向
        response.sendRedirect(request.getContextPath()+"/manager/BookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
    //    保存要修改的图书的信息
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.upadateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/BookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
//    获取要修改的图书的信息
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Book book=bookService.queryBookById(Integer.parseInt((request.getParameter("id"))));
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
//        把图书信息保存到request域
        request.setAttribute("books", books);
//        请求转发到客户端
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
