package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dzx
 * @data 2021/11/4 -10:04
 */
public interface TestDao {
    @Select("select * from user where id=#{id}")
    public List<User> selectById(@Param("id")int id);

    @Insert("insert into user(id,name,psw) VALUES (#{id},#{name},#{psw})")
    public void insertUser(User user);
}
