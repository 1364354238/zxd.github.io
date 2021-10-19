#Filter的使用步骤
- 1、编写一个类去实现Filter 接口
- 2、实现过滤方法doFilter()
- 3、到web.xml 中去配置Filter 的拦截路径
- 4.在web.xml设置该类所拦截的地址范围
```xml
 <filter-mapping>
        <filter-name>adminFilter</filter-name>
        <url-pattern>/admin/*</url-pattern>
    </filter-mapping>
```

#Filter的生命周期
Filter的生命周期包含的方法：
- 1.构造器方法：
- 2.init：初始化，1,2步在web工程启动时执行
- 3.doFilter：每次收到拦截请求，就会执行，
- 4.destroy：web工程停止的时候就会执行

#FilterConfig类
> Filter的配置文件类，Tomcat每次创建Filter的时候都会创建一个FilterConfig类，作用是：
- 1.获取Filter的名称<filter-name>
- 2.获取Filter中配置的init-param参数
- 3.获取ServletContext对象

# chain.doFilter
- 一般在不满足拦截条件后执行
- 执行后，先判断是否有下一个Filter执行(如果拦截地址相同，执行顺序由web.xml的上下顺序），然后执行后置代码

#多个Filter过滤器执行的特点
- 1.它们都是和目标资源默认在同一个线程当中
- 2.它们都是同一个请求对象

#Filter过滤器拦截地址 <url-pattern>
- 精确匹配：/a.jsp  ---> http://ip:port/工程路径/a.jsp
- 目录匹配:/admin/* ---> http://ip:port/工程路径/admin/*
- 后缀名匹配：*.html ---> 请求地址(?之前)必须以.html结尾