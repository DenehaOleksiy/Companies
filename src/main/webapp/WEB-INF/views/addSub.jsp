<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 16.09.2016
  Time: 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/add/sub" method="post" >
    <select name="mainCompany">
    <c:forEach items="${main}" var="a">
        <option value="${a.id}" />Main Company: ${a.name}
    </c:forEach>
        </select>
    <input name="name" type="text" placeholder="add name sub">
    <input name="annual_earnings" type="number" placeholder="add annual_earnings">
    <button type="submit">Add subCompany</button>

</form>
</body>
</html>
