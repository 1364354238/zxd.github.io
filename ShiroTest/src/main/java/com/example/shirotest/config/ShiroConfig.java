package com.example.shirotest.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dzx
 * @data 2021/11/22 -10:57
 */

@Configuration
public class ShiroConfig {
//   1. 创建 realm 对象，需要自定义对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
//    2. 创建securityManager安全管理器
    @Bean(name="securityManager2")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

//   3. 创建shiro工厂
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager2")DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        关联安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//        添加过滤器
        /*
        anon:无需认证就能访问
        authc:必须认证了才能访问
        user：必须拥有"记住我"才能访问
        perms:必须拥有对某个资源的权限才能访问
        role：拥有某个角色的权限
         */
        Map<String, String> map = new LinkedHashMap<>();
//        map.put("/shiro/*", "authc");
//        perms[user:add],user用户，add权限，
        map.put("/shiro/add", "perms[user:add]");
        map.put("/shiro/update", "perms[user:update]");
        System.out.println("你好");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/unauthorized");
//        设置登陆的请求
        shiroFilterFactoryBean.setLoginUrl("/shiro/toLogin");
        return shiroFilterFactoryBean;
    }


}
