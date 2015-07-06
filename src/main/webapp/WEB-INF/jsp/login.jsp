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
    <link rel="stylesheet" type="text/css" href="/static/css/util.css" />
</head>
<body style="background: url(/static/resource/login.jpg) no-repeat center; background-size: cover; text-align: center">

<form action="/login" method="get" class="Absolute-Center">
    <p>账号：<input type="text" id="username"/></p>
    <p>密码：<input type="password" id="password"/></p>
    <a onclick="login()"><input type="button" value="登陆" /></a>
</form>

</body>
</html>
