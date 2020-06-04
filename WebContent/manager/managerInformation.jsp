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
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
<title>管理员个人信息修改</title>
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 25px; margin-top: 20px; margin-left: 42px">修改个人信息</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<div style="margin-top: 100px; margin-left: 430px">
		<form
			action="<%=basePath%>/manager/ManagerServlet?op=managerInformation"
			method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input
					class="form-control" type="text" id="username" name="username"
					value="${sessionScope.admin.username}" readonly
					style="width: 700px">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Name</label> <input
					class="form-control" type="text" id="name" name="name"
					value="${sessionScope.admin.name}" style="width: 700px">
			</div>
			<label for="Ssex">性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
			<c:if test="${sessionScope.admin.sex =='男'}">
			<input
				type="radio" name="sex" value="男" checked="checked">男
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
				name="sex" value="女">女
			</c:if>
			<c:if test="${sessionScope.admin.sex =='女'}">
			<input
				type="radio" name="sex" value="男" >男
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio"
				name="sex" value="女" checked="checked">女
			</c:if> <br> 
			<div class="form-group">
				<label for="exampleInputEmail1">TelephoneNumber</label> <input
					class="form-control" type="text" id="tel" name="tel"
					value="${sessionScope.admin.tel}" style="width: 700px">
			</div>
			<br>
			<button type="submit" class="btn btn-primary"
				onclick="window.location='manager/ManagerServlet?op=managerInformation'">提交</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"
				style="margin-left: 100px"
				onclick="window.location='managerIndex.jsp'">关闭</button>
		</form>
	</div>
</body>
</html>