<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<title>导航条</title>
</head>
<body>
	<div style="margin-top: 100px; margin-left: 90px">
		<p>
			<a href="<%=basePath%>/person/personInformation.jsp"
				style="color: black; font-weight: bold; text-decoration: none"
				target="main"><img src="<%=basePath%>/img/icon-11.png"
				style="width: 24px" />&nbsp;&nbsp;修改个人资料</a>
		</p>
		<p>
			<a href="<%=basePath%>/person/personPassword.jsp"
				style="color: black; font-weight: bold; text-decoration: none"
				target="main"> <img src="<%=basePath%>/img/icon-12.png"
				style="width: 24px" />&nbsp;&nbsp;修改密码
			</a>
		</p>
		<p>
			<a href="<%=basePath%>/order/OrderServlet?op=findAllOrders"
				style="color: black; font-weight: bold; text-decoration: none"
				target="main"><img src="<%=basePath%>/img/icon-13.png"
				style="width: 24px" />&nbsp;&nbsp;我的订单</a>
		</p>
	</div>
</body>
</html>