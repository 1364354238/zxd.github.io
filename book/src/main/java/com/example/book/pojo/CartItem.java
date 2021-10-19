package com.example.book.pojo;

import java.math.BigDecimal;

/**
 * @author dzx
 * @data 2021/10/14 -13:18
 */
public class CartItem {
    private String name;
    private Integer id;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;

    public CartItem() {
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return price.multiply(new BigDecimal(count));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartItem( Integer id,String name,  Integer count,BigDecimal price, BigDecimal totalPrice) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
        this.totalPrice = getTotalPrice();
    }
}
