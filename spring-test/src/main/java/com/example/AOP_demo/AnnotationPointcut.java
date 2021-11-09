package com.example.AOP_demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author dzx
 * @data 2021/10/23 -16:36
 */


@Component
@Aspect//标注这个类是一个切面
public class AnnotationPointcut {
    @Before("execution(* com.example.AOP_demo.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("before");
    }
    @After("execution(* com.example.AOP_demo.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("after");
    }
    @Around("execution(* com.example.AOP_demo.UserServiceImpl.*(..))")
//    加入点
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
//        获取签名
        System.out.println(joinPoint.getSignature());
//        执行方法
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
    }
}
