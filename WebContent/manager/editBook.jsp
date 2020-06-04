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
<title>编辑书籍信息</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 25px; margin-top: 20px; margin-left: 42px">编辑书籍信息</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />

	<div style="margin-top: 30px; margin-left: 430px">
		<form action="<%=basePath%>/manager/ManagerServlet?op=editBook"
			method="post">
			<div class="form-group">
				<input type="hidden" class="form-control" id="book_id" name="book_id"
					value="${map.book.book_id}" style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍名称：</label> <input type="text" class="form-control"
					id="book_name" name="book_name" value="${map.book.book_name}"
					style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍作者：</label> <input type="text" class="form-control"
					id="book_author" name="book_author" value="${map.book.book_author}"
					style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍出版社：</label> <input type="text" class="form-control"
					id="book_press" name="book_press" value="${map.book.book_press}"
					style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍分类：</label> <select class="form-control" name="categoryid"
					title="书籍分类" style="width: 700px">
					<option selected="selected">${map.book.category.category_name}</option>
					<c:forEach items="${map.category}" var="c">
						<option value="${c.category_id}">${c.category_name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleInputFile">图片上传：</label> <img
					style="width: 80px; height: 100px"
					src="${pageContext.request.contextPath}/img/${map.book.path}/${map.book.filename}" /><input
					type="file" id="file" name="file">
			</div>
			<div class="form-group">
				<label>书籍简介：</label>
				<textarea class="form-control" rows="3" id="book_desc"
					name="book_desc" style="width: 700px">${map.book.book_desc}</textarea>
			</div>
			<div class="form-group">
				<label>书籍单价：</label> <input type="text" class="form-control"
					id="book_price" name="book_price" value="${map.book.book_price}"
					style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍库存：</label> <input type="text" class="form-control"
					id="book_kunumber" name="book_kunumber"
					value="${map.book.book_kunumber}" style="width: 700px">
			</div>
			<br>
			<button type="submit" class="btn btn-default"
				onclick="window.location='manager/ManagerServlet?op=editBook'">提交</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"
				style="margin-left: 100px" onclick="javascript :history.go(-1);">关闭</button>
		</form>
	</div>
</body>
</html>