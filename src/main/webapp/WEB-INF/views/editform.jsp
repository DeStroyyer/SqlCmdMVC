<%--
  Created by IntelliJ IDEA.
  User: Rostyslav
  Date: 4/4/2017
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit ${name}</title>
</head>
<body>
<form method="Post" action="/menu/list/edit/${id}">

    <label for="name">Login:</label>
    <input id="name" name="name" type="text" size="25" maxlength="30" value=""/> <br/>

    <label for="email">Email:</label>
    <input id="email" name="email" type="email" size="25" maxlength="30" value=""/> <br/>

    <label for="password">Password:</label>
    <input id="password" name="password" type="password" size="25" maxlength="30" value=""/> <br/>

    <input type="submit" value="submit"/>
</form>

</body>
</html>
