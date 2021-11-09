package com.example.mybatis_demo;

import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -10:37
 */
public class UserMapperImpl implements UserDao{
    private SqlSessionTemplate sessionTemplate;
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }


    @Override
    public List<User> selectUser() {
        UserDao userDao = sessionTemplate.getMapper(UserDao.class);
        return userDao.selectUser();
    }
}
