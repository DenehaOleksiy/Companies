<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 15.09.2016
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/style.css">

</head>
<body>
<div class="form">
<form:form action="/add/Main" method="post" modelAttribute="new">
    <form:label path="name">Enter Company name</form:label>
    <form:input path="name"/>
    <form:label path="annual_earnings">Enter Company annual_earnings</form:label>
    <form:input path="annual_earnings"/>
    <form:button  value="submit">Add</form:button>
</form:form>
</div>
</body>
</html>
