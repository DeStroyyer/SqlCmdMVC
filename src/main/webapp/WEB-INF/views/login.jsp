<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form method="Post" action="/login">

    <label for="name">Login:</label>
    <input id="name" name="name" type="text" size="25" maxlength="30" value=""/> <br/>

    <label for="pass">Password:</label>
    <input id="pass" name="pass" type="password" size="25" maxlength="30" value=""/> <br/>

    <input type="submit" value="submit"/>
</form>
</body>
</html>