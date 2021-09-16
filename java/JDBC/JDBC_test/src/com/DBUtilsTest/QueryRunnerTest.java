package com.DBUtilsTest;

import com.bean.Customers;
import com.test.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Map;


/**
 * @author dzx
 * @date 2021/9/16 -11:34
 */
public class QueryRunnerTest {
//    插入
    @Test
    public void testInsert() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection con = JDBCUtils.getDruidConnection();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        int insertCount = runner.update(con, sql, "cai", "324@163", "19990919");
        System.out.println("修改的条数：" + insertCount);
    }
// 查询单条数据
    @Test
    public void testSelect() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection con = JDBCUtils.getDruidConnection();
        String sql = "select id,name,birth from customers where id=?";
//        ResultSetHandler接口的实现类,用于封装表中的一条记录
        BeanHandler<Customers> handler = new BeanHandler<>(Customers.class);
//        以键值对的形式返回
        MapHandler handler1 = new MapHandler();
        Customers customers = runner.query(con,sql, handler,16);
        Map<String,Object> map= runner.query(con, sql, handler1, 16);
        System.out.println(customers);
        System.out.println(map);
    }
//查询多条记录
    @Test
    public void testSelectMore() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection con = JDBCUtils.getDruidConnection();
        String sql = "select id,name,birth from customers where id<?";
    //        ResultSetHandler接口的实现类,用于封装表中的多条记录
        BeanListHandler<Customers> handler = new BeanListHandler<>(Customers.class);
        List<Customers> customers = runner.query(con,sql, handler,4);
        //        以键值对的形式返回
        MapListHandler handler1 = new MapListHandler();
        List<Map<String,Object>> list= runner.query(con,sql, handler1,4);
        list.forEach(System.out::println);
        customers.forEach(System.out::println);
    }
//    查询表中特殊值:count(*)
    @Test
    public void testSelect2() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection con = JDBCUtils.getDruidConnection();
        String sql = "select count(*) from customers ";
        ScalarHandler handler = new ScalarHandler();
        //        以键值对的形式返回
        long num= (long) runner.query(con, sql, handler);
        System.out.println(num);
    }
//    自定义ResultSetHandler类
    @Test
    public void testSelect3() throws Exception{
        QueryRunner runner = new QueryRunner();
        Connection con = JDBCUtils.getDruidConnection();
        String sql = "select name,photo from customers where id=? ";
//        自定义
        ResultSetHandler<Customers>handler=new ResultSetHandler<Customers>() {
            @Override
            public Customers handle(ResultSet resultSet) {
                try {
                    if(resultSet.next()){
                        String name = resultSet.getString(1);
                        Blob photo = resultSet.getBlob(2);
                        System.out.println(name);
                        InputStream is = photo.getBinaryStream();
                        FileOutputStream fos = new FileOutputStream("test2.png");
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len=is.read(buffer))!=-1){
                            fos.write(buffer,0,len);
                        }
                        is.close();
                        fos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        //        以键值对的形式返回
        runner.query(con, sql, handler,16);

    }
}
