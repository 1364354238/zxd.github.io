package com.statement.crud;

import com.test.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dzx
 * @date 2021/9/15 -10:48
 * PrepareStatement可以进行高效的批量操作
 * update，delete本身具有批量操作的效果
 * insert不行
 */

public class BatchOperation {
//    方式一：循环
    @Test
    public void TestInsert() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String properties = "jdbc.properties";
            con = JDBCUtils.getConnection(properties);
            String sql = "insert into user(name) values(?)";
//            SQL预编译后数据库会将他缓存下来，下次执行相同的预编译语句就不用编译了
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 20; i++) {
                ps.setString(1,"name_"+i);
                ps.execute();
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,ps);
        }
    }
//    方法二：批处理
//    MySQL是默认关闭批处理的，我们需要通过一个参数让MySQL开启批处理，在URL后加&&rewriteBatchedStatements=true;(8.0不用)
    @Test
    public void TestInsert2() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String properties = "jdbc.properties";
            con = JDBCUtils.getConnection(properties);
            String sql = "insert into user(name) values(?)";
    //            SQL预编译后数据库会将他缓存下来，下次执行相同的预编译语句就不用编译了
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 20; i++) {
                ps.setString(1,"name_"+i);
//                攒SQL
                ps.addBatch();
                if((i+1)%10!=0){
//                    执行batch
                    ps.executeBatch();
//                    清空batch
                    ps.clearBatch();
                }

            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,ps);
        }
    }
//    方式三：
@Test
    public void TestInsert3() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String properties = "jdbc.properties";
            con = JDBCUtils.getConnection(properties);
//            设置不允许自动提交
            con.setAutoCommit(false);
            String sql = "insert into user(name) values(?)";
            //            SQL预编译后数据库会将他缓存下来，下次执行相同的预编译语句就不用编译了
            ps = con.prepareStatement(sql);
            for (int i = 0; i < 20; i++) {
                ps.setString(1,"name_"+i);
    //                攒SQL
                ps.addBatch();
                if((i+1)%10!=0){
    //                    执行batch
                    ps.executeBatch();
    //                    清空batch
                    ps.clearBatch();
                }

            }
//            统一提交数据
            con.commit();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResourse(con,ps);
        }
    }
}
