# MVC
>mvc是一种软件框架的思想，将软件按照模型，视图，控制器来划分，module，view，controller
- module:指Javabean分为两类
    - 实体类bean：User等，用来存储业务数据
    - 业务处理bean：Service或Dao对象，用于处理业务逻辑和数据访问
- view：指HTML，jsp等页面，作用是与用户进行交互，展示数据
- Controller：Servlet，作用是接受请求和响应浏览器

# SpringMVC
>Spring为表述层（前台页面，后台Servlet）开发提供的一整套完备的解决方案
> ，基于原生的Servlet，通过强大的前端控制器DispatcherServlet对请求和响应统一处理
- 内部组件化程度高，可拔插式组件，即插即用

# 原理
- 客户端发送请求
- DispatcherServlet接受所有请求
- DispatcherServlet调用BeanNameUrlHandlerMapping处理器映射，根据URL查找处理器（Controller方法），返回结果
- DispatcherServlet调用SimpleControllerHandlerAdapter处理器适配器，适配对应的Controller
- 执行Controller
- 返回ModelAndView给HandlerAdapter，再返回给DispatcherServlet
- DispatcherServlet将ModelAndView转发给ThymeleafViewResolver视图解析器
- ThymeleafViewResolver视图解析器获取数据，解析视图名字，拼接为视图的完整名字，返回给DispatcherServlet
- DispatcherServlet调用具体的视图
- 响应

# [流程](src/main/java/com/example/SpringMVC/controller/HelloController.java)
- 配置DispatcherServlet
- 创建控制器:@Controller,相当于@Component
- 方法上@RequestMapping：mvc注解，指定接受的URL，再加一个@ResponseBody，就不会经过视图解析器,直接return字符串
- 在SpringMVC的配置文件中设置自动调用处理器映射和适配器，配置视图解析器
---
- @RestController:在类上注解，返回的是单个字符串或JSON

# RestFul
> RestFul是一个资源定位和资源操作的风格。不是标准也不是协议
- 传统方式资源操作：post，get，delete，put，对应增查删改
- [RestFul资源操作](src/main/java/com/example/SpringMVC/controller/RestFulTest.java)

# Spring MVC中的请求转发和重定向
- 请求转发：一次请求，浏览器地址栏不变
- 重定向：2次请求，地址栏改变，request域不能传递对象
- return：默认是请求转发
  - return "forward:/success.jsp";
  - return "redirect:/success.jsp";
  
# 接受请求参数和回显数据
- 回显对象：请求参数字段必须和对象的字段一致
- 回显方式
  - ModelAndView：
  - ModelMap：继承了LinkedHashMap
  - Model：精简版
  
# 乱码问题
- 用过滤器解决:需要过滤对应的controller
- 配置SpringMVC自带的乱码过滤器

# Json
>jackson是Springboot自带的JSON解析器
- 1.ObjectMapper objectMapper = new ObjectMapper();
- 2.在SpringMVC.xml中配置ObjectMapper
- 3.String str=objectMapper.writeValueAsString(user);

# 拦截器
>拦截器只会拦截访问的控制器方法， 如果访问的是jsp/html/css/image/js是不会进行拦截的