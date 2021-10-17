package com.example.JSONAndAJAXTest.json;


import com.example.JSONAndAJAXTest.pojo.Person;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dzx
 * @date 2021/10/16 -15:57
 */
public class JsonTest {
//    javaBean和JSON的互换
    @Test
    public void Test(){
        Person person = new Person(1, "李");
//        创建GSON对象实例
        Gson gson = new Gson();
//        toJson():把java对象转换为JSON字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);
//        fromJSON()：json对象转Java对象
        Person person1=gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);

    }
//    List和JSON的互换
    @Test
    public void Test2(){
        List<Person> l = new ArrayList<>();
        l.add(new Person(1, "李"));
        l.add(new Person(2, "王"));
        Gson gson = new Gson();

        System.out.println(gson.toJson(l));

        List<Person> list = gson.fromJson(gson.toJson(l), new PersonListType().getType());
        System.out.println(list);

    }
//    map和JSON的互换
    @Test
    public void Test3(){
        Map<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "李"));
        map.put(2, new Person(2, "王"));
        Gson gson = new Gson();
        Map<Integer, Person> map1 = gson.fromJson(gson.toJson(map), new PersonMapType().getType());
        System.out.println(map1);
    }
}
