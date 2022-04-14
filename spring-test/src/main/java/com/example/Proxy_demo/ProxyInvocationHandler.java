package com.example.Proxy_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dzx
 * @data 2021/10/22 -14:08
 */
public class ProxyInvocationHandler implements InvocationHandler  {
//    被代理的类
    private Object target;
//

    public void setTarget(Object target) {
        this.target = target;
    }
//    生成代理接口对象，实现接口类由this决定
    public Object getProxy(){
        System.out.println( "代理的对象"+target.getClass());
        System.out.println("代理类"+this.getClass());
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

//    处理代理实例，并返回结果

    /**
     *
     * @param proxy:class com.sun.proxy.$Proxy0,代理接口对象
     * @param method：调用真实对象的方法对应的Method
     * @param args：调用方法传递的参数
     * @return：方法返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理的类的接口"+proxy.getClass());
        System.out.println("方法"+method.getName());
        Object result = method.invoke(target, args);
        return result;
    }
}
