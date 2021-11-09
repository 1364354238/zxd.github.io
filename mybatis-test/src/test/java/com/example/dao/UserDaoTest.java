package com.example.dao;

import com.example.pojo.User;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/10/25 -18:11
 */
public class UserDaoTest {
    @Test
    public void test(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> userList = userDao.userList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();

    }
    @Test
    public void test2(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> userList = userDao.getUserById(2);
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();

    }
    @Test
    public void test3(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user2 = new User(4, "赵", "324");
        userDao.insertUser(user2);
        List<User> userList = userDao.userList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
    @Test
    public void test4(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user2 = new User(4, "周", "324");
        userDao.updateUser(user2);
        List<User> userList = userDao.userList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
    @Test
    public void test5(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        User user2 = new User(4, "周", "324");
        userDao.deleteById(5);
        List<User> userList = userDao.userList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
    @Test
    public void test6(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 5);
        map.put("name", "吴");
        map.put("password", "332");
        userDao.addUser(map);
        List<User> userList = userDao.userList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
//    分页
    @Test
    public void test7(){
        SqlSession session=MybatisUtils.getSqlSession();
        UserDao userDao=session.getMapper(UserDao.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 2);
        map.put("endIndex", 3);
        List<User> userList = userDao.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
//    分页2
    @Test
    public void test8(){
        SqlSession session=MybatisUtils.getSqlSession();
        RowBounds rowBound = new RowBounds(1, 2);
        List<User> userList = session.selectList("com.example.dao.UserDao.userList", null, rowBound);
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
    @Test
    public void logTest(){
//        生成日志对象
        Logger logger=Logger.getLogger(UserDaoTest.class);
        logger.info("info:进入logTest");
        logger.debug("debug:进入logTest");
        logger.error("error:进入logTest");

    }
    @Test
    public void test9(){
        SqlSession session=MybatisUtils.getSqlSession();
        TestDao testDao = session.getMapper(TestDao.class);
        testDao.insertUser(new User(6,"王","12441"));
        List<User> userList = testDao.selectById(1);
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();

    }
}
