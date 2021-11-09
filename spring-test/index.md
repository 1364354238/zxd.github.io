# Sping优点
- 轻量级，非侵入式的框架
- 控制反转（IOC）:将创建对象的过程交给Spring管理，方便解耦，简化开发
- 面向切面编程（AOP）：不修改源代码增强功能
- 支持事务的处理，对框架的整合的支持

# Spring组成
- core
- AOP
- ORM
- DAO
- Web
- Context
- Web MVC

# 基于Spring的开发流程
- SpringBoot:构建一切，掌握前提（Spring，SpringMVC）
    - 一个快速开发的脚手架
    - 基于StringBoot可以快速开发单个微服务
    - 约定大于配置
- Spring Cloud：协调一切
    - SpringCloud是基于SpringBoot实现的
    
# IOC理论推导
>没有IOC的程序中，我们使用的是面向对象编程，对象的创建与对象之间的依赖关系完全硬编码在程序里，
> 使用了IOC后，将对象的创建转移给第三方，即从主动创建对象，变为被动接受对象，关键是set方法
- Spring配置文件加载的时候，当中的所有对象都被创建了
- 默认是创建无参
- 创建有参的三种方式
  - 1. \<constructor-arg index="0" value="first"/>
  - 2. \<constructor-arg type="java.lang.String" value="type"/>
  - 3. \<constructor-arg name="name" value="third"/>
  
# Spring配置文件
- 别名：<alias name="旧名字",alias="新名字"/>,旧名字是 配置文件当中的id
- Bean的配置：<bean id="user" class="com.example.pojo.User" name="user2 u2.u3;u4"/>
- import: <import resource="bean.xml"/>导入其他的Beans.xml文件,可以将所有的Beans文件合并为一个总的

# 注入
- 构造器注入：\<constructor-arg name="name" value="third"/>
- Set方式注入
  - 依赖注入：
    - 依赖：Bean对象的创建依赖于容器
    - 注入：Bean对象的属性由容器来注入
- 其他方式
  - c,使用有参构造器注入：\<bean id="hello" class="com.example.pojo.Hello" c:str="你好"/>
  - p: \<bean id="address" class="com.example.pojo.Address" p:address="123@123"/>
  
# bean的作用域
> \<bean id="user" class="com.example.pojo.User" name="user2 u2.u3;u4" scope="singleton/>
- singleton:单例模式（默认），容器在加载的时候，会为所有bean创建且只创建一个对象
- prototype：原型模式，容器每次get对象时，都会产生一个新对象
- request，session，application

# Bean的自动装配注解
>自动装配是Spring满足bean依赖的一种方式,Spring会在上下文中自动寻找，并自动给bean装配属性
> \<bean id="people" class="com.example.pojo.People" autowire="byName">
-  byName:会自动在容器中查找，和自己set方法对应的bean id
-  byType:会自动在容器中查找，和自己对象属性类型相同的bean class，要求容器中改类型只有一个，否则会报错
- 注解实现自动装配
  - 1.导入约束  xmlns:context="http://www.springframework.org/schema/context"
  - 2.注解的支持：\<context:annotation-config/>
  - 3.在需要注入的属性使用 
    - @Autowired(require=true),兼容了byName，byType，优先是byType，require默认是true，如果设置为false表示改属性可以为null
    - @Qualifier:可以给该属性添加一个name，\<bean>
    - @Resource:兼容了byName，byType，优先是byName
  
# 使用注解开发
> 要使用注解开发，必须导入了AOP包
- 1.指定要扫描的包：\<context:component-scan base-package="com.example.pojo"/>
- 2.在class上注解@Component：相当于\<bean id="cat" class="com.example.pojo.Cat"/>
- 3.注入属性，在属性上@Value（“属性值”）


- 衍生注解:在web开发中，会按照MVC三层架构分层，这些注解的功能和@Component是一样的
  - Dao：@Repository
  - Service：@Service
  - Controller：@Controller
- 作用域注解：@Scope（“singleton”）
----------------
## 开发经验：xml用来管理bean，属性用注解注入

-----------------------
# [使用Java的方式配置Spring，不使用xml配置](src/main/java/com/example/test_demo/appConfig.java)
>@Configuration //代表一个配置类就和beans.xml一样
> Import()可导入其它的配置类
- @ComponentScan("com.example.pojo"):指定要扫描的包
- @Bean:相当于<bean>,这个方法的名字就相当于bean标签中的id，方法的返回值就相当于class


## 代理模式
> 代理模式是SpringAOP的底层，可以在不改变真实类的基础上进行扩展，
> AOP就是基于代理模式的横向开发（扩展功能）
- 静态代理：一个真实类需要一个代理类
- 动态代理：动态代理类是动态生成的
  - 基于接口的：JDK动态代理,传入接口，获得该接口的代理接口，InvocationHandler设置要代理的类（实现对应接口类）
  - 基于类：
  - java字节码实现：

# AOP
- 使用原生SpringAPI接口配置AOP,先定义切入点（要进行扩展的接口实现类），执行环绕（要添加的方法类，必须实现对应接口）
- 自定义类：aspect自定义要切入的方法类，定义切点，通知切入该类的什么方法
- 注解实现：
  -  开启注解支持：\<aop:aspectj-autoproxy/>
  - @Aspect：标注这个类是一个切面
  - @Before：标注方法，将方法切入到切入点之前

- 切入方法：
  - around：环绕，可以定义一个参数ProceedingJoinPoint joinPoint，代表我们要获取处理切入的点
  
# mybatis-spring
- 使用spring的数据源替换mybatis.xml的配置
-  使用Spring的SqlSessionFactory
- sqlSession，通过构造函器注入SqlSessionFactory
  
#事务
