<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-12
  Time: 上午10:08
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
    <title>商品主页</title>
</head>
<body>
<div class="container">
    <p><a href="/weborder/administrator/create.jsp">添加</a> </p>
    <label><s:actionerror/></label>
    <label><s:actionmessage/></label>
    <table class="table">
        <caption align="centre">商品清单</caption>
        <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品描述</th>
            <th>商品种类</th>
            <th>商品价格</th>
            <th>商品重量</th>
            <th>商品图片</th>

        </tr>
        </thead>
        <tbody>

        <s:iterator value="list" var="product">
            <tr>
                <td><s:property value="#product.getId()"/></td>
                <td><s:property value="#product.getProductName()"/></td>
                <td><s:property value="#product.getProductDescribe()"/></td>
                <td><s:property value="#product.getProductCatagory()"/></td>
                <td><s:property value="#product.getProductPrice()"/></td>
                <td><s:property value="#product.getProductWeight()"/></td>
                <td><s:property value="#product.getProductPicture()"/></td>
                <td><img width="42" height="42" src="/image/<s:property value="#product.getProductPicture()"/>"></td>
                <td><s:a action="/weborder/administrator/delete.action?id=%{#product.getId()}"
                         onClick="return window.confirm('确认删除该商品！')">删除</s:a></td>
                <td><s:a action="/weborder/administrator/update.action?id=%{#product.getId()}"
                         >编辑</s:a></td>
            </tr>
        </s:iterator>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</div>
</body>
</html>
