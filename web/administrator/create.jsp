<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-12
  Time: 上午10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
    <link href="/weborder/css/register.css" rel="stylesheet">
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>添加商品</title>
</head>
<body>
<div class="container">
<p class="text-right" >
    <a href="/weborder/administrator/index.action">首页</a>
</p>
</div>
<div class="container">

    <label><s:actionerror/></label>
    <label><s:actionmessage/></label>
    <form class="form-register" action="/weborder/administrator/create" enctype="multipart/form-data" method="post">
        <h2 align="center">添加商品</h2>
        <label for="inputId" class="sr-only">商品编号</label>
        <input type="text" id="inputId" class="form-control" name="product.id"
               placeholder="商品编号" required autofocus>

        <label for="inputName" class="sr-only">商品名称</label>
        <input type="text" id="inputName" class="form-control" name="product.productName"
               placeholder="商品名称" required>

        <input type="text" id="inputCatagory" class="form-control" name="product.productCatagory"
               placeholder="商品种类" required>

        <input type="text" id="inputPrice" class="form-control" name="product.productPrice"
               placeholder="商品单价">
        <label for="inputWeight" class="sr-only">重量</label>
        <input type="text" id="inputWeight" class="form-control" name="product.productWeight"
               placeholder="重量" required>

        <label for="inputDescribe" class="sr-only">商品描述</label>
        <input type="text" id="inputDescribe" class="form-control" name="product.productDescribe"
               placeholder="商品描述">


        <label for="inputPicture" class="lb">图片</label>
        <input type="file" id="inputPicture" class="form-control" name="image"
               placeholder="商品图片">
        <button class="btn btn-lg  btn-block" type="submit">添加</button>

    </form>
</div>
</body>
</html>
