<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/29/2022
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>

<form method="get" action="/translate">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
</form>
<h2>Result search : ${result}</h2>
</body>
</html>
