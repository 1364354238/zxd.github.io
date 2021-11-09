package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/10/25 -14:14
 */
//sqlSessionFactory
public class MybatisUtils {
    //    加载配置文件
    private static SqlSessionFactory sqlSessionFactory;
    static {
        InputStream inputStream = null;
        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
//            一旦创建了SQLSessionFactory后，SqlSessionFactoryBuilder()就被丢弃了
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSqlSession(){
//        最后要关闭
        return sqlSessionFactory.openSession();
    }

}
