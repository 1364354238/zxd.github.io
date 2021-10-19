<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<jsp:include page="/pages/common/head.jsp"/>
	<script type="text/javascript">
		$(function () {
			$(".deleteItem").click(function () {
				return confirm("确定要删除【" + $(this).parent().parent().find("td:first").text() + "】" + "吗");
			})
			$(".clearItem").click(function () {
				return confirm("确定要清空购物车吗");
			})
			$(".updateCount").change(function () {
				let name = $(this).parent().parent().find("td:first").text();
				let id = $(this).attr("bookId");
				let value = this.value;
				if(confirm("确定【"+name+"】将商品数量修改为【"+value+"】吗")){

					location.href="${pageScope.basePath}" + "CartServlet?action=updateCount&id=" + id + "&count=" + value;
				}else {
					//defaultValue表示该对象的默认的value
					this.value = this.defaultValue;
				}
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@include file="/pages/common/top.jsp"%>

	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${sessionScope.cart.items}" var="entry">
				<tr>
					<td>${entry.value.name}</td>
					<td>
					<input class="updateCount" style="width: 80px" type="text" bookId="${entry.value.id}" value="${entry.value.count}">
					</td>
					<td>${entry.value.price}</td>
					<td>${entry.value.totalPrice}</td>
					<td><a class="deleteItem" href="CartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
				</tr>
			</c:forEach>
			<c:if test="${ empty sessionScope.cart.items}">
				<tr>
					<td colspan="5">您的购物车空空如也,快去<a href="index.jsp"> 浏览商品把</a></td>
				</tr>
			</c:if>
			<c:if test="${ !empty sessionScope.cart.items}">
			
		</table>

			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.gettotalPrice()}</span>元</span>
				<span class="cart_span"><a class="clearItem"href="CartServlet?action=clearItem">清空购物车</a></span>
				<span class="cart_span"><a href="OrderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>