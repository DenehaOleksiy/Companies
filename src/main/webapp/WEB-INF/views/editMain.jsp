<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 18.09.2016
  Time: 0:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">
</head>
<body>

<form:form action="/edit/main" method="post" >
    <input name="id" type="hidden" value="${edit.id}">
    <input name="name" type="text" placeholder="name">
    <input name="annual_earnings" type="number" placeholder="annual_earnings" >
    <button type="submit">Edit</button>
</form:form>
</body>
</html>
