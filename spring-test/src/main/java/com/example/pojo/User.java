package com.example.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author dzx
 * @data 2021/10/20 -15:49
 */
@Component
public class User {
    @Value("李")
    private String name;
    public User(String name) {
        this.name = name;
        System.out.println("有参");
    }

    public User() {
         System.out.println("user无参构造");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println(name);
    }
}
