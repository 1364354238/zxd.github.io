package com.example.pojo;

/**
 * @author dzx
 * @data 2021/10/25 -17:02
 */

public class User {
    private int id;
    private String name;
    private String psw;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }

    public User(int id, String name, String psw) {
        this.id = id;
        this.name = name;
        this.psw = psw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
