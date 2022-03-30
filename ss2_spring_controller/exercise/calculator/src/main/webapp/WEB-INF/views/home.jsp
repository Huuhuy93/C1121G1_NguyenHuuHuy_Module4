<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/30/2022
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/cal">
    <fieldset>
        <legend>Calculator</legend>
        <table>
            <tr>
                <td>First operand: </td>
                <td><input name="firstOperand" type="text"/></td>
            </tr>

            <tr>
                <td>Second operand: </td>
                <td><input name="secondOperand" type="text"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="operator" value="+"/>Addition</td>
                <td><input type="submit" name="operator" value="-"/>Subtraction</td>
                <td><input type="submit" name="operator" value="*"/>Multiplication</td>
                <td><input type="submit" name="operator" value="/"/>Division</td>
            </tr>
        </table>
    </fieldset>
</form>
<h3>Result Division : ${result}</h3>

</body>
</html>
