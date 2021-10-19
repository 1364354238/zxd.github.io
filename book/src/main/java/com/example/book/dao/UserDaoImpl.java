package com.example.book.dao;

import com.example.book.pojo.User;

/**
 * @author dzx
 * @date 2021/10/7 -17:39
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select username,password,email from t_user where username=?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "Insert into t_user(username,password,email) values(?,?,?)";
        return updata(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndpw(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class, sql, username,password);
    }
}
