package com.baseDao;

import com.bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @author dzx
 * @date 2021/9/15 -15:46
 *  数据访问对象(Data Access Object)
 *  此接口用语规范针对customers表的常用操作
 */
public interface CustomerDao {
    void insert(Connection con, Customers cust);

    void deleteById(Connection con, String id);

    void update(Connection con, Customers customers);

    //    根据指定ID查询customer
    Customers select(Connection con, int id);

    //    查询表中所有记录
    List<Customers> getAll(Connection con);

    //    返回数据表中条目数
    Long getCount(Connection con);

    //  返回数据表中最大生日
    Date getMaxBirth(Connection con);
}
