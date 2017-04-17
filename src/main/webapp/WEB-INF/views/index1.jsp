<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>

</head>
<body>
<div id="header">
    <div id="autorization">
        <a href="#">Login</a>
        <a href="#">Registration</a>
    </div>
</div>
<div id="sidebar">
    <ul>
        <li>1</li>
        <li>2</li>
        <li>3</li>
        <li>4</li>
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
    <button id="add">Add User</button>

    <form id="addform" method="Post" style="display: none">

        <label for="name">Name:</label>
        <input id="name" name="name" type="text" size="25" maxlength="30" value=""/> <br/>

        <label for="email">Email:</label>
        <input id="email" name="email" type="email" size="25" maxlength="30" value=""/> <br/>

        <label for="password">Password:</label>
        <input id="password" name="password" type="password" size="25" maxlength="30" value=""/> <br/>

        <input type="submit" value="submit"/>
    </form>
</div>
<div id="bottom"></div>
</body>
</html>
