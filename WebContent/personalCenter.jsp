<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
</head>
<frameset rows="50px,*">
	<frame src="fraheader.jsp" framespacing="0" frameborder="no" border="0" scrolling="No" noresize="noresize">
	<frameset cols="350px,*">
		<frame src="person/navigation.jsp" name='sidebar' framespacing="0"  border="0" scrolling="No" noresize="noresize">
		<frame src="person/personIndex.jsp" name="main" framespacing="0" frameborder="no" border="0" scrolling="No" noresize="noresize">
	</frameset>
</frameset>

</html>