<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转</title>
</head>
<body style="background-color: rgb(240, 243, 239);">
	&nbsp;&nbsp;&nbsp;&nbsp;${message}
	<h7>3秒后跳转到主页面，若没有跳转请点击<a href="${pageContext.request.contextPath}/index.jsp">这里</a> </h7>
	<%
		response.setHeader("refresh", "3;URL=http://localhost:8080/xinhua_library/index.jsp");
	%>
</body>
</html>