<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница жанра</title>
</head>

<body>
<div>
    ${genre.name}
    <c:forEach var="book" items="${genre.books}">
        <h3><a href="/book/${book.id}">${book.name}</a></h3>
        ${book.publishingHouse}
        ${book.publishingDate}
        ${book.description}
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>