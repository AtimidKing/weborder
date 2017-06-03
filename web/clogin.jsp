<%--
  Created by IntelliJ IDEA.
  User: king
  Date: 2017/5/15
  Time: 20:43
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
    <link href="/weborder/css/signin.css" rel="stylesheet">
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>登录weborder</title>
</head>
<body>
<div class="container">
    <label color="red"><s:actionerror/></label>
    <label color="red"><s:actionmessage/></label>
    <s:form class="form-signin" action="login" namespace="/customer">
        <h2 class="form-signin-heading">用户请登录</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="inputUsername" class="form-control"
               name="customer.id" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control"
               name="customer.csrPwd" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
        <a class="register-link" href="/weborder/customer/register.jsp">没有账号点这里</a>
    </s:form>
</div>
</body>
</html>
