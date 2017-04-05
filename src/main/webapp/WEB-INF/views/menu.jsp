<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/index.css"/>">
</head>
<body>
<div id="container">
    <div id="header">Forum
        <div id="auth"><a href="login">Login</a><a href="register">Register</a></div>
       <p>Hello ${name}</p>
    </div>
    <div id="sidebar">
        <ul>
            <li><a href="menu/list">Show users</a></li>
            <li><a href="menu/adduser">Add user</a> </li>
            <li><a href="menu/help">Help</a></li>
        </ul>
    </div>
    <div id="content">
       <h1>Content</h1>
    </div>
    <div id="footer">&copy; Ростислав</div>
</div>
</body>
</html>
