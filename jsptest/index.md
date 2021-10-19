#JSP
> java server page，java的服务页面，主要作用是代替Servlet程序回传HTML页面的数据，因为Servlet回传HTML页面数据
> 是一件非常繁琐的事情

# jsp的本质
> 第一次访问jsp页面的时候，Tomcat会将jsp页面翻译为java源文件（间接继承HTTPServlet类，是一个Servlet程序）
> ，并对它进行编译。也就是说jsp就是Servlet程序，其底层就是将HTML用字符流回传。

#jsp头部的page指令
- language：jsp翻译成什么语言，暂时只支持java
- contentType：返回的数据类型,相当于response.setContentType();
- pageEncoding：jsp本身的字符集
-------
- autoFlush：设置当out输出流缓冲区满了以后，是否自动刷新冲级区
- buffer：设置out缓冲区大小，默认是8kb
-------
- errorPage：设置错误自动跳转取得路径
- isErrorPage：设置当前页面是否为错误信息页面，默认是false
- session:设置访问当前jsp页面是否会创建HTTPSession对象，默认是true
- extends：设置jsp翻译出来的类默认继承哪个类

#jsp常用脚本
- 声明脚本(少用)：<%! 声明java代码 %>:相当于在jsp的类中添加相应的java代码
- 表达式脚本：<%= 表达式 %>：在jsp页面上输出数据,在底层是将数据作为输入参数，使用的方法是_jspService()
- 代码脚本：<% java语句 %>:可以在jsp页面当中编写我们需要的功能,相当于在jsp的类中_jspService()方法中添加相应的java代码

#jsp九大内置对象
> 内置对象指Tomcat将jsp翻译为java代码后，内部提供的对象
- response
- config：ServletConfig对象
- out：jsp输出流对象
- page：指向当前jsp对象
- exception：异常对象
>四大域对象：域对象可以像Map一样存取数据，四个域对象功能一样，不同的是它们对数据的存取范围,优先使用范围小的
- request：（HTTPServletRequest类）：一次请求内有效
- pageContext：jsp上下文对象（PageContextImpl类），当前jsp页面范围内有效
- session：会话对象（HTTPSession类），一个会话范围内有效（打开浏览器访问服务器，直到关闭浏览器)
- application：ServletContext对象（ServletContext类），整个web工程内有效

#jsp页面所有代码执行完后会执行2个操作
- 1.执行out.flush()操作，会把out缓冲区中的数据追加写入到response缓冲区末尾
- 2.执行response缓冲区的刷新操作，把全部数据写给客户端

#out
- out.write():输出字符串没问题
- out.print():都转换为字符串

#常用标签
- 包含:
  - 静态包含：<%@include file=".jsp文件"%>,相当于将包含的.jsp页面的代码拷贝到当前位置输出
  - 动态包含：底层代码是JspRuntimeLibrary.include(request,response,".jsp文件",out,false)，二者共用缓冲区，
    ```jsx
    <jsp:include page="advertiseDynamic.jsp">
    <jsp:param name="132" value="456"/>
    </jsp:include>
    ```
    动态包含可以传递参数
- jsp请求转发标签：
   ```jsx
      <jsp:forward page="advertiseDynamic.jsp">
      <jsp:param name="132" value="456"/>
      </jsp:forward>
   ```
  
#EL表达式
> expression Language,主要是替代jsp的表达式脚本，相对简洁，主要是输出域对象中的数据
- 格式：$(表达式)
- 值为null时，EL输出空，表达式脚本输出null
- 如果四个域都保存了相同的key，那么有限输出小域
- 获取类的属性:实际上调用的是属性的get方法，没有get获取不了。
- 运算：输出运算结果
  - 算术运算，逻辑运算
  - empty运算： ${empty 表达式} 判断表达式是否为null
  - 三元运算：${ 表达式1? a:b}
  - "."运算：可以输出Bean对象中某个属性的值
  - "[""]"运算：对表达式进行引用，避免要进行运算的属性包含运算符
  
#EL表达式的11个隐含对象
>EL定义的可以直击使用的对象
- pageContext：PageContextImpl类型，可以获取jsp的9大内置对象
- pageScope：Map<String,Object>,可以获取pageContext域中的数据
- requestScope：Map<String,Object>，获取request域中的数据
- sessionScope：Map<String,Object>，获取session域中的数据
- applicationScope：Map<String,Object>，获取application域中的数据
- param：Map<String,String>：获取请求参数的值
- paramValues：Map<String,String[]>：获取请求参数的值,获取多个值的时候使用
- header：Map<String,String>：获取请求头信息
- headerValues：Map<String,String[]>：
- cookie：Map<String,Cookie>：获取当前请求的Cookie信息
- initParam：Map<String,String>：获取web.xml中的<context-param>上下文参数

#JSTL标签库
> JSP Standard Tag Library JSP标准标签库，用来替换jsp的代码脚本

功能
- 核心标签库：c
- 格式化：fmt
- 函数：fn
