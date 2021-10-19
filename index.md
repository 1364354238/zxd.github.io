# javaWeb
- JavaWeb是指所有通过java语言编写的得可以通过浏览器访问的程序的总和
- JavaWeb是基于请求和响应来开发的
    - 请求是指客户端给服务器发送数据，request
    - 响应是指服务器给客户端回传数据，response
    - 请求和响应成对出现
    
## Web资源分类
Web资源按实现技术和呈现效果的不同，分为静态资源和动态资源两种

- 静态资源：HTML，css，js，TXT，MP4，图片
- 动态资源：JSP页面，Servlet程序

## 常用的Web服务器
- Tomcat（免费）：提供对jsp和Servlet的支持，轻量级JavaWeb容器
- Jboss（免费）：遵从javaee规范
- glassFish：商业服务器
- resin:收费，应用多
- WebLogin:适合大型项目

# 动态web工程目录
- src:存自己写的Java源代码
- web: 存放web工程的资源文件，HTML，css，js等
- WEB-INF:收服务器保护的目录，浏览器无法直接访问到此目录的内容
- web.xml:整个动态web工程的配置部署描述文件，可以配置web工程的组件，如Servlet，Filter，Listener，Session。。
- lib:存放第三方jar包
- target:编译结果

#地址信息
- 客户端（浏览器）http://localhost:8080/project/name
  - http:协议
  - localhost:服务器IP，通过IP定位服务器
  - :8080:服务器端口号，通过端口号定位Tomcat
  - \project：工程路径
  - \name:资源路径
  
#快捷键
idea：
- ctrl+h：查看子类
- ctrl+shift+t:新建测试类
- ctrl+shift+r:替换

# [HTTP请求中POST与GET的区别](https://blog.csdn.net/qq_38182125/article/details/89071899) 
http定义了与服务器交互的不同方法，其中最基本的几种：get，post（表单），put，delete，head，其中get和head是安全方法
- 安全方法：http请求不会在服务器上产生任何结果（不会修改信息）
- 不安全方法：可能会修改服务器上的资源的请求
- 常用请求头：
  - Content-Type：表示发送数据的类型
    - application/x-www-form-urlencoded:表示提交的数据格式是 name=value&name=value,然后对其进行URL编码
      （把非英文内容转化为%x%）
    - multipart/form-data:以流的形式提交（多段），用于上传，boundary是每段数据的分隔符
  - Accept：表示客户端可以接受的数据类型
  - Accept-Language：表示客户端可以接受的语言类型
  - User-Agent：表示客户端浏览器类型
  - Host：表示请求时的服务器IP和端口号
  - Referer:请求发起时，浏览器的地址栏的地址
  
#响应的Http协议的格式
- 响应行：
  - 响应的协议和版本号：Http/1.1
  - 相应的状态码：200（请求成功），302（请求重定向）,404（请求收到，但请求数据不存在）,500（收到请求，但服务器内部错误）
  - 响应的状态描述符 ok
- 响应头key：value 不同的响应头，含义不同(可以通过响应头来修改浏览器的字符集)
  - Sever：表示服务器信息
  - Content-Type: 相应的数据类型   
- 响应体：回传给客户端的数据
-  response.setContentType("text/html;charset=UTF-8");

#http中数据类型（MIME）
> .html,.text,.jpg,.avi,.tar.....

#使用谷歌浏览器查看Http协议
> F12->Network->Name->响应头，请求：Headers,响应体：Response

#  /的意义
- 浏览器解析为:http:\\ip:port/
- 服务器解析：http:\\ip:port/工程路径

#请求重定向
> 客户端给服务器发请求，然后服务器告诉客户端前往新地址访问
- 浏览器地址栏会发生变化
- 两次请求
- 可以访问工程外的资源

#javaEE项目的三层架构
- 客户端：HTML，css，js，jQuery
- 服务端:分层的目的是为了解耦，降低代码的耦合度，方便项目后期的维护和升级
  - web层：Servlet，SpringMVC
    - 1.获取请求的参数，然后封装成为Bean对象；
    - 2.调用Service层处理业务；
    - 3 响应数据给客户端
  - Service业务层：Spring框架
    - 处理业务逻辑
    - 调用持久层保存到数据库
  - Dao持久层：JDBC，Mybatis
    - 只负责跟数据库交互（CRUD操作）
- 数据库

#Debug调试
> 需要断点+Debug启动器

#JSP
> java server page，java的服务页面，主要作用是代替Servlet程序回传HTML页面的数据，因为Servlet回传HTML页面数据
> 是一件非常繁琐的事情

#Listener监听器
- Listener监听器是JavaWeb的三大组件（Servlet，Filter，Listener）之一
- 是javaee的规范，就是接口
- 作用是：监听某种事物的变化，然后通过回调函数，反馈给客户（程序）去做一些相应的处理。
- ServletContextListener：
  - 可以监听ServletContext对象的创建和销毁，监听到创建和销毁都会反馈
  - 使用方法，编写一个类实现ServletContextListener接口，然后实现器两个回调方法
  
#文件的上传
- 要有一个form标签，且method=post， 
- enctype="multipart/form-data",表示提交的数据以多段的形式（二进制流）上传，
- 内部要有标签<input type="file">
- 编写服务器接收代码处理上传数据(导包)

