<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/5/11
  Time: 14:33
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
    <title>管理员注册</title>
</head>
<body>
<div class="container">
    <label><s:actionerror/></label>
    <form class="form-register" action="/weborder/administrator/register.action">
        <h2 class="form-register-heading">管理员注册</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control" name="administrator.id"
               placeholder="用户名" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" name="administrator.adminPwd"
               placeholder="密码" required>

        <label for="inputRepassword" class="sr-only">确认密码</label>
        <input type="password" id="inputRepassword" class="form-control" name="rePassword"
               placeholder="确认密码" required>

        <label for="inputTel" class="sr-only">联系电话</label>
        <input type="tel" id="inputTel" class="form-control" name="administrator.adminTelephone"
               placeholder="联系电话" required>

        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        <a class="register-link" href="alogin.jsp">已有账号点这里</a>
    </form>

</div>
<!-- /container -->
</body>
</html>
