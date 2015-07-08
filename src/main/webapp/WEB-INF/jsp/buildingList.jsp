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
    <title>建造</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/static/js/util.js"></script>
</head>
<body>
<script>
    var username = "${username}";
    var buildingId = ${id};
    var presentWood = ${presentWood};
</script>
<table border="1">
    <c:forEach items="${buildingTypeList}" var="tableItem">
        <tr>
            <td rowspan="2">
                <img src="/static/resource/city/${tableItem.name}.png" />
            </td>
            <td align="center">${tableItem.title}</td>
            <td rowspan="2" align="center">
                <script>
                    var ${tableItem.name}Type = "${tableItem.name}";
                </script>
                <div id="${tableItem.name}Build">
                    <img src="/static/resource/city/build.png" width="100px"
                         onclick="buildStructure(username, ${tableItem.name}Type, buildingId, 1)" />
                </div>
                <script>
                    var build = document.getElementById("${tableItem.name}Build");
                    if (presentWood < ${tableItem.cost}) {
                        build.innerHTML = "<p style=\"color: red;\">木材不足</p>";
                    }
                </script>
            </td>
        </tr>
        <tr>
            <td>${tableItem.desc}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
