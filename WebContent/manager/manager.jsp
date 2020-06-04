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
<title>管理系统后台</title>
</head>
<frameset cols="300px,*">
	<frame src="navigation.jsp" framespacing="0" frameborder="0"
		border="0" scrolling="No" noresize="noresize">
	<frameset rows="50px,*">
			<frame src="managerHeader.jsp" name='sidebar' framespacing="0"
				frameborder="0" border="0" scrolling="No" noresize="noresize">
			<frame src="managerIndex.jsp" name="main" framespacing="0"
				frameborder="0" border="0"  noresize="noresize">
		</frameset>
</frameset>
</html>