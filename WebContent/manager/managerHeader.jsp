<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理系统后台</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><p
						style="font-size: 25px; margin-top: 6px; margin-left: 10px">图书销售管理系统后台</p>
					<span class="sr-only">(current)</span></li>
			</ul>
			<div style="float: right; margin-right: 7px; margin-top: 10px">
				<a class="btn btn-default btn-sm"
					href="${pageContext.request.contextPath}/manager/ManagerServlet?op=layout"
					role="button">注销</a>
			</div>
			<div style="float: right; margin-right: 7px; margin-top: 10px">
				<a class="btn btn-default btn-sm" href="<%=basePath%>/index.jsp"
					role="button" target="_top">退出</a>
			</div>
		</div>
	</div>
	</nav>
</body>
</html>