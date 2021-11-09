<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/11/8
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <%--    分成12份--%>
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post" >
        <div class="form-group">
            <label for="bkname">书籍名称</label>
            <input type="text" name="bookName" class="form-control" id="bkname" value="${Books.bookName}" required>
        </div>
        <div class="form-group">
            <label for="bkcount">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" id="bkcount" value="${Books.bookCounts}"required>
        </div>
        <div class="form-group">
            <label for="bkdetail">书籍细节</label>
            <input type="text" name="detail"class="form-control" id="bkdetail" value=""${Books.detail}"required>
        </div>
        <div class="form-group">
            <input type="hidden" name="bookID" value="${Books.bookID}">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>

</body>
</html>
