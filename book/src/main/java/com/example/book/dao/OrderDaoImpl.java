package com.example.book.dao;

import com.example.book.pojo.Order;

/**
 * @author dzx
 * @data 2021/10/14 -19:24
 */
public class OrderDaoImpl extends BaseDao implements OrderDao{
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return updata(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }
}
