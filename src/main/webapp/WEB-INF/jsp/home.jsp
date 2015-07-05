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
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div>

    <img src="/static/resource/cityBackground.jpg" width="1000px" />

    <c:forEach items="${buildings}" var="building">
        <div style="position: absolute; top: ${building.top}px; left: ${building.left}px;">
            <a href="/building?id=${building.id}">
                <img src="/static/resource/buildings/${building.name}.png" height="${building.height}px" width="${building.width}px" />
            </a>
        </div>
    </c:forEach>

</div>
</body>
</html>
