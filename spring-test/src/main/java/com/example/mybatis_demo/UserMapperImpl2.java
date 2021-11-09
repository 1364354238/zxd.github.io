package com.example.mybatis_demo;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -11:07
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserDao {
    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserDao.class).selectUser();
    }
}
