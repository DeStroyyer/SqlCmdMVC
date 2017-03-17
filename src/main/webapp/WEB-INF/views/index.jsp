<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<li><a href="connect">Connect</a></li>
<li><a href="help">Help</a></li>
<c:forEach items="${commands}" var="item">
    ${item}<br>
</c:forEach>
</ul>
</body>
</html>
