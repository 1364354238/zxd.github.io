package com.example.transaction_demo;

import com.example.transaction_demo.User;

import java.util.List;

/**
 * @author dzx
 * @data 2021/10/26 -12:24
 */
public interface UserMapper {
    List<User> selectUser();
}
