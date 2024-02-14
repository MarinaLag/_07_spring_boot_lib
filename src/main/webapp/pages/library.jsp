
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Library</h1>
    <h2>${library.name}</h2>
    <h3>${library.address}</h3>
    <h2>Books:</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Pages</th>
            <th>Action</th>
        </tr>
        <c:forEach var="book" items="${library.books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.pages}</td>
                <td>
                    <a href="/deleteBook/${library.id}/${book.id}">Delete Book</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/addBook/${library.id}">Add New Book</a>
    </p>
</body>
</html>
