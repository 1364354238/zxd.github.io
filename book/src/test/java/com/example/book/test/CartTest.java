package com.example.book.test;

import com.example.book.pojo.Cart;
import com.example.book.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author dzx
 * @data 2021/10/14 -15:51
 */
public class CartTest {
    Cart cart = new Cart();
    @Test
    public void addItem() {
        cart.addItem(new CartItem(1, "2", 2, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "2", 3, new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
    }
}