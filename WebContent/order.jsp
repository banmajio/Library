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
<title>支付</title>
<style type="text/css">
.hhh {
	background: url(<%=basePath%>/img/zfb.png);
	height: 500px;
	background-repeat: no-repeat;
	margin-top: 10px;
	margin-left: 500px;
}
</style>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<jsp:include page="/header1.jsp"></jsp:include>
	<div style="margin-left: 650px; margin-top: 160px">
		<table>
			<td style="width: 400px">订单编号：${order.ordernum}</td>
			<td style="width: 400px">创建时间：${order.time}</td>
		</table>
	</div>

	<div class="hhh">
		<br> <br> <br> <br> <br>
		<div style="margin-left: 355px">
			<strong><span
				style="color: rgb(255, 102, 0); font-size: 30px;">${order.money}</span></strong>
		</div>
	</div>
</body>
</html>