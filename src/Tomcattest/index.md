# Tomcat目录介绍
- bin：Tomcat服务器可执行程序
- conf：Tomcat配置文件
- lib：Tomcat服务器jar包
- logs：日志
- temp：临时数据
- webapps：存放部署的Web工程
- work：Tomcat工作时的目录，可以存放运行时JSP翻译为Servlet的源码，和Session钝化的目录

#Tomcat启动
- 1.双击bin目录下 startup.bat文件启动
- 2.命令行启动，cd 到bin\,catalina run 
- 如果JAVAHOME路径发生变动，需修改bin/setclasspath.bat

#Tomcat停止
- x掉
- Tomcat只为当前窗口，快捷键ctrl+c
- 双击bin/shutdown.bat（常用）

#修改Tomcat端口号（默认8080）
- http协议默认的端口号是80
- conf/server.xml,修改 <Connector port="8080" protocol="HTTP/1.1"...>
- 修改完要重启Tomcat

#将Web工程部署到Tomcat中
- 1.将工程拷贝到webapps目录下即可，localhost:8080->webapps目录，localhost:8080/project/package
- 2.在conf\Catalina\localhost目录下新建一个projectname.xml文件，示例example,访问localhost:8080/projectname

#手托HTML页面到浏览器和Tomcat的区别
- 手托：使用的协议是file://协议（告诉浏览器直接读取后面的路径解析即可）
- 浏览器输入地址访问使用的协议是http协议，没有工程路径或没有访问文件的时候访问的是webapps/Root/index.jsp：
    - localhost：IP
    - :8080：端口号
    - /book：工程路径
    - index.html：访问文件
- Tomcat服务器收到浏览器（客户端）发送的请求后，读取要访问的文件，然后回传给客户端要的页面的内容

# IDEA整合Tomcat
- 添加Tomcat：File | Settings | Build, Execution, Deployment | Application Servers



