<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<form name="connect" method="post" action="MainController">
    Driver:<br/>
    <input name="driver" type="checkbox" name="H2" value="org.h2.Driver" />
    <input name="driver" type="checkbox" name="PostGres" value="PostGres" />
    <input name="driver" type="checkbox" name="MySql" value="MySql" />

    Login: <br/>
    <input name="name" type="text" size="25" maxlength="30" value=""/> <br/>

    Password:<br/>
    <input name="pass" type="password" size="25" maxlength="30" value=""/> <br/>

    <input type="submit" name="enter" value="connect"/>
</form>
</body>
</html>