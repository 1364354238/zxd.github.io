package com.example.dao;

import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author dzx
 * @data 2021/11/4 -16:08
 */
public class TeacherMapperTest {
    @Test
    public void test1(){
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        teacherMapper.selectAll().forEach(System.out::println);
        session.close();
    }
    //    联表查询
    @Test
    public void test3(){
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
        teacherMapper.getStudents().forEach(System.out::println);
        session.close();
    }
}