#文件的下载
- 客户端发请求，告诉服务器要下载的文件
- 服务器获取要下载的文件名，读取文件内容，在回传前通过响应头告诉客户端返回的数据类型，并且告诉客户端数据使用来下载的，
  回传给客户端
  
#BASE64编码
```
Base64.Encoder base = Base64.getEncoder();
response.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+ base.encodeToString("小鸟2.jpeg".getBytes(StandardCharsets.UTF_8)) +"?=");
```
- =?；表示编码内容的开始
- B：表示BASE64编码
- ?=：表示编码内容结束

#MVC
> 全称：Model，View，Controller控制器，可以有效地指导Web层的代码如何有效的分离，单独工作
- view视图：只负责数据和页面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作--jsp，HTML
- Controller控制器：只负责接收请求，调动业务层的代码处理请求，然后派发页面，是一个调度者角色--Servlet
- model模型：将与业务逻辑相关的数据封装为具体的Javabean类，其中不掺杂任何与数据处理相关的的代码--Javabean/domain/entity

# [Cookie](./cookie_session/index.md)
> Cookie是服务器通知客户端保存键值对的一种技术，客户端有了Cookie后，每次请求都发给服务器，每个
> Cookie大小不超过4kb
#[Session](./cookie_session/index.md)
> Session是一个接口（HTTPSession），它是用来维护客户端和服务器之间关联的一种技术，每个客户端都有自己的一个Session会话，
> Session会话中，经常用来保存用户登陆之后的信息。
- Session的底层是靠Cookie实现的：服务器每次创建Session会话时，都会创建一个Cookie，且key为“JSESSIONID”
  然后响应给客户端
- 客户端每次请求，都以Cookie（键值对）的形式将Session发送给服务器
- Cookie里没有Session时，服务器会重新创建一个新的Session对象

# [jsp,EL,jstl](./jsptest/index.md)
# [Servlet](./Servlettest/index.md)

#表单重复提交
- 1.表单提交后，用户刷新浏览器，表单会再次提交（重定向解决，因为重定向相当于将请求通过一个中间地址转发给
  响应地址，重定向后浏览器显示的是响应地址，即使刷新也不会再次提交请求）
- 2.由于网络原因，浏览器没有及时收到响应，用户点了多次提交（使用验证码）
- 3.用户提交表单后，回退浏览器，再次提交。（使用验证码）

#验证码的使用
- 1.当用户第一次访问表单时，给用会生成一个随机验证码
- 2.把验证码保存到Session域当中
- 3.把验证码生成为图片显示在表单中
-------
- 4.当用户提交表单后，对比验证码信息，然后删除Session域中的验证码
-------
- 5.谷歌验证码的使用
  - 1.导jar包
  - 2.web.xml配置jar包中的KaptchaServlet
  - 3.在表单中使用img标签使用它
  - 4.获取验证码request.getSession.getAttribute("KAPTCHA_SESSION_ANY")
- 6.验证码的切换
  - 1.绑定单击事件，跳转当前页面
  - 2.问题：浏览器为了让请求速度更快，就会将每次请求缓存到浏览器端，如果下次请求相同则直接在缓存中找，这样每次验证码
  图片就是一样的。
  - 3.解决方法：在网址后面添加一个时间戳
  
#[Filter过滤器](./FilterTest/index.md)
> 是javaEE的规范（接口），作用是拦截请求，过滤响应

#ThreadLocal
> ThreadLocal可以用来解决多线程的数据安全问题,使用ThreadLocal确保所有的Dao操作都在一个connection里
- 可以为当前线程关联一个数据，相当于Map，key为当前数据
- 每一个ThreadLocal对象，只能为当前线程关联一个数据，要关联多个，就需要创建多个ThreadLocal对象实例
- 每个ThreadLocal对象实例定义的时候，一般用static修饰
- ThreadLocal中保存的数据，在线程销毁后，会由jvm虚拟机自动释放

#在web.xml中配制错误页面
```xml
    <error-page>
<!--        错误类型-->
        <error-code>500</error-code>
        <location>/pages/error/error-500.jsp</location>
    </error-page>
```

#[JSON,AJAX](./JSONAndAJAXTest/index.md)
>一种轻量级的数据交换格式（客户端和服务器之间业务数据的传递格式），易于阅读和机器的解析，多种语言都提供了对json的支持

>AJAX:Asynchronous Javascript And XML（异步js和xml），是一种创建交互式网页应用的网页开发技术
- Ajax是一种浏览器通过js异步发起请求，局部更新页面的技术
- Ajax请求的局部更新，浏览器地址栏不会发生变化
- 局部更新不会舍弃原来的页面的内容
- 异步的作用：
  - 在等待某功能时，不影响其他功能
  
#[i18n 国际化](./JSONAndAJAXTest/index.md)
> 国际化指同一个网站可以支持多种语言
> 
国际化三要素
- 1.Locale对象:表示不同时区，位置语言，zh-CN，en-US
- 2.properties属性配置文件：
  - 国际化配置文件命名规则：baseName_locale.properties:file_zh_CN.properties
- 3.ResourceBundle资源包
  - ResourceBundle.getBundle():根据给定的basename，locale读取对应的配置文件，获取文字信息
  - ResourceBundle.getString(key):得到你想要的不同国家的语言信息


