<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单管理</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function fahuo(ordernum) {
			window.location.href = "${pageContext.request.contextPath}/order/OrderServlet?op=faHuo&ordernum="
					+ ordernum;
			alert("发货成功！！");
		}
	</script>
	<div>
		<p style="font-size: 30px; margin-top: 20px; margin-left: 30px">订单管理</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<table class="table table-bordered table-hover"
		style="margin-left: 16px; width: 1580px">
		<tr>
			<th style="width: 100px">序号</th>
			<th style="width: 100px">订单编号</th>
			<th style="width: 250px">创建时间</th>
			<th style="width: 250px">客户账号</th>
			<th style="width: 200px">商品数量</th>
			<th style="width: 200px">支付金额</th>
			<th style="width: 200px">订单状态</th>
			<th style="width: 200px">操作</th>
		</tr>
		<c:forEach items="${orders}" var="os" varStatus="vs">
			<tr class="active">
				<td>${vs.index+1}</td>
				<td>${os.ordernum}</td>
				<td>${os.time}</td>
				<td>${os.user.username}</td>
				<td>${os.quantity}</td>
				<td>${os.money}</td>
				<c:if test="${os.status==0}">
					<td>未发货</td>
					<td><a href="javascript:fahuo('${os.ordernum}')">发货</a></td>
				</c:if>
				<c:if test="${os.status==1}">
					<td>已发货</td>
					<td><a href="#">删除</a></td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>