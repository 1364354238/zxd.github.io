package com.example.swaggertest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author dzx
 * @data 2021/11/23 -9:42
 */
//@EnableOpenApi
@Configuration
public class SwaggerConfig {
    /**
     * 通过 createRestApi函数来构建一个DocketBean 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    //Swagger2核心配置：docket
        @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2) //指定api类型为swagger2
                .apiInfo(apiInfo())   //定义api文档配置信息
                .enable(true)   //是否启用swagger，默认true，3.0版本一般在yaml中配置
                .groupName("dzx")
                .select().apis(RequestHandlerSelectors.basePackage("com.example.swaggertest.controller"))  //指定需要扫描的controller包
//                扫描注解
                .apis(RequestHandlerSelectors.withClassAnnotation(Configuration.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                .paths(PathSelectors.any())         //所有 xxxController都需要生成,二次过滤
                .build();
    }
//        api文档详细信息
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger接口文档")
                .contact(new Contact("dzx", "url", "email")) //联系人信息
                .version("1.0.0")
                .description("api文档描述")
                .build();
    }

}
