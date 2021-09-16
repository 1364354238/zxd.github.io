package com.baseDao;

import com.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author dzx
 * @date  2021/9/15 -15:56
 */
public class CustomersDaoImpl extends BaseDaoTest<Customers> implements CustomerDao {
    @Override
    public void insert(Connection con, Customers cust) {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        updateWithTX(con,sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection con, String id) {
        String sql = "delete from customers where id=?";
        updateWithTX(con,sql,id);
    }

    @Override
    public void update(Connection con, Customers customers) {
        String sql = "update customers set name=?,email=?,birth=? where id=?";
        updateWithTX(con,sql,customers.getName(),customers.getEmail(),customers.getBirth());
    }

    @Override
    public Customers select(Connection con, int id) {
        String sql = "select id,name,email,birth from customers where id=?";
        Customers customer=tsCommentSelect(con,  sql, id);
        return  customer;
    }

    @Override
    public List<Customers> getAll(Connection con) {
        String sql = "select id,name,email,birth from customers ";
        List<Customers>l=selectMore(con,sql);
        return l;
    }

    @Override
    public Long getCount(Connection con) {
        String sql = "select count(*) from customers";
        return getValue(con, sql);
    }

    @Override
    public Date getMaxBirth(Connection con) {
        String sql = "select max(birth) from customers";
        return getValue(con, sql);
    }
}
