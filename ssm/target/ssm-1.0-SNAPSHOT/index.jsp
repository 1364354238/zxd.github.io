<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        a{
            text-decoration: none;
            color: #b1afee;
            font-size: 20px;
        }
        h3{
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: #fad7e6;
            border-radius: 5px;
        }
    </style>

</head>
<body>
<br/>
<h3><a href=${pageContext.request.contextPath}/book/allBook>查询所有书籍</a></h3>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">
</form>
<a href="${pageContext.request.contextPath}/download">点击下载</a>
</body>
</html>