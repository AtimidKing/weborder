<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/site.min.css" rel="stylesheet">

<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<title>图书管理</title>
</head>
<body class="home-template">
	<header class="site-header jumbotron">
	<div class="container">
		<a href="../user/borrowrecord.action"
			class="button button-primary button-small" style="float: right;">我的借书记录</a>
		<div class="row">
			<div class="col-xs-12">
				<h1>图书管理</h1>
				<form class="" role="search" style="margin-top: 20px">
					<div class="form-group">
						<input type="text" class="form-control search clearable"
							placeholder="搜索图书，例如：java"> <i class="fa fa-search"></i>
					</div>
				</form>
			</div>
		</div>
	</div>
	</header>

	<div class="container">
		<a href="../library/add.jsp" class="btn btn-primary"
			style="background-color: #D3D3D3">添加图书</a>
		<div class="container" style="margin-top: 10px">
			<table class="table table-striped">

				<tr>
					<th>图书编号</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>出版日期</th>
					<th>地址</th>
				</tr>
				<s:iterator value="listBook" var="book">
					<tr>
						<td><s:property value="#book.getId()" /></td>
						<td><s:property value="#book.getName()" /></td>
						<td><s:property value="#book.getAuthor()" /></td>
						<td><s:property value="#book.getPublishunit()" /></td>
						<td><s:property value="#book.getPublishdate()" /></td>
						<td><s:property value="#book.getAddress()" /></td>
						<td><s:a action="/books/delete.action?id=%{#book.getId()}"
								onClick="return window.confirm('删除该行数据')">删除</s:a></td>
						<td><s:a action="modify.action?id=%{#book.getId()}">修改</s:a></td>
						<td><s:a
								action="../record/borrow.action?book.id=%{#book.getId()}"
								onClick="return window.confirm('确认借书')">借书</s:a></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>


</body>
</html>