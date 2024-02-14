
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Add book page:</h1>
    <sf:form method="post" action="/saveBook" modelAttribute="book">
        <sf:input type="hidden" path="library_id"/><br><br>
        Book title:<sf:input path="title"/><br><br>
        Pages:<sf:input path="pages"/><br><br>
        <input type="submit" value="Save book">
    </sf:form>
</body>
</html>
