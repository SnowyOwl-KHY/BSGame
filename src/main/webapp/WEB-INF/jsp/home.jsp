<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/5
  Time: 下午10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城内</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div>

    <img src="/static/resource/city/cityBackground.jpg" width="1000px" />

    <c:forEach items="${soldiers}" var="soldier">
        <div style="position: absolute; top: 20px; left: ${soldier.type.left};">
            <img src="/static/resource/soldier/${soldier.type.name}.png" width="30px" />
            <p align="center" style="color: white;">${soldier.number}</p>
        </div>
    </c:forEach>

    <c:forEach items="${resources}" var="resource">
        <div style="position: absolute; top: 680px; left: ${resource.type.left};">
            <img src="/static/resource/resource/${resource.type.name}.png" width="30px" />
            <p align="center" style="color: white;">${resource.number}</p>
        </div>
    </c:forEach>

    <c:forEach items="${buildings}" var="building">
        <div style="position: absolute; top: ${building.top}px; left: ${building.left}px;">
            <a href="/building?username=${username}&id=${building.id}">
                <img src="/static/resource/city/${building.type.name}.png" height="${building.height}px" width="${building.width}px" />
            </a>
        </div>
    </c:forEach>

    <div style="position: absolute; top: 700px; left: 880px">
        <a href="/plat?username=${username}">
            <img src="/static/resource/city/plat.png" width="100px" />
        </a>
    </div>

</div>
</body>
</html>
