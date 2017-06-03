<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-16
  Time: 下午12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
      href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
      href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>

<script
        src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>下单支付</title>
</head>
<body>
<div class="container">
    <h1>确认订单</h1>
    <div class="oder-list">
        <ul>
            <li> 商品编号：<s:property value="id"/></li>
            <li>商品名称：<s:property value="name"/></li>
            <li>商品单价：￥&nbsp;<s:property value="price"/></li>
            <li>商品数量：<s:property value="amount"/></li>
            <li>总价：￥&nbsp;<s:property value="total"/></li>
        </ul>

    </div>

    <div class="pay">
        支付方式:
        <ul>
            <li>
                <input type="radio" name="pay" id="alipay" checked="checked">
                <img width="100" height="50" src="/weborder/image/ali.jpg" title="支付宝" >
            </li>
            <li>
                <input type="radio" name="pay" id="weixinpay" >
                <img width="100" height="50" src="/weborder/image/weix.jpg" title="微信">
            </li>
        </ul>
        <ul>
            <li>
                <a class=" btn btn-default"
                   href="/weborder/customer/addOrder.action?id=<s:property value="id"/>&amount=<s:property value="amount"/>"
                   onclick="return window.alert('请确认支付')">确认</a>
            </li>
            <li>
                <a class="btn btn-default " href="/weborder/customer/shopBasket.action"
                   onclick="return window.alert('取消支付成功')">取消</a>
            </li>
        </ul>
    </div>
</div>
</body>
<style type="text/css">
    body {
        font-size: 20px;
        padding: 20px;
        margin: auto;
        color: #666;

    }
    .container ,.oder-list ,.pay{
        margin: auto;
    }

    ul {
        width: 65%;
        padding: 5px;
    }

    .oder-list ul {
        width: 65%;
        margin-top: 10px;
        list-style-type: none;
    }

    .pay ul li {
        width: 65%;
        padding: 5px;
        display: inline;
    }

    .pay{
        margin-top: 10px;
        padding: 5px;
    }
</style>
</html>
