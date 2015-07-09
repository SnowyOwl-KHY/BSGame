<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>兵营</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript" src="/static/js/util.js"></script>
</head>
<body>

<script>
    var username = "${username}";
    var type = "${type.name}";
    var buildingId = ${id};
    var level = ${level};
    var presentGold = ${presentGold};
</script>

<table border="1">
    <tr>
        <td rowspan="2">
            <img src="/static/resource/city/${type.name}.png"/>
        </td>

        <td align="center">${type.title}</td>
        <td align="center">${level}级</td>
    </tr>
    <tr>
        <td align="center">${type.desc}</td>
        <td align="center">
            <div>
                <p>升级需要${type.cost}木材</p>
                <img src="/static/resource/city/levelup.png" width="100px"
                     onclick="buildStructure(username, type, buildingId, level+1)"/>
            </div>
        </td>
    </tr>

    <%
        if (request.getAttribute("buildingType").equals("barracks")) {
    %>

    <c:forEach items="${soldierTypes}" var="soldierType">
        <tr>
            <td rowspan="2" align="center">
                <img src="/static/resource/soldier/${soldierType.name}.png" width="30px"/>
            </td>
            <td align="center">
                    ${soldierType.title}
            </td>
            <td align="center">
                <p>数量: <input id="${soldierType.name}Number" type="text" value="1" align="right" width="100px"/></p>
            </td>
        </tr>
        <tr>
            <td align="center">
                <div>
                    <p>${soldierType.desc}</p>
                    <p>费用: ${soldierType.cost}金币</p>
                </div>
            </td>
            <td align="center">
                <script>
                    var ${soldierType.name}InputId = "${soldierType.name}Number";
                    var ${soldierType.name}Type = "${soldierType.name}";
                    var ${soldierType.name}Cost = ${soldierType.cost};
                </script>
                <div id="${soldierType.name}Train">
                    <img src="/static/resource/soldier/train-button.png" width="100px"
                         onclick="trainSoldier(username, ${soldierType.name}Type, ${soldierType.name}InputId, presentGold, ${soldierType.name}Cost)"/>
                </div>
                <script>
                    var train = document.getElementById("${soldierType.name}Train");
                    if (level < ${soldierType.level}) {
                        train.innerHTML = "<p style=\"color: red;\">需要${soldierType.level}级兵营</p>";
                    }
                </script>
            </td>
        </tr>
    </c:forEach>
    <%
        }
    %>
</table>
</body>
</html>
