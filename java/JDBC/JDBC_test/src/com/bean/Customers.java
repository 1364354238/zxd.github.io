package com.bean;

import java.util.Date;

/**
 * @author dzx
 * @date 2021/9/14 -15:22
 * 一个数据表对应一个类
 * 一条记录对应一个对象
 * 一个字段对应java类的一个属性
 */
public class Customers {
    private int id;
    private String name;
    private String email;
    private Date birth;


    public Customers(int id, String name, String email, Date birth) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customers() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
