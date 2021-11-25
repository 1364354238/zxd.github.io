package com.example.shirotest.config;

import com.example.shirotest.pojo.User;
import com.example.shirotest.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dzx
 * @data 2021/11/22 -10:58
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserServiceImpl userService;
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        User p = (User) subject.getPrincipal();
//        设置当前业务的权限
        info.addStringPermission(p.getPerms());
        return info;
    }

//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        连接真实的数据库
//        用户名验证
        User user = userService.queryUserByName(usernamePasswordToken.getUsername());
        System.out.println("执行了认证"+user);
        if(user==null){
            return null;//抛出异常
        }
        //密码验证，将数据存到对象当中
        return new SimpleAuthenticationInfo(user,user.getPsw(),"");
    }
}
