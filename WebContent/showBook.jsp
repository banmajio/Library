<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新华书店图书销售管理系统</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript"
		src="<%=basePath%>/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<jsp:include page="/header.jsp"></jsp:include>
	<table class="table table-bordered table-hover"
		style="margin-left: 16px; width: 1890px">
		<tr>
			<th style="width: 100px">书籍编号</th>
			<th style="width: 100px">书籍图片</th>
			<th style="width: 200px">书籍名称</th>
			<th style="width: 200px">书籍类型</th>
			<th style="width: 200px">书籍作者</th>
			<th style="width: 300px">书籍出版社</th>
			<th style="width: 200px">书籍价格</th>
			<th style="width: 200px">销量</th>
			<th style="width: 200px">操作</th>
		</tr>
		<c:forEach items="${books}" var="s" varStatus="vs">
			<tr class="active">
				<td>${vs.index+1}</td>
				<td><img style="width: 80px; height: 100px"
					src="${pageContext.request.contextPath}/img/${s.path}/${s.filename}" />
				</td>
				<td>《${s.book_name}》</td>
				<td>${s.category.category_name}</td>
				<td>${s.book_author}</td>
				<td>${s.book_press}</td>
				<td><span style="color: rgb(198, 46, 45); font-weight: bold">￥${s.book_price}</span></td>
				<td>${s.book_xiaonumber}</td>
				<td><a
					href="<%=basePath%>/client/ClientServlet?op=particulars&book_id=${s.book_id}">详情</a></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>