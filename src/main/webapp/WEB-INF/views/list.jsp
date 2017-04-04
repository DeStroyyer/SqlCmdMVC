<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/list.css" />">

</head>
<body>
<table>
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
        <td><a href="/menu/list/edit/${user.getId()}/${user.getName()}">Edit</a></td>
        <td><a href="'/menu/list/delete/'+{user.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
</body>
</html>
