package com.example.AOP_demo;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author dzx
 * @data 2021/10/22 -19:23
 */
public class BeforeLog implements MethodBeforeAdvice {
    /**
     *
     * @param method:目标对象的方法
     * @param args:输入参数
     * @param target：目标对象
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("我在"+target.getClass().getName()+"之前");
    }
}
