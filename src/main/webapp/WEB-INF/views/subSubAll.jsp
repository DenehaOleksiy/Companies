<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 16.09.2016
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">

</head>
<body>

<c:forEach items="${subSubAll}" var="a">
<div class="page">
    <p style="text-align: center; font-diameter: 14pt;">${a.name}</p>
    <p style="text-align: center; font-diameter: 14pt;">${a.annual_earnings}</p>

    <p><a  href="/subSub/edit/${a.id}">Edit SubSub Company</a></p>
    <p><a  href="/subSub/delete/${a.id}">Delete SubSub Company</a></p>
</div>
</c:forEach>

<p><a class="home" href="/">Home</a></p>
</body>
</html>
