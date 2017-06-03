<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/5/16
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>分类</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-static-top main-navbar" id="top">
        <div class="container">
            <div class="navbar-header">
                <ul class="ulh nav navbar-nav">
                    <li><a href="/weborder/customer/index.action">首页</a></li>
                    <li><a href="/weborder/customer/shopBasket.action">购物车</a></li>
                    <li><a href="/weborder/customer/order.action" target="_blank">我的订单</a></li>
                    <li>
                    </li>
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
    <h1>乐器分类表</h1>

    <div class="mc">
        <ul>
            <li class="p-item instruments">
                <div class="p-wrap">
                    <a href="/weborder/customer/index.action" target="_blank" title="乐器总览">
                        <div class="p-img">

                            <img src="../image/music.jpg" width="230" height="240">
                        </div>
                        <div class="p-name"><p><b>乐器总览</b></p></div>

                    </a>
                </div>
            </li>
            <li class="p-item piano">
                <div class="p-wrap">
                    <a href="/weborder/customer/index.action?catagory=钢琴" target="_blank" title="钢琴">
                        <div class="p-img">
                            <img src="/weborder/image/piano.jpg" width="230" height="240">
                        </div>
                        <div class="p-name"><p><b>钢琴</b></p></div>
                    </a>
                </div>
            </li>
            <li class="p-item guitar">
                <div class="p-wrap">
                    <a href="/weborder/customer/index.action?catagory=吉他" target="_blank" title="吉他">
                        <div class="p-img">
                            <img src="/weborder/image/guitar.jpg" width="230" height="240">
                        </div>
                        <div class="p-name"><p><b>吉他</b></p></div>
                    </a>
                </div>
            </li>
            <li class="p-item drum">
                <div class="p-wrap">
                    <a href="/weborder/customer/index.action?catagory=架子鼓" target="_blank" title="架子鼓">
                        <div class="p-img">

                            <img src="/weborder/image/drum.jpg" width="230" height="240">

                        </div>
                        <div class="p-name"><p><b>架子鼓</b></p></div>
                    </a>
                </div>
            </li>
            <li class="p-item violin">
                <div class="p-wrap">
                    <a href="/weborder/customer/index.action?catagory=提琴" target="_blank" title="提琴">
                        <div class="p-img">

                            <img src="/weborder/image/violin.jpg" width="230" height="240">
                        </div>
                        <div class="p-name"><p><b>提琴</b></p></div>

                    </a>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
<style type="text/css">
    .ulh {
        height: 50px;
    }
    .sh{
        font-size: 15px;
        display: inline;
        height: 50px;
    }
    .container > .navbar-header {
        margin-right: 0;
        margin-left: 0;
    }

    .input-append {
        height: 40px;
        margin-top: 5px;
    }

    .navbar-header {
        float: left;
        font-size: 20px;
    }

    .main-navbar {
        margin-bottom: 0;
        background-color: transparent;
    }

    .navbar-static-top {
        border-radius: 0;
        z-index: 1000;
        border-width: 0 0 1px;
    }

    .navbar {
        position: relative;
        min-height: 50px;
        border: 1px solid transparent;
    }

    .main-navbar .navbar-brand {
        margin-top: 10px;
        margin-bottom: 10px;
        margin-left: 15px;
        height: 30px;
        width: 124px;
    }

    .p-item {
        float: left;
        display: inline;
        width: 244px;
        height: 334px;
    }

    .p-wrap {
        position: relative;
        width: 232px;
        height: 332px;
        border: 1px solid #ccc;
        overflow: hidden;
    }

    .p-img img {
        display: block;
        margin: 0 auto;
    }

    .p-img {
        padding: 17px 0 20px;
    }

    .p-name {
        padding: 0 20px;
        height: 36px;
        line-height: 18px;
        overflow: hidden;
        transition: opacity .4s cubic-bezier(0.215, .61, .355, 1);
    }

    nav {
        font-size: 20px;
    }

    p {
        float: left;
        font-family: arial;
        font-weight: 400;
        font-size: 20px;
    }

    body {
        font: 12px/150% tahoma, arial, Microsoft YaHei, Hiragino Sans GB, "\u5b8b\u4f53", sans-serif;
        -webkit-font-smoothing: antialiased;
        color: #666;
    }

    a, body, div, font, html, img, li, ol, p, span, strong, u, ul, var {
        margin: 0;
        padding: 0;
    }

    div {
        display: block;
    }

    ol, ul {
        list-style: none;
        height: 334px;
        font-family: 'microsoft yahei', Hiragino Sans GB;
    }

    li {
        display: list-item;
        text-align: -webkit-match-parent;
    }

    a {
        color: #666;
        text-decoration: none;
    }

    img {
        border: 0;
        vertical-align: middle;
    }

    .mc {
        overflow: hidden;
        zoom: 1;
        overflow: hidden;
    }

    .container {
        margin-right: auto;
        margin-left: auto;
    }

</style>
</html>

