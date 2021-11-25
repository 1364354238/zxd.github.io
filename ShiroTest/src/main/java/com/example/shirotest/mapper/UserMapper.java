package com.example.shirotest.mapper;

import com.example.shirotest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author dzx
 * @data 2021/11/22 -15:55
 */
@Mapper
@Repository
public interface UserMapper {
    public User updateUser(User user);

    public Collection<User> queryUserList();

    User queryUserByName(String username);
}
