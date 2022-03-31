<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<table border="1">
    <tr>
        <td>No</td>
        <td>Id</td>
        <td>Languages</td>
        <td>Page Size</td>
        <td>Spam Filter</td>
        <td>Signature</td>
    </tr>
    <c:forEach var="emailObj" items="${emailList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${emailObj.id}</td>
            <td>${emailObj.languages}</td>
            <td>${emailObj.pageSize}</td>

            <c:if test="${emailObj.spamFilter == true}">
                <td>Enable spam filter</td>
            </c:if>
            <c:if test="${emailObj.spamFilter == false}">
                <td></td>
            </c:if>


            <td>${emailObj.signature}</td>
            <td>
                <a href="/create">Create Configuration Email</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
