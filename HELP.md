# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)



# pom.xml
>springboot会将所有的功能场景变为启动器
- spring-boot-dependencies：核心依赖在父工程中
- spring-boot-starter：启动器，
- spring-boot-starter-web：应用场景
  
# 主程序
> springboot所有自动配置都是在启动的时候扫描并加载：spring-boot-autoconfigure-2.5.6.jar!\META-INF\
> spring.factories包含所有的自动配置类，但不一定生效，要判断条件成立，成立则加载SpringApplicationRunListener。 调用它们的started()方法
- 1.SpringApplication.run,该方法首先创建一个对象实例，
    - 该实例初始化之前，先会判断是普通项目还是web项目，如果是web项目会创建ApplicationContext, 
    - 使用SpringFactoriesLoader在应用的classpath中查找并加载所有可用的ApplicationContextInitializer(在容器刷新之前调用该类的 initialize 方法。并将 ConfigurableApplicationContext 类的实例传递给该方法)。
    - 使用SpringFactoriesLoader在应用的classpath中查找并加载所有可用的ApplicationListener。
    - 推断并设置main方法的定义类，找到运行的主类。
- 2.SpringApplication实例初始化完成并且完成设置后，就开始执行run方法的逻辑了，方法执行伊始，首先遍历执行所有通过SpringFactoriesLoader可以查找到并加载的<font color='blue'>SpringApplicationRunListener</font>。
  调用它们的started()方法，
- 3.创建并配置当前Spring Boot应用将要使用的Environment（包括配置要使用的PropertySource以及Profile）。
- 4.遍历调用所有<font color='blue'>SpringApplicationRunListener</font>的environmentPrepared()的方法，告诉他们：“当前SpringBoot应用使用的Environment准备好了咯！”
- 5.如果SpringApplication的showBanner属性被设置为true，则打印banner
- 6.根据用户是否明确设置了applicationContextClass类型以及初始化阶段的推断结果，决定该为当前SpringBoot应用创建什么类型的ApplicationContext并创建完成，然后根据条件决定是否添加ShutdownHook，决定是否使用自定义的BeanNameGenerator，决定是否使用自定义的ResourceLoader，当然，最重要的，将之前准备好的Environment设置给创建好的ApplicationContext使用。
- 7.ApplicationContext创建好之后，SpringApplication会再次借助Spring-FactoriesLoader，查找并加载classpath中所有可用的ApplicationContext-Initializer，然后遍历调用这些ApplicationContextInitializer的initialize（applicationContext）方法来对已经创建好的ApplicationContext进行进一步的处理。
- 8.遍历调用所有<font color='blue'>SpringApplicationRunListener</font>的contextPrepared()方法。
- 9.<font color='red'> 最核心的一步，将之前通过@EnableAutoConfiguration获取的所有配置以及其他形式的IoC容器配置加载到已经准备完毕的ApplicationContext。 </font>
- 10.遍历调用所有<font color='blue'>SpringApplicationRunListener</font>的contextLoaded()方法。
- 11.调用ApplicationContext的refresh()方法，完成IoC容器可用的最后一道工序
- 12.查找当前ApplicationContext中是否注册有CommandLineRunner
  (在应用服务启动时，需要在所有Bean生成之后，加载一些数据和执行一些应用的初始化。例如：删除临时文件，清楚缓存信息，读取配置文件，数据库连接，这些工作类似开机自启动的概念，)，如果有，则遍历执行它们。
- 13.正常情况下，遍历执行<font color='blue'>SpringApplicationRunListener</font>的finished()方法
  （如果整个过程出现异常，则依然调用所有SpringApplicationRunListener的finished()方法，只不过这种情况下会将异常信息一并传入处理）
  
