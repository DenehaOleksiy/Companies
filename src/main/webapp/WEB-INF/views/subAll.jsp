<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 16.09.2016
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">

</head>
<body>

<c:forEach items="${subAll}" var="a">
<div class="page">
    <p style="text-align: center; font-diameter: 14pt;">${a.name}</p>
    <p style="text-align: center; font-diameter: 14pt;">${a.annual_earnings}</p>

    <p><a  href="/sub/edit/${a.id}">Edit Sub Company</a></p>
    <p><a  href="/sub/delete/${a.id}">Delete Sub Company</a></p>
    <p><a  href="/sub/earn/${a.id}">Sub Company earn</a></p>
    <p><a  href="/sub/total/${a.id}">Company + sub earn</a></p>
</div>
</c:forEach>

<p><a class="home" href="/">Home</a></p>
</body>
</html>
