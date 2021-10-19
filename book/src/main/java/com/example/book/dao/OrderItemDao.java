package com.example.book.dao;

import com.example.book.pojo.Order;
import com.example.book.pojo.OrderItem;

/**
 * @author dzx
 * @data 2021/10/14 -19:24
 */
public interface OrderItemDao {
    public int saveOrderItem(OrderItem orderItem);
}
