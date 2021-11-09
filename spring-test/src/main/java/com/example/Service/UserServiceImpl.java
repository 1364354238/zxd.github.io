package com.example.Service;

import com.example.Dao.UserDao;
import com.example.Dao.UserDaoImpl;

/**
 * @author dzx
 * @data 2021/10/20 -14:42
 */
public class UserServiceImpl implements UserService{
    UserDaoImpl userDao;

//    利用set进行动态实现值的注入
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.add();
    }
}
