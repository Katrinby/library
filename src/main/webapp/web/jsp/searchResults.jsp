<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница результатов поиска</title>
</head>
<style>
    body {
        background-image: url('../../resources/static/book.jpg');
    }
    .header{
        backdrop-filter: blur(4px);
        background: rgba(255,255,255,0.4);
        border-style: double;
        padding: 5px;
        margin: 10px;
        border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;

        font-family: Monotype Corsiva, Chiller, cursive;
        font-style: italic;
        text-align: center;
        cursor: default;
        font-size: 20px;
    }
    .content{
        width: 32%;
        float: left;
        min-height: 100%;
        backdrop-filter: blur(4px);
        background: rgba(255,255,255,0.4);
        border-style: double;
        padding: 5px;
        margin: 10px;
        border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;
        cursor: default;
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    .button{
        text-align: center;
        float: right;
        border: 3px #c7959e solid;
        margin: 15px;
        padding: 3px;
        border-radius: 10px;
        cursor: pointer;
        background: #f5e1ce;
        font-size: 20px;
        font-family: Monotype Corsiva, Chiller, cursive;}
    .button:hover{
        border: 3px #cf6b7e solid;
        background: #f5e1ce;
    }
    input[type=text] {
        padding:10px;
        margin: 10px;
        border:0;
        width:200px;
        border-radius:10px;
        cursor: text;
        font-size: 20px;
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    a:link {
        color: darkcyan;
        font-size: 20px;
        text-decoration: none;
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    a:visited {
        color: darkslategrey;
        text-decoration: none;
    }
    a:hover {
        color: darkslategrey;
        text-decoration: none;
    }
    a:active {
        color: darkslategrey;
        text-decoration: none;
    }
</style>
<body>
<div class="header">
    <h1>Результаты поиска</h1>
    <div class="button">
        <a href="/main">Главная</a>
    </div>
</div>
<div class="content">
<div class="book">
    <c:forEach var="book" items="${books}">

        <h3> Название книги:<a href="/book/${book.id}">${book.name}</a></h3>
        <h4> Издательство: ${book.publishingHouse}</h4>
        <h4>Дата публикации: ${book.publishingDate}</h4>
        <h4>Описание: ${book.description}</h4>
        <h3>Автор(ы) книги:</h3>
    <c:forEach var="author" items="${book.authors}">
        <h3><a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h4> Информация об авторе: ${author.dateBirth}</h4>
    </c:forEach>
    </c:forEach>
</div>
<div class="author">
    <c:forEach var="author" items="${authors}">
        <h3>Имя Автора: <a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h4>Дата рождения: ${author.dateBirth}</h4>
        <h3>Книги автора: </h3>
    <c:forEach var="book" items="${author.books}">
        <h3>Название: <a href="/book/${book.id}">${book.name}</a></h3>
        <h4>Издательство: ${book.publishingHouse}</h4>
        <h4>Дата публикации: ${book.publishingDate}</h4>
        <h4>Описание: ${book.description}</h4>
    </c:forEach>
    </c:forEach>
</div>
</div>
</body>
</html>