package com.example.book.web; /**
 * @author dzx
 * @data 2021/10/14 -20:05
 */

import com.example.book.pojo.Cart;
import com.example.book.pojo.User;
import com.example.book.service.OrderServicve;
import com.example.book.service.impl.OrderServiceImpl;
import com.example.book.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    private OrderServicve orderServicve = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("pages/user/login.jsp").forward(request,response);
            return;
        }
        int userId = user.getId();
        String orderId =orderServicve.createOrder(cart, userId);


        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
