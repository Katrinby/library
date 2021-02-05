<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница автора</title>
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
<div class="header"><h1>${author.lname} ${author.fname}</h1></div>
<div>

    <h2>Дата рождения: ${author.dateBirth}</h2>
                <h3>Перечень книг автора: </h3>
                <c:forEach var="book" items="${author.books}">
                    <h4>Название: <a href="/book/${book.id}">${book.name}</a></h4>
                    <h4>Издательство: ${book.publishingHouse}</h4>
                    <h4>Дата публикации: ${book.publishingDate}</h4>
                    <h4>Описание: ${book.description}</h4>
                </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>