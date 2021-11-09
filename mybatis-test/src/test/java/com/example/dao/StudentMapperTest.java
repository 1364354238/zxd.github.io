package com.example.dao;

import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author dzx
 * @data 2021/11/4 -16:13
 */
public class StudentMapperTest {
    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.selectAll().forEach(System.out::println);
        session.close();
    }
//    查询嵌套
    @Test
    public void test2(){
        SqlSession session = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.selectSAndT().forEach(System.out::println);
        session.close();
    }

}
