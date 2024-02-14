<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Libraries</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1 class="red">Libraries:</h1>
    <h1>Libraries:</h1>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
        <c:forEach var="library" items="${libraries}">
            <tr>
                <td>${library.name}</td>
                <td>${library.address}</td>
                <td>
                    <a href="/view/${library.id}"> view </a>
                    <a href="/delete/${library.id}"> delete</a>
                    <a href="/update/${library.id}">update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/add">Add New Library</a>
    </p>
</body>
</html>
