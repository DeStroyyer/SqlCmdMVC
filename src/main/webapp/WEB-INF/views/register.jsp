<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 3/27/2017
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form method="Post" action="/register">

    <label for="name">Login:</label>
    <input id="name" name="name" type="text" size="25" maxlength="30" value=""/> <br/>

    <label for="email">Email:</label>
    <input id="email" name="email" type="email" size="25" maxlength="30" value=""/> <br/>

    <label for="pass">Password:</label>
    <input id="pass" name="pass" type="password" size="25" maxlength="30" value=""/> <br/>

    <input type="submit" value="submit"/>
</form>

</body>
</html>
