package com.example.securitytest.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author dzx
 * @data 2021/11/17 -19:55
 */
//开启security
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        首页所有人可以访问，功能页只有对应权限的人才能访问
        http.authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
//        没有权限会默认跳转到登录页面,需要开启登录页面--------loginPage:定制登录页面-----loginProcessingUrl:登陆成功提交页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");
//        开启注销功能，并设置注销后跳到首页
        http.logout().logoutSuccessUrl("/");
//        防止网站工具：get，post
        http.csrf().disable();//关闭crsf功能（登陆失败的可能原因）
        //       或者 过滤
        http.csrf().ignoringAntMatchers("/druid/*");
//        开启“记住我” 功能,本地cookie，默认14天,rememberMeParameter:接受前端参数
        http.rememberMe().rememberMeParameter("rememberMe");

    }

//    认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        这些数据正常要从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())//密码加密
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123")).roles("vip2", "vip3").and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("321")).roles("vip1", "vip2", "vip3");
    }
}
