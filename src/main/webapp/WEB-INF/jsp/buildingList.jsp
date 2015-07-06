<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/6
  Time: 下午3:45
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
    <c:forEach items="${buildingList}" var="tableItem">
        <tr>
            <td rowspan="2">
                <script>
                    var username = "${username}";
                    var type = "${tableItem.name}";
                    var buildingId = ${id};
                </script>
                <img src="/static/resource/city/${tableItem.name}.png" onclick="build(username, type, buildingId, 0)"/>
            </td>
            <td align="center">${tableItem.title}</td>
        </tr>
        <tr>
            <td>${tableItem.desc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
