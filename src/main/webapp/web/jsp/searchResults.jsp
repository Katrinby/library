<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница результатов поиска</title>
</head>
<style>
    .header {
        font-style: italic;
        background: lightpink;
        text-align: center;
        border-style: double;
        padding: 7px;
        border-width: 5px;
        border-color: darkolivegreen;
    }
</style>
<body>
<div class="header"><h1>Результаты поиска</h1></div>
<div>
    <c:forEach var="book" items="${books}">

        <h3> Название книги:${book.name}</h3>
        <h4> Издательство: ${book.publishingHouse}</h4>
        <h4>Дата публикации: ${book.publishingDate}</h4>
        <h4>Описание: ${book.description}</h4>
        <h3>Автор(ы) книги:</h3>
    <c:forEach var="author" items="${book.authors}">
        <%--<h3><a href="/author?lname=${author.lname}">${author.lname}</a></h3>--%>
        <h3><a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h4> Информация об авторе: ${author.dateBirth}</h4>
    </c:forEach>
    </c:forEach>
</div>

<div>
    <c:forEach var="author" items="${authors}">
        <h3>Имя Автора: ${author.lname} ${author.fname}</h3>
        <h4>Дата рождения: ${author.dateBirth}</h4>
        <h3>Книги автора: </h3>
    <c:forEach var="book" items="${author.books}">
        <h3>Название: <a href="/book/${book.id}">${book.name}</a></h3>
        <h4>Издательство: ${book.publishingHouse}</h4>
        <h4>Дата публикации: ${book.publishingDate}</h4>
        <h4>Описание: ${book.description}</h4>
    </c:forEach>
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>