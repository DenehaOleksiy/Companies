<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 16.09.2016
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/add/subSub" method="post" >
    <select name="subCompanies">
        <c:forEach items="${sub}" var="a">
            <option value="${a.id}" />Sub Company: ${a.name}
        </c:forEach>
    </select>
    <input name="name" type="text" placeholder="add name subSub">
    <input name="annual_earnings" type="number" placeholder="add annual_earnings">
    <button type="submit">Add subSubCompany</button>

</form>
</body>
</html>
