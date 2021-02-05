<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--Как передавать данные пользователя в виде параметров на страницы кабинетов? --%>
<%--Кнопки добавления книг, авторов и жанров для админа--%>
<%--Кнопки оформить как кнопки, а не как ссылки--%>
<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
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
<style>
    .body {

        background: url("static/books2.jpg") repeat-y,
        /*#fc0*/ url("static/books2.jpg") repeat-y 100% 0;
        /*background-color: #CC99FF*/;
    }
    .header {
        font-style: italic;
        background: lightpink;
        text-align: center;
        border-style: double;
        padding: 7px;
        border-width: 5px;
        border-color: darkolivegreen;
    }

    .content {
        display: flex;
        justify-content: space-between;

    }
    .hrefs{
        display: flex;
        justify-content: space-between;
        margin: 10%;
        border-style: none;
        padding: 10px;
    }
    .logout{
        text-align: right;
        border-style: none;
        margin: 5%;
        padding: 5px;
    }
    .author{
        width: 32%;
        float: left;
        min-height: 100%;
        background: pink;
        border-style: double;
        padding: 5px;
        border-width: 5px;
        border-color: darkolivegreen;
    }
    .book{
        width: 32%;
        min-height: 100%;
        float: left;
        background: pink;
        border-style: double;
        padding: 5px;
        border-width: 5px;
        border-color: darkolivegreen;
    }
    .genre{
        width: 32%;
        min-height: 100%;
        float: left;
        background: pink;
        border-style: double;
        padding: 5px;
        border-width: 5px;
        border-color: darkolivegreen;
    }
</style>

<body>

<div class="header"><h1>Библиотека</h1></div>

<div class="content">
    <div class="author">
        <h3>Найти автора: </h3>
    <form method="GET" action="/author/search">
        <div>
            <input type="hidden" name="_csrf" value="_csrf.token">
            <input name="lname" type="text" placeholder="lname" autofocus="true"/>
            <button type="submit">найти</button>
        </div>
    </form>
        <div>
            <h3>Добавить нового автора</h3>
            <form method="post" enctype="multipart/form-data" action="/main/addAuthor">
                <div class="form-group">
                    <input type="text" class="form-control" name="fname" placeholder="Введите имя" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="lname" placeholder="Введите фамилию" />
                </div>
                <input type="hidden" name="_csrf" value="_csrf.token" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>

    <div class="book">
        <h3>Найти книгу: </h3>
    <form method="GET" action="/book/search">
        <div>
            <input type="hidden" name="_csrf" value="_csrf.token">
            <input name="name" type="text" placeholder="name" autofocus="true"/>
            <button type="submit">найти</button>
        </div>
    </form>
        <h3>Добавить новую книгу</h3>
    <form method="post" enctype="multipart/form-data" action="/main/addBook">
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Введите название книги" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="lname" placeholder="Введите фамилию автора" />
        </div>
        <input type="hidden" name="_csrf" value="_csrf.token" />
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Добавить</button>
        </div>
    </form>
    </div>

    <div class="genre">
        <h3>Список жанров: </h3>
        <c:forEach var="genre" items="${genres}">
            <h3><a href="/genre/${genre.id}">${genre.name}</a></h3>
        </c:forEach>
        <h3>Добавить новый жанр</h3>
        <form method="post" enctype="multipart/form-data" action="/main/addGenre">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Введите название" />
            </div>
            <input type="hidden" name="_csrf" value="_csrf.token" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>

</div>

<div class="hrefs">
    <a href="/login">Авторизация</a>
    <a href="/registration">Регистрация</a>
    <a href="/user">Личный кабинет</a>
</div>

<div class="logout">
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="_csrf.token">
        <input type="submit" value="Sign Out"/>
    </form>
</div>

</body>
</html>