<%--
  Created by IntelliJ IDEA.
  User: yking
  Date: 17-5-12
  Time: 上午10:16
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
    <title>用户注册</title>
</head>
<body>
<div class="container">
    <label><s:actionerror/></label>
    <form class="form-register" action="/weborder/customer/register.action" method="post">
        <h2 class="form-register-heading">用户注册</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control"
               name="customer.id"
               placeholder="用户名" required autofocus>

        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control"
               name="customer.csrPwd"
               placeholder="密码" required>

        <label for="inputRepassword" class="sr-only">确认密码</label>
        <input type="password" id="inputRepassword" class="form-control"
               name="rePassword"
               placeholder="确认密码" required>

        <label for="inputName" class="sr-only">姓名</label>
        <input type="text" id="inputName" class="form-control"
               name="customer.csrName"
               placeholder="姓名" required>

        <label for="inputSex" class="sr-only">性别</label>
        <input type="text" id="inputSex" class="form-control"
               name="customer.csrSex"
               placeholder="性别" required>

        <label for="inputTel" class="sr-only">联系电话</label>
        <input type="tel" id="inputTel" class="form-control"
               name="customer.csrTel"
               placeholder="联系电话" required>

        <label for="inputAddress" class="sr-only">联系地址</label>
        <input type="text" id="inputAddress" class="form-control"
               name="customer.csrAddress"
               placeholder="联系地址" required>


        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
        <a class="register-link" href="/weborder/clogin.jsp">已有账号点这里</a>
    </form>

</div>
</body>
</html>
