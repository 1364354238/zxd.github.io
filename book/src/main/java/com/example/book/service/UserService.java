package com.example.book.service;

import com.example.book.pojo.User;

/**
 * @author dzx
 * @date 2021/10/7 -18:06
 */
public interface UserService {
    //    注册
    public void registUser(User user);

    //    登录
    public User login(User user);

    //    检查用户名是否可用
    public boolean existUsername(String username);
}
