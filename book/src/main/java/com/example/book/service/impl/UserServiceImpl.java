package com.example.book.service.impl;

import com.example.book.dao.UserDao;
import com.example.book.dao.UserDaoImpl;
import com.example.book.pojo.User;
import com.example.book.service.UserService;

/**
 * @author dzx
 * @date 2021/10/7 -18:13
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        if (existUsername(user.getUsername())){
            return;
        }
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndpw(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        return userDao.queryUserByUsername(username)!=null;
    }
}
