<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/9
  Time: 下午12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <tr>
        <td align="center" style="padding: 40px; font-size: large">
            <p>${result.type.title}</p>
        </td>
    </tr>
    <tr>
        <td align="center" style="padding: 20px">
            <p>获得资源</p>
        </td>
    </tr>
    <tr>
        <td align="center">
            <div align="center" style="padding: 20px">
                <c:forEach items="${result.winResources.resourceList}" var="resource">
                    <div style="float: left; margin: 20px;">
                        <img src="/static/resource/resource/${resource.type.name}.png" width="30px"/>

                        <p align="center">${resource.number}</p>
                    </div>
                </c:forEach>
            </div>
        </td>
    </tr>
    <tr>
        <td align="center" style="padding: 20px">
            <p>损失军队</p>
        </td>
    </tr>
    <tr>
        <td align="center">
            <div align="center" style="padding: 20px">
                <c:forEach items="${result.sourceLostArmy.soldierList}" var="soldier">
                    <div style="float: left; margin: 20px;">
                        <img src="/static/resource/soldier/${soldier.type.name}.png" width="30px"/>

                        <p align="center">${soldier.number}</p>
                    </div>
                </c:forEach>
            </div>
        </td>
    </tr>
    <tr>
        <td align="center" style="padding: 20px">
            <a href="/site?username=${username}&x=${targetX}&y=${targetY}">
                <img src="/static/resource/plat/back.png" width="100px"/>
            </a>
        </td>
    </tr>
</table>

</body>
</html>
