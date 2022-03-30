<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<c:forEach var = "abc" items ="${condiment}">
    <p>${abc}</p>
</c:forEach>
</body>
</html>
