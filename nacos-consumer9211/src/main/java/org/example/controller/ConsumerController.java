package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author dzx
 * @package org.example.controller
 * @project alibaba-cloud
 * @date 2022/1/6 -18:19
 */
@RestController
public class ConsumerController {
    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/check")
    public String check(){
        return restTemplate.getForObject("http://alibaba-provider-payment/payment/check",String.class);
    }
}
