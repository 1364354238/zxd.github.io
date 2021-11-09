package com.example.mybatis_demo;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -9:51
 */
public interface UserDao {
    List<User> selectUser();
}
