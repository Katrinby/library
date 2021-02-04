<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
</head>

<body>
<div>
    ${book.name}
    ${book.publishingHouse}
    ${book.publishingDate}
    ${book.description}
    <c:forEach var="author" items="${book.authors}">
        <%--<h3><a href="/author?lname=${author.lname}">${author.lname}</a></h3>--%>
        <h3><a href="/author/${author.id}">${author.lname}</a></h3>
        ${author.fname}
        ${author.dateBirth}
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>