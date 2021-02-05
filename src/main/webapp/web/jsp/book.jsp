<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
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
<div class="header"><h1>${book.name}</h1></div>
<div>
       <h2> Издательство: ${book.publishingHouse}</h2>
       <h2> Дата публикации: ${book.publishingDate}</h2>
       <h2> Описание книги: ${book.description}</h2>
       <h3>Автор(ы) книги:</h3>
    <c:forEach var="author" items="${book.authors}">
        <h4>Имя: <a href="/author/${author.id}">${author.fname} ${author.lname}</a></h4>
        <h4>Дата рождения: ${author.dateBirth}</h4>
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>