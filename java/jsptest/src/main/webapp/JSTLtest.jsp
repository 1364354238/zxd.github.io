<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/9
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL的使用</title>
</head>
<body>
核心标签库set:<c:set scope="request" value="value" var="key3"/>
核心标签库if: <c:if test="${12==12}">
    表达式为true
</c:if>
<br>
<%--定义key，iterate赋值，key相当于形参，只在内部有效
items:遍历的数据源
varStatus:遍历状态对象，可以获取数值，索引，begin，end
--%>
循环foreach：<c:forEach var="i" end="5" begin="0" varStatus="status">
    <br><c:out value="${i}"/>
    ${"hhh"}
    <br>遍历对象${status.index}
</c:forEach>
<br>
EL：${key3}

</body>
</html>
