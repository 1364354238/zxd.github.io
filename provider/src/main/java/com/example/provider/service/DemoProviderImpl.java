package com.example.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author dzx
 * @data 2021/11/24 -20:40
 */
@DubboService
@Component
public class DemoProviderImpl implements DemoProvider {
    @Override
    public String hello() {
        return "hello，provider";
    }
}
