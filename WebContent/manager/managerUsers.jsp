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
<title>用户管理</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 30px; margin-top: 20px; margin-left: 30px">用户管理</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<table class="table table-bordered table-hover"
		style="margin-left: 16px; width: 1580px">
		<tr>
			<th style="width: 100px">序号</th>
			<th style="width: 400px">用户ID</th>
			<th style="width: 200px">用户名</th>
			<th style="width: 200px">密码</th>
			<th style="width: 200px">姓名</th>
			<th style="width: 200px">性别</th>
			<th style="width: 300px">电话号码</th>
			<th style="width: 300px">地址</th>
			<th style="width: 100px">操作</th>
		</tr>
		<c:forEach items="${users}" var="u" varStatus="vs">
			<tr class="active">
				<td>${vs.index+1}</td>
				<td>${u.id}</td>
				<td>${u.username}</td>
				<td>${u.password}</td>
				<td>${u.name}</td>
				<td>${u.sex}</td>
				<td>${u.tel}</td>
				<td>${u.address}</td>
				<td><a href="#">编辑</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>