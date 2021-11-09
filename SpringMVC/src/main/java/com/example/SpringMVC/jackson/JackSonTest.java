package com.example.SpringMVC.jackson;

import com.example.SpringMVC.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dzx
 * @data 2021/10/29 -17:34
 */
@Controller
public class JackSonTest {
    @RequestMapping(value = "/j1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        User user = new User(1, "李", 22);
//        jackson :ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String str=objectMapper.writeValueAsString(user);
//        JSON对象转java
        User user1 = objectMapper.readValue(str, User.class);
        System.out.println(user1);
        return str;
    }
    @RequestMapping(value = "/j2")
    @ResponseBody
    public String json2() throws JsonProcessingException {

        Date date = new Date();
        return JSONUtils.getJson(date);
    }
    @RequestMapping(value = "/j3")
    @ResponseBody
    public String json3() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        User user = new User(1, "李", 22);
        list.add(user);

        return JSONUtils.getJson(list);
    }
}
