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
    <title>订单</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-static-top main-navbar" id="top">
        <div class="container">
            <div class="navbar-header">
                <ul class="ulh nav navbar-nav">
                    <li> <a href="/weborder/customer/index.action">首页</a></li>
                    <li><a href="/weborder/customer/shopBasket.action" >购物车</a></li>
                    <li><a href="/weborder/customer/classification.jsp">分类</a></li>
                </ul>
            </div>
            <nav>
                <ul class=" ulh nav navbar-nav navbar-right">
                    <li><a href="/weborder/customer/update.action" target="_blank">我的信息</a>
                    </li>
                    <li><a href="/weborder/customer/exit.action" >退出</a>
                    </li>
                </ul>
            </nav>
        </div>
    </nav>

    <label><s:actionerror/></label>
    <label><s:actionmessage/></label>
    <table class="table">
        <caption align="centre">订单记录</caption>
        <thead>
        <tr>
            <th>订单编号</th>
            <th>乐器名称</th>
            <th>乐器图片</th>
            <th>数量</th>
            <th>订单价格</th>
            <th>下单时间</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="list" var="order">
            <tr>
                <td><s:property value="#order.getId()"/></td>
                <td><s:property value="#order.getName()"/></td>
                <td><img width="42" height="42" src="/weborder/image/<s:property value="#order.getImage()"/>"></td>
                <td><s:property value="#order.getNumber()"/></td>
                <td><s:property value="#order.getTotal"/></td>
                <td><s:property value="#order.getDate"/></td>
                <td><s:a action="/weborder/customer/deleteOrder.action?id=%{#order.getId()}"
                         onClick="return window.confirm('删除订单！')">删除</s:a></td>
            </tr>
        </s:iterator>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</div>
</body>
</html>
