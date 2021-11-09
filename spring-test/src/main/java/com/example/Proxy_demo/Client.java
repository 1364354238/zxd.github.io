package com.example.Proxy_demo;

/**
 * @author dzx
 * @data 2021/10/22 -14:13
 */
public class Client {
    public static void main(String[] args) {
//        真实类
        PojoTestImpl pojoTest = new PojoTestImpl();
//        生成代理类的类
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
//        设置要代理的类
        proxyInvocationHandler.setTarget(pojoTest);
//        动态生成代理接口
        PojoTest pojoTest1 = (PojoTest) proxyInvocationHandler.getProxy();
        pojoTest1.add();


    }
}
