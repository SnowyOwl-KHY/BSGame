<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/6
  Time: 上午3:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="/static/js/util.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/css/util.css"/>
</head>
<body style="background: url(/static/resource/login/login.jpg) no-repeat center; background-size: cover; text-align: center">
<div class="Absolute-Center">
    <img src="/static/resource/login/login-board.png" width="350px" />
    <form action="/login" method="get" class="Absolute-Center">
        <p style="color: white">账号：<input type="text" id="username"/></p>
        <p style="color: white">密码：<input type="password" id="password"/></p>
        <a onclick="login()"><img src="/static/resource/login/login-button.png" width="100px" /></a>
    </form>
</div>
<script>
    if (${wrongAccount}) {
        alert("账号/密码错误");
    }
</script>

</body>
</html>
