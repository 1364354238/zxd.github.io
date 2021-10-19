package com.example.book.dao;

import com.example.book.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author dzx
 * @date 2021/10/7 -17:04
 */
public class BaseDao {
    //    使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //    update()，返回修改的行数
    public int updata(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
//            返回影响的行数
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 查询返回一个JavaBean的SQL语句
     * @param type 返回的对象类型
     * @param sql
     * @param args SQL对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T>T queryForOne(Class<T>type,String sql,Object...args){

        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
//    返回多个查询结果
    public <T> List<T> queryForList(Class<T>type, String sql, Object...args){

        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
//    执行返回一行一列的SQL语句
    public Object queryForclu(String sql, Object...args){

        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }
}
