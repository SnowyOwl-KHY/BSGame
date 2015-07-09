<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/9
  Time: 上午4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="0">
    <tr>
        <td rowspan="3" align="center"  style="padding: 30px;">
            <img src="/static/resource/plat/${siteType}.png" width="200px" height="100px"/>
        </td>
        <td align="center">
            <div style="padding: 20px;">
                ${playerName}
            </div>
        </td>
        <td rowspan="2" align="center"  style="padding: 30px;">
            <%
                if (request.getAttribute("isSelf").equals(false)) {
            %>
            <a href="/attack?username=${username}&targetX=${targetX}&targetY=${targetY}">
                <img src="/static/resource/plat/attack.png" width="100px"/>
            </a>
            <%
                } else {
            %>
            <p style="color: red">您不能进攻自己的城市</p>
            <%
                }
            %>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center" style="padding: 10px">
                <c:forEach items="${soldierList}" var="soldier">
                    <div style="float: left; margin: 10px;">
                        <img src="/static/resource/soldier/${soldier.type.name}.png" width="30px"/>
                        <p align="center">${soldier.number}</p>
                    </div>
                </c:forEach>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center" style="padding: 10px">
                <c:forEach items="${resourceList}" var="resource">
                    <div style="float: left; margin: 10px;">
                        <img src="/static/resource/resource/${resource.type.name}.png" width="30px" />
                        <p align="center">${resource.number}</p>
                    </div>
                </c:forEach>
            </div>
        </td>
        <td align="center" style="padding: 30px;">
            <a href="/plat?username=${username}">
                <img src="/static/resource/plat/back.png" width="100px"/>
            </a>
        </td>
    </tr>
</table>
</body>
</html>