## web相关组件加载
> WebMvcAutoConfiguration，都存放在/webjars/**
### 静态资源存放位置优先级
> "classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"
### thymeleafProperties
> public static final String DEFAULT_PREFIX = "classpath:/templates/";
public static final String DEFAULT_SUFFIX = ".html";
- <font color='blue'>所有的HTML元素thymeLeaf都能够接管，形式是th:元素名</font>

### springMVC

# 自动配置原理
- xxxAutoConfiguration:自动配置类，给容器中添加组件
- xxxProperties:自动配置类，装配配置文件中相关属性
- 1.SPRINGBOOT启动会加载大量的自动配置类
- 2.如果我们所需要的功能在默认的自动配置类当中没有，我们可以个容器添加组件
- 3.给容器中自动配置类添加组件的时候，会从properties类中获取属性。我们只需要在配置文件当中指定这些属性的值即可。


# springboot配置文件.yaml
> springboot自动装配后，会有默认的属性值，我们可以通过配置文件来修改这些默认值
- @ConfigurationProperties(prefix = "person")：可以给被修饰的类配置属性，prefix是.yaml文件中的对象
- @PropertySource(value = "classpath:application.properties")：绑定配置文件
- @Value("${name}"):取出配置文件的值，赋予被修饰的属性
  
- 语法结构：key: value
```yaml
server:
  port: 8082
```
- yaml可以存对象
```yaml
student:
  name: 8082
  age: 12
#数组
pets:
  - cat
  - dog
pets2: [cat,dog]
```
## 配置文件的路径
- file:/config/ ：优先级最高，在项目路径/config/
- file:/
- classpath:/config/ ：在工程路径/src/main/java/resource/config
- classpath:/

## 多环境配置
> 可以选择激活哪个配置文件
```yaml
server:
  port: 8081
spring:
  profiles:
    active: test
---
#也可以分成多个文件
server:
  port: 8082
spring:
  profiles: test
```

# JSR303校验
> @Validated//数据校验
> 

# SpringSecurity
> 身份验证和访问控制 框架

# Shiro
> java安全框架，可以完成认证，授权，加密，会话管理，web集成，缓存等
- 架构
> subject(交互对象) --> securityManager（安全管理器，管理所有subject）--> realm（连接数据（验证），可以有多个）


# Swagger
> api框架；RestFul api文档在线自动生成工具；
> 接口文档可以实时更新，可以在线测试
- @Api：用在controller类，描述API接口
- @ApiOperation：描述接口方法
- @ApiModel：描述对象
- @ApiModelProperty：描述对象属性
- @ApiImplicitParams：描述接口参数
- @ApiResponses：描述接口响应
- @ApiIgnore：忽略接口方法

# 任务
## 异步任务

```java
import org.springframework.scheduling.annotation.Async;
class Test{
//    告诉spring这是一个异步方法（需要在启动类上开启异步方法），调用该方法是，spring会自动创建一个线程
  @Async
  public void test(){
    Thread.sleep(1000);
    System.out.println("数据正在处理");
  }
}

```
## 邮件任务
```java
/**
 <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-mail</artifactId>
</dependency>
 */
class SpringBootTestApplicationTests {
  @Autowired
  JavaMailSenderImpl javaMailSender;
  @Test
//    简单邮件
  void contextLoads2()  {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setSubject("主题");
    mailMessage.setText("测试文本");
    mailMessage.setTo("1364354238@qq.com");
    mailMessage.setFrom("1364354238@qq.com");
    javaMailSender.send(mailMessage);
  }
  //    复杂邮件
  @Test
  void contextLoads3() throws MessagingException {

    MimeMessage mailMessage = javaMailSender.createMimeMessage();
//        组装
    MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
    helper.setSubject("主题1");
    helper.setText("文本","index.html");
    helper.setText("<h1 style='color:red'>html</h1>",true);
//        附件
    helper.addAttachment("1.jpg",new File("c:\\2.jpg"));
    javaMailSender.send(mailMessage);
  }

}
```

## 定时任务

```java
import org.springframework.scheduling.annotation.Scheduled;

/**
 * TaskScheduler:任务调度者
 * TaskExecutor：任务执行者
 * @EnableScheduling 开启定时功能的注解
 * @Schedule 什么时候执行
 * cron表达式
 */
class Test {
//    秒，分，时，日，月，星期
  @Scheduled("0 10 12 * * 0-7")//每月每日，星期1-7的12:10:00执行该任务（自动执行）
  public void test() {
    System.out.println("执行了");
  }
}
```

# zookeeper
> zookeeper可以实现诸如分布式应用配置管理、统一命名服务、状态同步服务、集群管理等功能，

# dubbo
> 远程服务调用的分布式框架（告别Web Service模式中的WSdl，以服务者与消费者的方式在dubbo上注册）
其核心部分包含:
- 远程通讯: 提供对多种基于长连接的NIO框架抽象封装，包括多种线程模型，序列化，以及“请求-响应”模式的信息交换方式。
- 集群容错: 提供基于接口方法的透明远程过程调用，包括多协议支持，以及软负载均衡，失败容错，地址路由，动态配置等集群支持。
- 自动发现: 基于注册中心目录服务，使服务消费方能动态的查找服务提供方，使地址透明，使服务提供方可以平滑增加或减少机器。