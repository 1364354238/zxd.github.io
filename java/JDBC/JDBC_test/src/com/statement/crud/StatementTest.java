package com.statement.crud;

import com.bean.Customers;
import com.bean.Order;
import com.test.util.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static com.test.util.JDBCUtils.*;

/**
 * @author dzx
 * @date 2021/9/13 -19:00
 * 用statement实现数据库的crud操作
 */
public class StatementTest {
//  使用Statement的弊端，需要拼写SQL语句，并存在SQL注入的问题
//    避免SQL注入问题，使用PrepareStatement取代Statement
//    PrepareStatement先预编译好SQL，然后再填充占位符
    @Test
    public void testLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String user=scanner.next();
        System.out.println("请输入密码");
        String password=scanner.next();

        String sql = "select";

    }
    @Test
    public void testInsert()  {
        PreparedStatement ps=null;
        Connection con=null;
        try {
            //        读取配置信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pro = new Properties();
            pro.load(is);
            String user= pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driverClass = pro.getProperty("driverClass");
//        加载驱动
            Class.forName(driverClass);
//        获取连接
            con = DriverManager.getConnection(url, user, password);

//        4.预编译SQL语句，获取PrepareStatement实例
            String sql="insert into customers(name,email,birth) values(?,?,?)";//?:占位符
            ps = con.prepareStatement(sql);
//        5.填充占位符,index从1开始
            ps.setString(1,"li");
            ps.setString(2,"123@163");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date date = new Date();
            ps.setString(3, sdf.format(date.getTime()));
//        6.执行操作
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//        7.资源关闭
            try {
                if(ps!=null){
                    ps.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                if(con!=null){
                    con.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    @Test
    public void TestUpdate()  {
        Connection con=null;
        PreparedStatement ps=null;
        try {
//        获取连接
         con = getConnection("jdbc.properties");
//        编译SQL语句
        String sql="update customers set name=? where id=?";
        ps = con.prepareStatement(sql);
//        填充占位符
        ps.setString(1,"wang");
        ps.setString(2,"19");
//        执行

            ps.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            //        关闭
            JDBCUtils.closeResourse(con,ps);
        }

    }
//通用增删改操作

    public void update(String sql,Object ...args)  {
        Connection con=null;
        PreparedStatement ps=null;
        try {
//        获取连接
            con = getConnection("jdbc.properties");
//        编译SQL语句
            ps = con.prepareStatement(sql);

//        填充占位符
            for(int i=0;i<args.length;i++){
                ps.setString(i+1, (String) args[i]);
            }

//        执行
            ps.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            //        关闭
            JDBCUtils.closeResourse(con,ps);
        }

    }
    @Test
    public void commentUpdate(){
        String sql="DELETE FROM customers WHERE id=?";
        update(sql, "19");
//        表名与关键字相同时加``(不是单引号)
        String sql2="update `order` set order_name=? where order_id=?";
        update(sql2,"DD","4");

    }

//查询操作
    @Test
    public void testSelect() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            String properties = "jdbc.properties";
            con = JDBCUtils.getConnection(properties);
            String sql = "select id,name,email,birth from customers where id=?";
            ps = con.prepareStatement(sql);
//            填充占位符
            ps.setString(1,"1");
//       执行并返回结果集
            resultSet = ps.executeQuery();
//        处理结果集
            if(resultSet.next()){//判断结果集下一条是否有数据，如果有数据则指针下移
    //            获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

    //            将数据封装为一个对象
                Customers customer = new Customers(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            //        关闭资源
            JDBCUtils.closeResourse(con, ps,resultSet);
        }






    }

// 通用查询操作
    public void select(Class<?> cls,String sql,Object ...args) {
        String properties="jdbc.properties" ;
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection(properties);
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setString(i+1,(String) args[0]);
            }
            resultSet = ps.executeQuery();
//            获取结果集的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
//            通过原数据获取列数
            int columnCount = rsmd.getColumnCount();
            if (resultSet.next()){
//                获取表对应的类
//                Class<?> cls = Class.forName(table);
//                创建对象
                Object tableInstance =  cls.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i+1);
//                    获取每个列的列名
//                    String columnName = rsmd.getColumnName(i+1);
//                    获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);
//                    找到指定列对应的属性
                    Field field = cls.getDeclaredField(columnName);
                    field.setAccessible(true);
//                    给对象指定属性赋值
                    field.set(tableInstance,columnValue);

                }
                System.out.println(tableInstance);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResourse(con, ps, resultSet);
        }
    }
//    返回多行查询结果
    public <T> List<?> selectMore(Class<T> cls, String sql, Object ...args) {
        String properties="jdbc.properties" ;
        Connection con = null;
        PreparedStatement ps= null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection(properties);
            ps = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[0]);
            }
            resultSet = ps.executeQuery();
    //            获取结果集的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
    //            通过原数据获取列数
            int columnCount = rsmd.getColumnCount();
            List<T> l = new ArrayList<>();
            while (resultSet.next()){
    //                获取表对应的类
    //                Class<?> cls = Class.forName(table);
    //                创建对象
                T tableInstance =  cls.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i+1);
    //                    获取每个列的列名
    //                    String columnName = rsmd.getColumnName(i+1);
    //                    获取列的别名
                    String columnName = rsmd.getColumnLabel(i + 1);
    //                    找到指定列对应的属性
                    Field field = cls.getDeclaredField(columnName);
                    field.setAccessible(true);
    //                    给对象指定属性赋值
                    field.set(tableInstance,columnValue);

                }
                l.add(tableInstance);
            }
            return l;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResourse(con, ps, resultSet);
        }
        return null;

    }
    @Test
    public void commentSelect(){
        String sql = "select id,name,email from customers where id=?";
        select(com.bean.Customers.class,sql,"1");
//        表字段名与类属性名不一致时，取别名。
        String sql2 = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id=?";
        select(com.bean.Order.class,sql2,"1");
//        查询结果有多行
        String sql3 = "select id,name,email from customers where id<?";
        List<Customers> l = (List<Customers>) selectMore(Customers.class, sql3, 12);
        l.forEach(System.out::println);
    }
}
