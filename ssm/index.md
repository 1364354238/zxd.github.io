# ssm整合

# 拦截器
>拦截器只会拦截访问的控制器方法， 如果访问的是jsp/html/css/image/js是不会进行拦截的
> ,拦截器是AOP思想的具体应用
- 实现implements HandlerInterceptor拦截器
- springmvc.xml配置拦截器（实质是AOP，切点是拦截对象）

# SpringMVC上传文件