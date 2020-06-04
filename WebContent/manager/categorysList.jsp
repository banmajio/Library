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
<title>书籍分类维护</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<table class="table table-bordered table-hover" style="width: 100%">
		<tr>
			<th style="width: 100px">序号</th>
			<th style="width: 100px">分类名称</th>
			<th style="width: 100px">分类描述</th>
			<th style="width: 200px">操作</th>
		</tr>
		<c:forEach items="${categorys}" var="s" varStatus="vs">
			<tr class="active">
				<td>${vs.index+1}</td>
				<td>${s.category_name}</td>
				<td>${s.category_desc}</td>
				<td><a
					href="<%=basePath%>/manager/ManagerServlet?op=editCategoryUI&category_id=${s.category_id}">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a
					href="<%=basePath%>/manager/ManagerServlet?op=delCategory&category_id=${s.category_id}"
					onclick="if(confirm('确定删除'+'  《${s.category_name}》'+'   分类吗'+'?')===false) return false;">删除</a>
			</tr>
		</c:forEach>
	</table>
</body>
</html>