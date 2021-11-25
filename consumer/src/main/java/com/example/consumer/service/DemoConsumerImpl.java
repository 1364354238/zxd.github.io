package com.example.consumer.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author dzx
 * @data 2021/11/24 -20:40
 */
@Service
public class DemoConsumerImpl {
    @DubboReference
    DemoProvider provider;//接口名（包路径）要和提供者一样
    public void sayHello(){
        String ans = provider.hello();
        System.out.println("在注册中心拿到的："+ans);
    }
}
