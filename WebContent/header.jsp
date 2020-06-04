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
<title>新华书店图书销售管理系统</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	<!-- 导航条 -->
	<div id="daohang">
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
				<a target="_parent" href="<%=basePath%>/index.jsp"><img
					src="<%=basePath%>/img/logo.jpg" /></a>
				<c:if test="${!empty user}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：<span
						style="color: red; font-weight: bold">${sessionScope.user.name}</span>&nbsp;&nbsp;&nbsp;&nbsp;新华伴您畅游书海。
						<img src="<%=basePath%>/img/gerenzx.png"
						style="margin-left: 1000px" />&nbsp;&nbsp;
					<a href="<%=basePath%>/personalCenter.jsp" style="color: black">个人中心</a>
				</c:if>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<c:if test="${empty user}">
					<div style="float: right; margin-right: 7px; margin-top: 10px">
						<!-- 登录 -->
						<button type="button" class="btn btn-default btn-sm"
							data-toggle="modal" data-target="#myModal">登录</button>
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">登录</h4>
									</div>
									<form action="<%=basePath%>/client/ClientServlet?op=login"
										method="post">
										<div class="modal-body">
											<div class="form-group">
												<label for="exampleInputName2">Username </label> <input
													type="text" name="username" class="form-control"
													id="exampleInputName2" placeholder="Username">
											</div>
											<br>
											<div class="form-group">
												<label for="exampleInputPassword1">Password</label> <input
													type="password" name="password" class="form-control"
													id="exampleInputPassword1" placeholder="Password">
											</div>
											<br>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">登录</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- 注册 -->
						<button type="button" class="btn btn-default btn-sm"
							data-toggle="modal" data-target="#myModal1">注册</button>

						<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">注册</h4>
									</div>
									<form
										action="http://localhost:8080/xinhua_library/client/ClientServlet?op=register"
										method="post">
										<div class="modal-body">
											<div class="form-group">
												<label for="exampleInputName2">Username:</label> <input
													type="text" id="username" name="username"
													class="form-control" id="exampleInputName2"
													placeholder="Username">
											</div>
											<span id="s1"></span> <br>
											<div class="form-group">
												<label for="exampleInputPassword1">Password:</label> <input
													type="password" name="password" class="form-control"
													id="exampleInputPassword1" placeholder="Password">
											</div>
											<div class="form-group">
												<label for="exampleInputName2">Name:</label> <input
													type="text" name="name" class="form-control"
													id="exampleInputName2" placeholder="Name">
											</div>
											<label for="Ssex">性别:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
											<input type="radio" name="sex" value="男">男
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
												type="radio" name="sex" value="女">女 <br>
											<div class="form-group">
												<label for="exampleInputName2">Tel:</label> <input
													type="text" name="tel" class="form-control"
													id="exampleInputName2" placeholder="Telephone number">
											</div>
											<div class="form-group">
												<label for="exampleInputName2">Address:</label> <input
													type="text" name="address" class="form-control"
													id="exampleInputName2" placeholder="Address">
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">关闭</button>
											<button type="submit" class="btn btn-primary">注册</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${!empty user}">
					<div style="float: right; margin-right: 7px; margin-top: 10px">
						<a class="btn btn-default btn-sm" target="_parent"
							href="${pageContext.request.contextPath}/client/ClientServlet?op=layout"
							role="button">注销</a>
					</div>
					<div style="float: right; margin-right: 7px; margin-top: 10px">
						<a class="btn btn-default btn-sm" target="_parent"
							href="<%=basePath%>/showCart.jsp" role="button">购物车</a>
					</div>
					<div style="float: right; margin-right: 7px; margin-top: 10px">
						<a class="btn btn-default btn-sm" target="_parent"
							href="<%=basePath%>/client/ClientServlet?op=showfavorite"
							role="button">收藏夹</a>
					</div>
				</c:if>
				<div style="float: right; margin-right: 7px; margin-top: 10px">
					<a class="btn btn-default btn-sm"
						href="${pageContext.request.contextPath}/manager/managerLogin.jsp"
						role="button">管理员入口</a>
				</div>
			</div>
		</div>
		</nav>
	</div>

	<div>
		<!-- 轮播图 -->
		<div class="container-fluid">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- 轮播图的中的小点 -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
				</ol>
				<!-- 轮播图的轮播图片 -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="<%=basePath%>/img/lb_01.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="<%=basePath%>/img/lb_02.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="<%=basePath%>/img/lb_03.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="<%=basePath%>/img/lb_04.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
					<div class="item">
						<img src="<%=basePath%>/img/lb_05.jpg">
						<div class="carousel-caption">
							<!-- 轮播图上的文字 -->
						</div>
					</div>
				</div>

				<!-- 上一张 下一张按钮 -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>

	<!-- 书籍导航条 -->
	<nav class="navbar navbar-default" style="
    margin-bottom: 0px;
">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">书籍分类</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="<%=basePath%>/client/ClientServlet?op=wxys">文学艺术</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a href="<%=basePath%>/client/ClientServlet?op=rwsk">人文社科</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a href="<%=basePath%>/client/ClientServlet?op=sets">少儿童书</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a href="<%=basePath%>/client/ClientServlet?op=jyks">教育考试</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a href="<%=basePath%>/client/ClientServlet?op=jjjr">经济金融</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<li><a href="<%=basePath%>/client/ClientServlet?op=kxjs">科学技术</a></li>
			</ul>
			<!-- 搜索框 -->
			<div style="float: right; margin-right: 7px">
				<form class="navbar-form navbar-left"
					action="<%=basePath%>/client/ClientServlet?op=search" method="post">
					<div class="form-group">
						<input type="text" name="search" class="form-control"
							placeholder="搜索/书籍名称">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
			</div>
		</div>
	</div>
	</nav>
</body>
</html>