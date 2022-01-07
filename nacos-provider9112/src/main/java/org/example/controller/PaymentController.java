package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzx
 * @package org.example.controller
 * @project alibaba-cloud
 * @date 2022/1/6 -18:19
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/check")
    public String check(){
        return "当前端口：" + port;
    }
}
