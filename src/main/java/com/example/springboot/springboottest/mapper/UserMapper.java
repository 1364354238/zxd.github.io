package com.example.springboot.springboottest.mapper;

import com.example.springboot.springboottest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/17 -16:32
 */

@Mapper//表示这是一个mybatis的mapper类
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
