package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/14 -13:45
 */

import com.example.book.pojo.Book;
import com.example.book.pojo.Cart;
import com.example.book.pojo.CartItem;
import com.example.book.service.BookService;
import com.example.book.service.impl.BookServiceImpl;
import com.example.book.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
//        利用Session获取Cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
//
        request.getSession().setAttribute("lastItem",cartItem.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }

    }
    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
            request.getSession().setAttribute("lastItem","");
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        int count = WebUtils.parseInt(request.getParameter("count"),0);
        if (cart!=null){
            cart.updateCount(id,count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"),0);
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
//        利用Session获取Cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        Gson gson = new Gson();
//        map存储商品数量和最近添加的商品名称
        Map<String, Object> map = new HashMap<>();
        map.put("lastName", cartItem.getName());
        map.put("totalCount", cart.getTotalCount());
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }
}
