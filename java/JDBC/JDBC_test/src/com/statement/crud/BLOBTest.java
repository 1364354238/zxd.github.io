package com.statement.crud;

import com.test.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author dzx
 * @date 2021/9/14 -21:22
 * PreparedStatement可以操作BLOB（二进制）类型，statement不行
 * 数据库使用的BOLB最大为16M
 */
public class BLOBTest {
//向数据表插入BOLB类型数据
    @Test
    public void TestInsert() {
        String sql = "Insert into customers (name,email,birth,photo) values(?,?,?,?)";
        String properties = "jdbc.properties";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet= null;
        try {
            con = JDBCUtils.getConnection(properties);
            ps = con.prepareStatement(sql);
            resultSet = ps.getResultSet();
            ResultSetMetaData resultSetMetaData = ps.getMetaData();
            ps.setString(1,"li");
            ps.setString(2,"123@163");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            ps.setString(3,simpleDateFormat.format(new Date().getTime()) );
//        将图片转换为二进制流输入
            FileInputStream fs=new FileInputStream(new File("./libs/1.png"));
            ps.setBlob(4, fs);
            ps.execute();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResourse(con,ps,resultSet);
        }

    }
//    从数据表当中获取BLOB类型数据
    @Test
    public void TestSelect() {
        String properties = "jdbc.properties";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtils.getConnection(properties);
            String sql="select name,photo from customers where id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 20);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString(1);
                Blob photo = resultSet.getBlob(2);
                System.out.println(name);
                InputStream is = photo.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("test1.png");
                byte[] buffer = new byte[1024];
                int len;
                while ((len=is.read(buffer))!=-1){
                    fos.write(buffer,0,len);
                }
                is.close();
                fos.close();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeResourse(con,ps,resultSet);
        }


    }
}
