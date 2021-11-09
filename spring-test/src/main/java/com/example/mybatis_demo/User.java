package com.example.mybatis_demo;

/**
 * @author dzx
 * @data 2021/10/23 -18:39
 */
public class User {
    private int id;
    private String name;
    private String psw;

    public User() {
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.psw = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + psw + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return psw;
    }

    public void setPwd(String pwd) {
        this.psw = pwd;
    }
}
