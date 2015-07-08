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
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="/static/css/util.css"/>
    <script type="text/javascript" src="/static/js/util.js"></script>
    <script>
        function enterPress() {
            if (event.keyCode == 13) {
                <%
                    if (request.getAttribute("action").equals("login")) {
                %>
                login();
                <%
                    } else {
                %>
                logup();
                <%
                    }
                %>
            }
        }
    </script>
</head>
<body style="background: url(/static/resource/login/login.jpg) no-repeat center; background-size: cover; text-align: center">
<div class="Absolute-Center">
    <img src="/static/resource/login/login-board.png" width="400px"/>

    <form action="/login" method="get" class="Absolute-Center">
        <p style="color: white">账号：<input type="text" id="username"/></p>

        <p style="color: white">密码：<input type="password" id="password" onkeypress="enterPress()" /></p>
        <%
            if (request.getAttribute("action").equals("login")) {
        %>
        <a onclick="login()"><img src="/static/resource/login/login-button.png" width="100px"/></a>
        <a href="/logup"><img src="/static/resource/login/logup-button.png" width="100px"/></a>
        <%
            } else {
        %>
        <p style="color: white">确认密码：<input type="password" id="passwordConfirm" onkeypress="enterPress()"/></p>
        <a onclick="logup()"><img src="/static/resource/login/confirm-button.png" width="100px"/></a>
        <a href="/login"><img src="/static/resource/login/back-button.png" width="100px"/></a>
        <%
            }
        %>
    </form>
</div>
<script>
    <%
        String problem = (String) request.getAttribute("problem");
        if (problem != null && problem.equals("wrongAccount")) {
    %>
    alert("账号或密码错误");
    <%
        } else if (problem != null && problem.equals("existUser")) {
    %>
    alert("该用户已存在");
    <%
        }
    %>
    document.getElementById("username").focus();
</script>

</body>
</html>
