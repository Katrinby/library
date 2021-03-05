<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
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
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    a:visited {
        color: darkslategrey;
    }
    a:hover {
        color: darkslategrey;
    }
    a:active {
        color: darkslategrey;
    }
</style>
<body>
<div class="header">
    <h1>${book.name}</h1>
    <div>
        <form action="/main" method="get" >
            <button type="submit" class="button">Главная</button>
        </form>
    </div>
</div>
<div class="content">
       <h2> Издательство: ${book.publishingHouse}</h2>
       <h2> Серия: <a href="/bookSeries/${bookSeries.id}">${bookSeries.name}</a></h2>
       <h2> Дата публикации: ${book.publishingDate}</h2>
       <h2> Описание книги: ${book.description}</h2>
       <h2>Автор(ы) книги:</h2>
    <c:forEach var="author" items="${book.authors}">
        <h3>Имя: <a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h3>Дата рождения: ${author.dateBirth}</h3>
    </c:forEach>

</div>
<div>Оцените книгу:
<form method="get" enctype="multipart/form-data" action="/book/${book.id}/chooseMark">
<select id="dropDown" name="mark" size="1">
    <c:forEach begin="1" end="5" varStatus="num">
        <option>${num.index} </option>
    </c:forEach>
</select>
    <div class="form-group">
        <button type="submit" class="button">Оценить</button>
    </div>
</form>
</div>
<div>Средняя оценка:
    <form method="get" enctype="multipart/form-data" action="/book/${book.id}">
        ${avg}
    </form>
</div>
<div>Добавить комментарий
    <form method="get" enctype="multipart/form-data" action="/book/${book.id}/addComment">
        <div class="form-group">
            <input type="text" class="form-control" name="text" placeholder="Введите комментарий" />
        </div>
        <div class="form-group">
            <button type="submit" class="button">Добавить</button>
        </div>
    </form>
</div>
<div>Комментарии
    <c:forEach var="comment" items="${comments}">
        <h2>${comment.text}</h2>
        <h3>${user.username}</h3>
    </c:forEach>
</div>
<div>Читать
    <form method="get" enctype="multipart/form-data" action="/book/${book.id}/read">
        <div class="form-group">
            <button type="submit" class="button">Читать</button>
        </div>
    </form>
</div>
</body>
</html>