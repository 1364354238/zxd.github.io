package com.example.dao;

import com.example.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/10/25 -17:08
 */
public interface UserDao {
    List<User> userList();
    List<User> getUserById(int id);

    void insertUser(User user);
    void updateUser(User user);

    void addUser(Map<String, Object> map);
    void deleteById(int id);

    //    分页
    List<User> getUserByLimit(Map<String, Integer> map);
}
