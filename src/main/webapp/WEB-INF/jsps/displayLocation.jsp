

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Locations</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h3>Locations</h3>
<table>
    <tr>
        <th>id</th>
        <th>code</th>
        <th>name</th>
        <th>type</th>
    </tr>
    <c:forEach items="${locationList}" var="location">
        <tr>
            <td>${location.id}</td>
            <td>${location.code}</td>
            <td>${location.name}</td>
            <td>${location.type}</td>
            <%--id is passed as a parameter and access in the controller using @RequestParam--%>
            <td><a href="deleteLoc?id=${location.id}">Delete</a> </td>
            <td><a href="showUpdateLoc?id=${location.id}">Edit</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="showCreate">Add location</a>
</body>
</html>