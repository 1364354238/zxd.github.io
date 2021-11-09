package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dzx
 * @data 2021/11/8 -18:08
 */
@Controller
public class AjaxController {
    @RequestMapping("a1")
    public void ajax1(String name, HttpServletResponse response) throws IOException{
        System.out.println(name);
        if("admin".equals(name)){
            response.getWriter().write("true");
        }else{
            response.getWriter().write("false");
        }
    }
}
