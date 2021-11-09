package com.example.Proxy_demo;

/**
 * @author dzx
 * @data 2021/10/22 -14:12
 */
public class PojoTestImpl implements PojoTest {
    public void add(){
        System.out.println("增加");
    }
    public void delete(){
        System.out.println("删除");
    }
    public void select(){
        System.out.println("查找");
    }
    public void update(){
        System.out.println("修改");
    }
}
