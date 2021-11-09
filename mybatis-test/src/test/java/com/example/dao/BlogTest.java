package com.example.dao;

import com.example.pojo.Blog;
import com.example.utils.IDUtils;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author dzx
 * @data 2021/11/5 -10:15
 */
public class BlogTest {
    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        blogMapper.insertBlog(new Blog(IDUtils.getID(), "mybatis简单", "李", new Date(), 9676));
        blogMapper.insertBlog(new Blog(IDUtils.getID(), "java简单", "王", new Date(), 9676));
        blogMapper.insertBlog(new Blog(IDUtils.getID(), "Spring简单", "赵", new Date(), 9676));
        blogMapper.insertBlog(new Blog(IDUtils.getID(), "微服务简单", "钱", new Date(), 9676));
        session.commit();
        session.close();
    }
    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
//        map.put("author", "李");
//        map.put("title", "mybatis简单");
        blogMapper.queryBlogIF(map).forEach(System.out::println);
        session.commit();
        session.close();
    }
//    choose
    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("author", "王");
        map.put("title", "mybatis简单");
        blogMapper.queryBlogChoose(map).forEach(System.out::println);
        session.commit();
        session.close();
    }
    //    set
    @Test
    public void test4(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
//        map.put("author", "王");
        map.put("title", "mybatis简单3");
        map.put("id", "acbbab25343e43968c441d951557840a");
        blogMapper.updateBlog(map);
        session.commit();
        session.close();
    }
    //    foreach
    @Test
    public void test5(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        SqlSession session2 = MybatisUtils.getSqlSession();
        Map<String, List> map = new HashMap<>();
        List<String> l = new ArrayList<>();
        l.add("583654e880544e10a4c03f83603eb31d");
        l.add("acbbab25343e43968c441d951557840a");
        l.add("ad7aafad59ce4b2692e49813f43a724f");
        map.put("ids", l);
        blogMapper.queryBlogIn(map).forEach(System.out::println);
        session.commit();
        session.close();

        BlogMapper blogMapper2 = session2.getMapper(BlogMapper.class);
        blogMapper2.queryBlogIn(map).forEach(System.out::println);
        session2.commit();
        session2.close();
    }

}
