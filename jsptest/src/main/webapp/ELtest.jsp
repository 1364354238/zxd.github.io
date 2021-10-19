<%@ page import="com.example.jsptest.Person" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/8
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%--如果四个域都保存了相同的key，那么有限输出小域--%>
<%
    request.setAttribute("key","v");
    session.setAttribute("key","v2");
    Person person = new Person(18);
    request.setAttribute("p",person);
    Map<String,String>map=new HashMap<>();
    map.put("a+a+a","hello");
    request.setAttribute("m",map);
%>
表达式脚本输出：<%=request.getAttribute("key")%>
<br>
EL表达式输出：${key}--
中括号表达式：${m["a+a+a"]}--
session域：${sessionScope.key}
jsp内置对象:${pageContext.servletConfig}
<br>
age:${p.age}
<br/>
获取Cookie的名称：${cookie.JSESSIONID.name}
<br>
获取Cookie的值：${cookie.JSESSIONID.value}
</body>
</html>
