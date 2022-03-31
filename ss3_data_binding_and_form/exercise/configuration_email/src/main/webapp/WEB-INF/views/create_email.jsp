<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/31/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="email" type="java"--%>
<form:form method="post" action="create" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="languages">Languages : </form:label></td>
            <form:select path="languages" items="${languageList}">
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><form:select path="pageSize" items="${pageSizeList}">
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="spamFilter">Spam Filter: </form:label></td>
            <td><form:checkbox path="spamFilter"/>Enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:input path="signature" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
