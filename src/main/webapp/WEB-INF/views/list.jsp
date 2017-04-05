<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/index.css" />">

</head>
<body>
<div id="container">
    <div id="header">Forum
        <div id="auth"><a href="login">Login</a><a href="register">Register</a></div>
        <p>Hello ${name}</p>
    </div>
    <div id="sidebar">
        <p><a href="index">Main</a></p>
        <ul>
            <li><a href="menu/list">Show users</a></li>
            <li><a href="menu/adduser">Add user</a> </li>
            <li><a href="menu/help">Help</a></li>
        </ul>
    </div>
    <div id="content">
        <table id="list">
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th colspan="2">Functions</th>
            </tr>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><c:out value="${user.getId()}"/></td>
                    <td><c:out value="${user.getName()}"/></td>
                    <td><c:out value="${user.getEmail()}"/></td>
                    <td><c:out value="${user.getPassword()}"/></td>
                    <td><a href="/edit/${user.getId()}/${user.getName()}">Edit</a></td>
                    <td><a href="/menu/list/delete/${user.getId()}/${user.getName()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="footer">&copy; Ростислав</div>
</div>

</body>
</html>
