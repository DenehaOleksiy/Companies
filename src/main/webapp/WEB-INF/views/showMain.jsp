<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 15.09.2016
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">

</head>
<body>

<c:forEach items="${showAll}" var="a">
<div class="page">
    <p style="text-align: center; font-diameter: 14pt;">${a.name}</p>
    <p style="text-align: center; font-diameter: 14pt;">${a.annual_earnings}</p>
    <%--<p style="text-align: center; font-diameter: 14pt;">${a.totalSum}</p>--%>

    <p><a  href="/main/edit/${a.id}">Edit Main Company</a></p>
    <p><a  href="/main/delete/${a.id}">Delete Main Company</a></p>
    <p><a  href="/main/earn/${a.id}">Main Company earn</a></p>
    <p><a  href="/main/total/${a.id}">Company + sub earn</a></p>
</div>
</c:forEach>

<p><a class="home" href="/">Home</a></p>
</body>
</html>
