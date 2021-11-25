package com.example.springboot.springboottest.config;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author dzx
 * @data 2021/11/15 -20:25
 */
//本地化解析器
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获取请求中的默认语言
        String language=request.getParameter("language");
//        如果没有就是用默认的
        Locale locale = Locale.getDefault();
//
        if(!ObjectUtils.isEmpty(language)){
            String[] split = language.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
