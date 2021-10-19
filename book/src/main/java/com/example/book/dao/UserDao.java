package com.example.book.dao;

import com.example.book.pojo.User;

/**
 * @author dzx
 * @date 2021/10/7 -17:34
 */
public interface UserDao {

//    根据用户名查询用户信息
    public User queryUserByUsername(String username);

    //    保存用户信息
    public int saveUser(User user);
//根据用户名和密码查询用户
    public User queryUserByUsernameAndpw(String username,String password);
}
