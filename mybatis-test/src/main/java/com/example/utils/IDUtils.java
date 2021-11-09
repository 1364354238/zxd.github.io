package com.example.utils;

import com.example.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.UUID;

/**
 * @author dzx
 * @data 2021/11/5 -10:13
 */
public class IDUtils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
