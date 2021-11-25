package com.example.springboot.springboottest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author dzx
 * @data 2021/11/15 -15:15
 */
//扩展SpringMVC，不能加@EnableWebMvc
@Configuration
//@EnableWebMvc //获取容器中所有的webMvcConfigure
public class MyMvcConfig implements WebMvcConfigurer {


//    springboot装配视图解析器
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

//    视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
// 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html", "/", "/user/login","/userList/**","/druid/**");
    }

    //    自定义本地化解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
//    自定义视图解析器
    public static class MyViewResolver implements ViewResolver{
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println("视图解析器");
        return null;
    }
}
}
