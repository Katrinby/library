<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница результатов поиска</title>
</head>

<body>
<div>
    <c:forEach var="book" items="${books}">
    <p>Книга:</p>
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
    </c:forEach>
</div>

<div>
    <c:forEach var="author" items="${authors}">
        <p>Автор:</p>
    ${author.lname}
    ${author.fname}
    ${author.dateBirth}
    <c:forEach var="book" items="${author.books}">
        <h3><a href="/book/${book.id}">${book.name}</a></h3>
        ${book.publishingHouse}
        ${book.publishingDate}
        ${book.description}
    </c:forEach>
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>