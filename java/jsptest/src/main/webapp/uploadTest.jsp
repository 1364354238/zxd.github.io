<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/10/9
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件的上传</title>
</head>
<body>
<form  method="post" action="http://localhost:8080/jsptest_war_exploded/uploadServlet" enctype="multipart/form-data">
    用户名:<input type="text" name="username">
    <br>
    密码:<input type="password" name="password">
    <br>
    <input type="file" name="img"><br/>
    <input type="submit">
</form>
</body>
</html>
