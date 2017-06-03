<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-12
  Time: 上午10:12
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
    <link href="/weborder/css/navbar.css" rel="stylesheet">
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>web首页</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-static-top main-navbar" id="top">
        <div class="container">
            <div class="navbar-header">
                <ul class="ulh nav navbar-nav">
                    <li><a href="/weborder/customer/classification.jsp">分类</a></li>
                    <li><a href="/weborder/customer/shopBasket.action">购物车</a></li>
                    <li><a href="/weborder/customer/order.action" target="_blank">我的订单</a></li>
                </ul>
            </div>
            <nav>
                <ul class=" ulh nav navbar-nav navbar-right">
                    <li><a href="/weborder/customer/update.action" target="_blank">我的信息</a>
                    </li>
                    <li><a href="/weborder/customer/exit.action">退出</a>
                    </li>
                </ul>
            </nav>
        </div>
    </nav>
    <label><s:actionerror/></label>
    <label><s:actionmessage/></label>
    <table class="table">
        <caption align="centre">乐器清单</caption>
        <thead>
        <tr>
            <th>乐器编号</th>
            <th>乐器图片</th>
            <th>乐器名称</th>
            <th>乐器分类</th>
            <th>乐器描述</th>
            <th>乐器价格</th>
            <th>乐器重量</th>

        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" var="product">
            <tr>
                <td><s:property value="#product.getId()"/></td>

                <td>
                    <s:a href="/weborder/customer/detail.action?id=%{#product.getId()}">
                        <img width="42" height="42" src="/weborder/image/<s:property value="#product.getProductPicture()"/>">
                    </s:a>
                </td>

                <td><s:property value="#product.getProductName()"/></td>
                <td><s:property value="#product.getProductCatagory()"/></td>
                <td><s:property value="#product.getProductDescribe()"/></td>
                <td><s:property value="#product.getProductPrice()"/></td>
                <td><s:property value="#product.getProductWeight()"/></td>
                <td><s:a action="/weborder/customer/addShopBasket.action?id=%{#product.getId()}"
                         onClick="return window.confirm('确认添加到购物车！')">添加到购物车</s:a></td>

            </tr>
        </s:iterator>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</div>
</body>
</html>
