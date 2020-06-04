<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
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
	<script type="text/javascript" src="<%=basePath%>/js/util.js"></script>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById("bt1").onclick = function() {
				var book_id = "${book.book_id}";
				//01.获取ajax引擎,获取ajax的XMLHttpRequest核心对象
				var xhr = getXhr();
				//02.注册事件,监测readystate值的变化
				xhr.onreadystatechange = function() {
					//什么时候执行,服务器响应完成之后
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {

						}
					}
				}
				//03.发送请求
				xhr.open("get",
						"/xinhua_library/client/ClientServlet?op=addCart&book_id="
								+ book_id);
				//04.发送请求正文
				xhr.send(null);
				alert("添加成功!");
			}

			document.getElementById("a1").onclick = function() {
				alert("添加成功");
				var book_id = "${book.book_id}";
				//01.获取ajax引擎,获取ajax的XMLHttpRequest核心对象
				var xhr = getXhr();
				//02.注册事件,监测readystate值的变化
				xhr.onreadystatechange = function() {
					//什么时候执行,服务器响应完成之后
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {

						}
					}
				}
				//03.发送请求
				xhr.open("get",
						"/xinhua_library/client/ClientServlet?op=addfavorite&book_id="
								+ book_id);
				//04.发送请求正文
				xhr.send(null);
			}
		}
	</script>
	<jsp:include page="/header1.jsp"></jsp:include>
	<div
		style="background-color: rgb(244, 245, 244); margin-top: 50px; margin-left: 380px; width: 1150px; height: 50px">
		<div style="padding-top: 9px">
			<span style="font-size: 25px; margin-left: 20px;">《${book.book_name}》</span><a
				href="#" onClick="javascript:history.go(-1);"><span
				class="label label-default" style="float: right;">返回</span></a>
		</div>

	</div>
	<div
		style="margin-top: 50px; margin-left: 380px; width: 1150px; height: 600px">
		<div
			style="width: 500px; height: 600px; float: left; border: 1px solid rgb(238, 238, 238);">
			<img
				style="width: 440px; height: 540px; margin-top: 25px; margin-left: 30px"
				src="${pageContext.request.contextPath}/img/${book.path}/${book.filename}" />
		</div>
		<div style="width: 640px; height: 600px; float: right;">
			<!-- 书籍名称 -->
			<div style="margin-top: 25px">
				<span
					style="font: 700 16px Arial, 'microsoft yahei'; color: #666; padding-top: 10px; line-height: 28px; margin-bottom: 5px; margin-left: 10px">《${book.book_name}》</span>
			</div>
			<!-- 作者出版社 -->
			<div style="margin-left: 18px; margin-top: 15px">
				<span style="font-size: 5px; color: #1890FF;">${book.book_press}</span>
				&nbsp;<strong>编</strong>&nbsp;&nbsp;&nbsp; <span
					style="font-size: 5px; color: #1890FF;">${book.book_author}</span>
				&nbsp;<strong>著</strong>
			</div>
			<!-- 价格&销量 -->
			<div
				style="margin-top: 20px; margin-left: 18px; width: 620px; height: 270px; background-color: rgb(247, 245, 241)">
				<img alt="bg——img" src="<%=basePath%>/img/seckilling.png">
				<div style="margin-top: 20px; margin-left: 30px">
					<span style="color: rgb(153, 153, 153)">所属分类:</span>&nbsp;&nbsp;&nbsp;${book.category.category_name}<br>
					<span style="color: rgb(153, 153, 153)">书籍描述:</span>
					<textarea disabled="disabled" class="form-control" rows="3"
						id="book_desc" name="book_desc" placeholder="${book.book_desc}"
						style="width: 570px; margin-top: 7px; margin-bottom: 7px"></textarea>
					<span style="color: rgb(153, 153, 153)">书籍单价:</span><span
						style="font-size: 16px; font-weight: 700; color: #C62E2D">&nbsp;&nbsp;￥${book.book_price}</span><br>
					<span style="color: rgb(153, 153, 153)">书籍库存:</span>&nbsp;&nbsp;&nbsp;${book.book_kunumber}&nbsp;本<br>
					<span style="color: rgb(153, 153, 153)">书籍销量:</span>&nbsp;&nbsp;&nbsp;${book.book_xiaonumber}&nbsp;本<br>
				</div>
			</div>
			<!-- 收藏 -->
			<c:if test="${!empty user}">
				<div style="margin-top: 20px; margin-left: 25px">
					<a id="a1" href="#" onclick="javascript:favorite();return false;"
						style="text-decoration: none; color: black"><img
						src="<%=basePath%>/img/shoucang.png"
						style="widows: 20px; height: 20px" />添加收藏</a>
				</div>
			</c:if>
			<c:if test="${empty user}">
				<div style="margin-top: 20px; margin-left: 25px">
					<a href="javascript:add()"
						style="text-decoration: none; color: black"><img
						src="<%=basePath%>/img/shoucang.png"
						style="widows: 20px; height: 20px" />添加收藏</a>
				</div>
			</c:if>
			<!-- 加入购物车和购买 -->
			<div style="margin-top: 60px; margin-left: 120px">
				<c:if test="${!empty user}">
					<button type="button" class="btn btn-default"
						style="width: 160px; height: 43px; border-color: rgb(198, 46, 45)"
						id="bt1">
						<span style="font-size: 16px; color: rgb(198, 46, 45)">加入购物车</span>
					</button>
				</c:if>
				<c:if test="${empty user}">
					<button type="button" class="btn btn-default"
						style="width: 160px; height: 43px; border-color: rgb(198, 46, 45)"
						id="bt2" onclick="cart()">
						<span style="font-size: 16px; color: rgb(198, 46, 45)">加入购物车</span>
					</button>
				</c:if>
				<button type="button" class="btn btn-danger"
					style="background-color: rgb(198, 46, 45); width: 160px; height: 43px; margin-left: 100px">
					<span style="font-size: 16px">立即购买</span>
				</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function cart() {
			alert("请先登录！");
		}
		function add() {
			alert("请先登录！");
		}
	</script>
</body>
</html>