package com.example.book.dao;

import com.example.book.pojo.OrderItem;

/**
 * @author dzx
 * @data 2021/10/14 -19:28
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao{
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_count`,`oder_id`)values(?,?,?,?,?)";
        return updata(sql, orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
