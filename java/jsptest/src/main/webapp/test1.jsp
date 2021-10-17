<%@ page import="java.util.Map" %>
<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/8
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         errorPage="error.jsp"
         session="true"
%>
<html>
<head>
    <title>测试</title>
</head>
<body>
hello
<%--声明类属性--%>
<%!
    private int id;
    private String name;
    private Map<Integer, Integer> map;
%>
<%--声明类方法--%>
<%!
    public String abs() {
        return "abc";
    }
%>
<%--声明内部类--%>
<%!
    public static class A {
        private Integer id = 11;
        private String name = "123";
    }
%>
<%--输出数据，不能以分号结束--%>
<%=new A()%>
<%--代码脚本--%>
<%
    int i = 10;
    System.out.println(i == 10);
    request.getParameterNames();
%>
<%--循环--%>
<table>
    <%
        for (int j = 0; j < 10; j++) {
    %>
    <tr>第<%=j%>行</tr>
    <br>
    <%
        }
    %>
</table>
<%--往jsp四大域中存数据--%>
<%
    request.setAttribute("key1", "v1");
    session.setAttribute("key2", "v2");
    application.setAttribute("key3", "v3");
    pageContext.setAttribute("key3", "v3");

%>
<%= request.getAttribute("key1")%>
<%= session.getAttribute("key2")%>
<%=application.getAttribute("key3")%>
<%=pageContext.getAttribute("key3")%>
<%--response内置对象--%>
<%
    out.write("niaho");
    response.getWriter().write("再见");
%>
<%--包含标签--%>
包含标签<br>
<%@include file="/advertiseStatic.jsp" %>
<jsp:include page="advertiseDynamic.jsp">
    <jsp:param name="132" value="456"/>
</jsp:include>
<%--请求转发标签--%>
<jsp:forward page="/index.jsp">
    <jsp:param name="123" value="转发"/>
</jsp:forward>
</body>
</html>
