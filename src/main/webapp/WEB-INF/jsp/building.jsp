<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/6
  Time: 下午7:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/static/js/util.js"></script>
</head>
<body>
<table border="1">
    <tr>
        <td rowspan="2">
            <img src="/static/resource/city/${type.name}.png" />
        </td>

        <td align="center">${type.title}</td>
        <td>${level}级</td>
    </tr>
    <tr>
        <td align="center">${type.desc}</td>
        <td>
            <script>
                var username = "${username}";
                var type = "${type.name}";
                var buildingId = ${id};
                var level = ${level};
            </script>
            <img src="/static/resource/city/levelup.png" width="100px" onclick="build(username, type, buildingId, level+1)" />
        </td>
    </tr>
</table>
</body>
</html>
