<%--
  Created by IntelliJ IDE
  User: yking
  Date: 17-5-12
  Time: 上午10:11
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
    <link href="/weborder/css/input.css" rel="stylesheet">
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>修改商品</title>
</head>
<body>
<div class="container">
    <p class="text-right" >
        <a href="/weborder/administrator/index.action"><b>首页<b></b></B></a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    </p>
</div>
<div class="container">
    <label color="red"><s:actionerror/></label>
    <label color="red"><s:actionmessage/></label>
    <form class="form-list" action="/weborder/administrator/update.action">
            <h2 align="center">商品修改</h2>
            <label for="inputId" class="sr-only">商品编号</label>
            <input type="text" id="inputId" class="form-control" name="product.id"
                   value="${product.id}"
                   placeholder="商品编号" readonly>

            <label for="inputName" class="sr-only">商品名称</label>
            <input type="text" id="inputName" class="form-control" name="product.productName"
                   value="${product.productName}"
            placeholder="商品名称" required>

            <input  type="text" id="inputCatagory" class="form-control" name="product.productCatagory"
                    value="${product.productCatagory}"
            placeholder="商品种类" required>

            <input  type="text" id="inputPrice" class="form-control" name="product.productPrice"
                    value="${product.productPrice}"
            placeholder="商品单价">
            <label for="inputWeight" class="sr-only">重量</label>
            <input  type="text" id="inputWeight"  class="form-control" name="product.productWeight"
                    value="${product.productWeight}"
            placeholder="重量" required>

            <label for="inputDescribe" class="sr-only">商品</label>
            <input  type="text" id="inputDescribe" class="form-control" name="product.productDescribe"
                    value="${product.productDescribe}"
            placeholder="商品描述" >
        <button class="btn btn-lg  btn-block" type="submit">添加</button>
    </form>
</div>
</body>
</html>
