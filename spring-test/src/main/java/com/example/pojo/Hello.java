package com.example.pojo;

/**
 * @author dzx
 * @data 2021/10/20 -15:17
 */
public class Hello {
    String str;

    public Hello(String str) {
        this.str = str;
        System.out.println("原型模式");
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
