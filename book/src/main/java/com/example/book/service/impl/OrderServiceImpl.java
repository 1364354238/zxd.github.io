package com.example.book.service.impl;

import com.example.book.dao.*;
import com.example.book.pojo.*;
import com.example.book.service.OrderServicve;

import java.util.Date;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/10/14 -19:47
 */
public class OrderServiceImpl implements OrderServicve {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart,Integer userId) {
//        创建订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.gettotalPrice(), 0, userId);
//        保存订单
        orderDao.saveOrder(order);
//        遍历购物车每一个商品转换为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartIte = entry.getValue();
            OrderItem orderItem = new OrderItem(null, cartIte.getName(), cartIte.getCount(), cartIte.getPrice(), cartIte.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book= bookDao.queryBookById(cartIte.getId());
            book.setSales(book.getSales()+ cartIte.getCount());
            book.setStock(book.getStock()- cartIte.getCount());
            bookDao.upadateBook(book);

        }
//        清空购物车
        cart.clear();
        return orderId;
    }
}
