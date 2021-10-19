# Servlet
- Servlet是javaee规范（接口）之一
- Servlet是JavaWeb三大组件之一：Servlet程序，Filter过滤器，Listener监听器。
- Servlet是运行在服务器上的java小程序，它可以接受客户端发送过来的请求，并响应数据给客户端。

#web.xml配置文件
> 先从<servlet-mapping>开始，根据name在<servlet>找对应的类名，再在<servlet-class>找这个类,最后执行这个类方法。

#Servlet的生命周期
- 1.执行Servlet构造器方法
- 2.执行init初始化方法
- 第一次访问时，创建Servlet程序时会调用1,2部
- 3.执行service方法，每次访问时都会调用
- 4.执行的destroy销毁方法，web工程停止时会调用

# 实现Servlet程序的方式
- 实现Servlet接口
- 继承HTTPServlet（常用）
    - 编写一个类继承HTTPServlet
    - 根据业务重写doGet，doPost
    - 到web.xml总配置Servlet程序的访问地址
- IDEA 生成Servlet程序

#整个Servlet类的继承体系
- interface Servlet：定义Servlet程序访问规范
- Class GenericServlet：实现接口，做了很多空实现并持有一个**ServletConfig**类
- Class HTTPServlet：继承GenericServlet，实现了service方法，并实现了请求的分发处理
- 自定义的Servlet程序：继承HTTPServlet，根据业务需要重写doGet（）等方法

#ServletConfig类
- 作用：
  - 获取Servlet程序的别名servlet-name；
  - 获取初始化参数init-param
  - 获取ServletContext对象
  
#ServletContext类
- 是一个接口，表示Servlet上下文对象
- 一个web工程只有一个ServletContext对象实例
- ServletContext对象是一个域对象
  - 域对象是可以像Map一样存取数据的对象（域指存取数据的操作范围）
- 作用：
  - 获取web.xml中配置的上下文参数context-param
  - 获取当前的工程路径，格式：/工程路径
  - 获取工程部署后在服务器硬盘上的绝对路径
  - 像Map一样存取数据
  
#HTTPServletRequest类
>每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的Http协议信息解析好封装到Request对象中

#请求的转发
>指服务器收到请求后，从一次资源跳转到另一个资源的操作（可以转到WEB-INF下的资源），这些资源共享域，客服端一次请求

#base标签（固定相对路径参照的路径）
- <a href="../../index.jsp>:这里的..参照的地址是当前浏览器的地址
- \<base href="http:...">:设置base标签后，参照的地址就固定位base标签设置的地址

#HttpServletResponse类
>以流的方式将数据传递给客户端
- 字节流 getOutputStream（）：常用于下载（传输二进制数据）
- 字符流 getWriter（）：常用于回传字符串
- 两个流同时只能使用一个，否则就会报错