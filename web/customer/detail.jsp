<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/5/23
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>商品详情</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"/>
    <link href="/weborder/css/navbar.css" rel="stylesheet">
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        body{
            background-color: #eee;
        }
        img {
            margin-top: 20px;
            width: 400px;
            height: 500px;
        }

        .detail-list ul {
            font-size: 15px;
            margin-top: 20px;
            margin-left: 20px;
            height: 150px;
            list-style-type: none;
        }
        .detail-list ul li{
            margin: 10px;
            font-size: 20px;
        }
        .image {
            margin:10px;
            float: left;
        }
        .detail-list{
            padding: 10px;
        }
        .btn-list{
            display: inline;
            margin: auto;
            font-size: 15px;
        }
        .btn-list .btn{
            margin-left: 20px;
        }
    </style>
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
    <div class="container">
        <h1>商品详情</h1>
        <div class="content">
            <div class="image">
                <img src="/weborder/image/${product.productPicture}">
            </div>

            <div class="detail-list">
                <ul>
                    <li style="font-size: 25px">${product.productName}</li>
                    <li>单价:￥&nbsp;${product.productPrice}</li>
                    <li>重量:${product.productWeight}&nbsp; kg</li>
                    <li>描述:${product.productDescribe}</li>
                </ul>
            </div>
            <div class="btn-list">
                <a class="btn btn-default" href="/weborder/customer/index.action">返回</a>
                <a class="btn btn-default" href="/weborder/customer/addShopBasket.action?id=${product.id}">添加到购物车</a>

            </div>
        </div>
    </div>
</div>
</body>
</html>
