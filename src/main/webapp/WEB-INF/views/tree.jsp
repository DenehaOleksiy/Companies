<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 19.09.2016
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">
</head>
<body>
<div class="tree">
    <h1>Tree of companies</h1>
<div class="clear">
    <h2>Main companies</h2>
    <c:forEach items="${main}" var="a">
    <div class="treeMain">
        <p>Company name: ${a.name}</p>
        <p>Annual earnings: ${a.annual_earnings}</p>
    </div>
    </c:forEach>
</div>

    <div class="clear">
        <h2>Sub companies</h2>
    <c:forEach items="${sub}" var="a">
    <div class="treeSub">
        <p>Company name: ${a.name}</p>
        <p>Annual earnings: ${a.annual_earnings}</p>
    </div>
    </c:forEach>
    </div>

    <div class="clear">
        <h2>SubSub companies</h2>
    <c:forEach items="${subSub}" var="a">
    <div class="treeSubSub">
        <p>Company name: ${a.name}</p>
        <p>Annual earnings: ${a.annual_earnings}</p>
    </div>
        </c:forEach>
    </div>
    <p><a class="home1" href="/">Home</a></p>
</div>
</body>
</html>
