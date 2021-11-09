<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/6
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<head>
    <title>所有书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
    <%--    分成12份--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表---显示所有书籍</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a  class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">增加书籍</a>
            </div>
            <div class="col-md-4 column" style="float: right" >
                <form class="form-inline" action="${pageContext.request.contextPath}/book/queryBook" method="post">
                    <input type="text" class="form-control" name="bookName" value="请输入要查询的书籍名称">
                    <input type="submit" value="查询" class="btn btn-primary" >
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <%--    分成12份--%>
        <div class="col-md-12 column">
            <div class="page-header">
<%--                变色--%>
    <table class="table table-hover table-striped">
        <thead>
            <tr>
                <th>书籍编号</th>
                <th>书籍名称</th>
                <th>书籍数量</th>
                <th>书籍详情</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="books" items="${booksList}">
                <tr>
                    <td>${books.bookID}</td>
                    <td>${books.bookName}</td>
                    <td>${books.bookCounts}</td>
                    <td>${books.detail}</td>
                    <td><a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${books.bookID}">修改</a> &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/book/deleteBook?id=${books.bookID}">删除</a></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
