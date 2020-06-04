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
<title>添加书籍信息</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 25px; margin-top: 20px; margin-left: 42px">添加书籍信息</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<form style="margin-top: 30px; margin-left: 450px"
		action="<%=basePath%>/manager/ManagerServlet?op=addBook" method="post"
		enctype="multipart/form-data">
		<div class="form-group">
			<label>书籍名称：</label> <input type="text" class="form-control"
				id="book_name" name="book_name" placeholder="书籍名称"
				style="width: 700px">
		</div>
		<div class="form-group">
			<label>书籍作者：</label> <input type="text" class="form-control"
				id="book_author" name="book_author" placeholder="书籍作者"
				style="width: 700px">
		</div>
		<div class="form-group">
			<label>书籍出版社：</label> <input type="text" class="form-control"
				id="book_press" name="book_press" placeholder="书籍出版社"
				style="width: 700px">
		</div>
		<div class="form-group">
			<label>书籍分类：</label> <select class="form-control" name="categoryid"
				title="书籍分类" style="width: 700px">
				<option selected="selected">---所属分类---</option>
				<c:forEach items="${cs}" var="c">
					<option value="${c.category_id}">${c.category_name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="exampleInputFile">图片上传：</label> <input type="file"
				id="file" name="file">
		</div>
		<div class="form-group">
			<label>书籍简介：</label>
			<textarea class="form-control" rows="3" id="book_desc"
				name="book_desc" placeholder="书籍简介" style="width: 700px"></textarea>
		</div>
		<div class="form-group">
			<label>书籍单价：</label> <input type="text" class="form-control"
				id="book_price" name="book_price" placeholder="书籍单价/￥"
				style="width: 700px">
		</div>
		<div class="form-group">
			<label>书籍库存：</label> <input type="text" class="form-control"
				id="book_kunumber" name="book_kunumber" placeholder="书籍库存"
				style="width: 700px">
		</div>
		<br>
		<button type="submit" class="btn btn-default"
			onclick="window.location='manager/ManagerServlet?op=addBook'">提交</button>
		<button type="button" class="btn btn-default" data-dismiss="modal"
			style="margin-left: 100px"
			onclick="window.location='managerIndex.jsp'">关闭</button>
	</form>
</body>
</html>