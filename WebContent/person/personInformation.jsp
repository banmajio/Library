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
<title>个人资料</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 30px; margin-top: 20px; margin-left: 30px">个人资料修改</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<div style="margin-top: 100px; margin-left: 400px">
		<form action="<%=basePath%>/client/ClientServlet?op=personInformation"
			method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input
					class="form-control" type="text" id="username" name="username" value="${sessionScope.user.username}"
					 readonly
					style="width: 700px">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Name</label> <input
					class="form-control" type="text" id="name" name="name"
					value="${sessionScope.user.name}" style="width: 700px">
			</div>
			<label for="Ssex">性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
			<c:if test="${sessionScope.user.sex =='男'}">
			<input type="radio" name="sex" value="男" checked="checked">男
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" value="女">女
			</c:if>
			<c:if test="${sessionScope.user.sex=='女'}">
			<input type="radio" name="sex" value="男">男
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" value="女" checked="checked">女
			</c:if>
			 <br>
			<div class="form-group">
				<label for="exampleInputEmail1">TelephoneNumber</label> <input
					class="form-control" type="text" id="tel" name="tel"
					value="${sessionScope.user.tel}" style="width: 700px">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Address</label> <input
					class="form-control" type="text" id="address" name="address"
					value="${sessionScope.user.address}" style="width: 700px">
			</div>
			<br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location='client/ClientServlet?op=personInformation'">提交</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"
				style="margin-left: 100px"
				onclick="window.location='personIndex.jsp'">关闭</button>
		</form>
	</div>
</body>
</html>