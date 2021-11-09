<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/8
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        function a1() {
            $.post({
                url:"${pageContext.request.contextPath}/a1",
                //发送的数据，键值对
                data:{"name":$("#txtName").val()},
                //success:回调函数，接受数据（JSON）,状态(连接是否成功）
                success:function (data,status){
                    $("#h1").html(data);
                },
                error:function () {
                    
                }
            })
        }
    </script>
</head>
<body>
用户名：<input type="text" id="txtName" onblur="a1()">
<h1 type="text" id="h1"></h1>
</body>
</html>
