<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/login.css" />">
    <title>Login</title>
</head>
<body>

<form method="Post" action="/menu">
    <div align="center">
        <table>
            <tr>
                <td><label for="name">Login:</label></td>
                <td><input id="name" name="name" type="text" size="25" maxlength="30" value=""/> <br/></td>
            </tr>
            <tr>
                <td><label for="pass">Password:</label></td>
                <td><input id="pass" name="pass" type="password" size="25" maxlength="30" value=""/> <br/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="submit"/></td>
            </tr>
        </table>
        <div style="color: red">${error}</div>
    </div>
</form>

</body>
</html>