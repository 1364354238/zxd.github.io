package com.example.AOP_demo;

/**
 * @author dzx
 * @data 2021/10/23 -15:35
 */
public class DivPointcut {
    public void before(){
        System.out.println("之前");
    }
    public void after(){
        System.out.println("之后");
    }
}
