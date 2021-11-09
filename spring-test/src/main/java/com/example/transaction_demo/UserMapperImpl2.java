package com.example.transaction_demo;

import com.example.transaction_demo.User;
import com.example.transaction_demo.UserMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -11:07
 */
public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUser() {
        return getSqlSession().getMapper(UserMapper.class).selectUser();
    }
}
