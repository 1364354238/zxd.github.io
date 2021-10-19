package com.example.book.service;

import com.example.book.pojo.Cart;

/**
 * @author dzx
 * @data 2021/10/14 -19:46
 */
public interface OrderServicve {
    public String createOrder(Cart cart, Integer userId);
}
