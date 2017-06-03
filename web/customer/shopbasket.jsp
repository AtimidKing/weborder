<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-12
  Time: 上午10:14
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
    <title>购物车</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-static-top main-navbar" id="top">
        <div class="container">
            <div class="navbar-header">
                <ul class="ulh nav navbar-nav">
                    <li><a href="/weborder/customer/index.action">首页</a></li>
                    <li><a href="/weborder/customer/classification.jsp">分类</a></li>
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
        <caption align="centre">购物车</caption>
        <thead>
        <tr>
            <th>乐器编号</th>
            <th>乐器图片</th>
            <th>乐器名称</th>
            <th>数量</th>
            <th>乐器描述</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" var="product">
            <tr><form action="/weborder/customer/pay.action"  method="POST">
                <td><input class="s" type="text" style="display:none"  name="id" value="<s:property value="#product.getId()"/>"><s:property value="#product.getId()"/></td>
                <td><img width="42" height="42" src="/weborder/image/<s:property value="#product.getImage()"/>"></td>
                <td><s:property value="#product.getName()"/></td>
                <td>
                    <input value="<s:property value="#product.getNumber()"/>" name="amount"
                    onchange=""
                    >
                </td>
                <td><s:property value="#product.getDescribe()"/></td>
                <td><s:a action="/weborder/customer/deleteShopProduct.action?id=%{#product.getId()}&amount=%{#product.getNumber()}"
                         onClick="return window.confirm('确认删除！')">删除</s:a></td>
                <td><input type="submit" value="结算"></td>
            </form>
            </tr>
        </s:iterator>
        </tbody>
        <td><s:a action="clearShopBasket" namespace="/customer"
        onclick="return window.confirm('确认全部删除')"><s:property value="removeall"/> </s:a></td>
        <tfoot>
        </tfoot>
    </table>
</div>
</body>
<style type="text/css">
</style>
</html>
