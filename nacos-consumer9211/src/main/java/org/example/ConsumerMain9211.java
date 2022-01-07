package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author dzx
 * @package org.example
 * @project alibaba-cloud
 * @date 2022/1/6 -18:16
 */
@SpringBootApplication

public class ConsumerMain9211 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain9211.class, args);
    }
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
