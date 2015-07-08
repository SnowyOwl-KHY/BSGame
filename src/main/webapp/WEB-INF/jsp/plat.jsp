<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kehanyang
  Date: 15/7/9
  Time: 上午12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地图</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<div>

    <img src="/static/resource/plat/plat-board.png" width="1000px" height="750px"/>

    <div style="position: absolute; top: 198px; left: 130px">
        <a href="/westPlat?username=${username}&x=${centerX}&y=${centerY}&userX=${userX}&userY=${userY}">
            <img src="/static/resource/plat/west.png" width="100px"/>
        </a>
    </div>

    <div style="position: absolute; top: 198px; left: 760px">
        <a href="/northPlat?username=${username}&x=${centerX}&y=${centerY}&userX=${userX}&userY=${userY}">
            <img src="/static/resource/plat/north.png" width="100px"/>
        </a>
    </div>

    <div style="position: absolute; top: 518px; left: 130px">
        <a href="/southPlat?username=${username}&x=${centerX}&y=${centerY}&userX=${userX}&userY=${userY}">
            <img src="/static/resource/plat/south.png" width="100px"/>
        </a>
    </div>

    <div style="position: absolute; top: 518px; left: 760px">
        <a href="/eastPlat?username=${username}&x=${centerX}&y=${centerY}&userX=${userX}&userY=${userY}">
            <img src="/static/resource/plat/east.png" width="100px"/>
        </a>
    </div>

    <c:forEach items="${siteList}" var="site">
        <div style="position: absolute; top: ${site.top}px; left: ${site.left}px;">
            <a href="/site?username=${username}&x=${site.x}&y=${site.y}">
                <img src="/static/resource/plat/${site.siteType}.png" height="80px" width="160px"/>
            </a>
        </div>
    </c:forEach>

    <div style="position: absolute; top: 580px; left: 150px">
        <p style="color: white;" align="center">当前坐标</p>
        <p style="color: white;" align="center">x: ${centerX}</p>
        <p style="color: white;" align="center">y: ${centerY}</p>
    </div>

    <div style="position: absolute; top: 580px; left: 250px">
        <p style="color: white;" align="center">您的位置</p>
        <p style="color: white;" align="center">x: ${userX}</p>
        <p style="color: white;" align="center">y: ${userY}</p>
    </div>

    <div style="position: absolute; top: 680px; left: 860px">
        <a href="/home?username=${username}">
            <img src="/static/resource/plat/back.png" width="100px" height="34px"/>
        </a>
    </div>

</div>
</body>
</html>
