package com.example.book.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author dzx
 * @data 2021/10/14 -15:18
 */
public class Cart {
    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + gettotalPrice() +
                ", items=" + items +
                '}';
    }


//    key是商品编号
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    public Integer getTotalCount() {
        Integer totalCount=0;
        for (Map.Entry<Integer,CartItem>entry:items.entrySet()){
            CartItem cartItem = entry.getValue();
            totalCount += cartItem.getCount();

        }
        return totalCount;
    }
    public BigDecimal gettotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry:items.entrySet()){
            CartItem cartItem = entry.getValue();
            totalPrice = totalPrice.add(cartItem.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    //    添加商品项
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());
        if(item!=null){
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }else{
            items.put(cartItem.getId(),cartItem);
        }
    }
    /**
     * 删除商品项
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }
    /**
     *清空购物车
     */
    public void clear(){
        items.clear();
    }
    /**
     * 修改商品数量
     */
    public void updateCount(Integer id,Integer count) {
        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
}
