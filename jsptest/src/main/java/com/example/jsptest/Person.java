package com.example.jsptest;

/**
 * @author dzx
 * @data 2021/10/8 -16:58
 */
public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    public int getAge() {
        return 17;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
