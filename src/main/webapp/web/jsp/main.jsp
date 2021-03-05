<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--Как передавать данные пользователя в виде параметров на страницы кабинетов? --%>
<%--Кнопки добавления книг, авторов и жанров для админа--%>
<%--Кнопки оформить как кнопки, а не как ссылки--%>
<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
</head>
<style>

    body {
        background-image: url('../../resources/static/book.jpg');
    }
    .header {
        display: flex;
        justify-content: space-between;
        backdrop-filter: blur(4px);
        background: rgba(255,255,255,0.4);
        border-style: double;
        padding: 5px;
        margin: 10px;
        border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;
    }
    h1{
        width: 70%;
        float: left;
        min-height: 100%;
        font-family: Monotype Corsiva, Chiller, cursive;
        font-style: italic;
        text-align: center;
        cursor: default;
        font-size: 35px;
    }
    .content {
        display: flex;
        justify-content: space-between;
    }
    .hrefs{
        text-align: center;
        float: right;
        justify-content: space-between;
        width: 20%;
        min-height: 100%;
        cursor: default;
        font-family: Monotype Corsiva, Chiller, cursive;}
    .button{
        width: 200px;
        height: 35px;
        border: 3px #c7959e solid;
        margin: 15px;
        padding: 3px;
        border-radius: 10px;
        cursor: pointer;
        background: #f5e1ce;
        font-size: 20px;
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    .button:hover{
        border: 3px #cf6b7e solid;
        background: #f5e1ce;
    }
    .author{
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
    .book{
        width: 32%;
        min-height: 100%;
        float: left;
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
    .genre{
        width: 32%;
        min-height: 100%;
        float: left;
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
    h3{
        font-size: 20px;
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
    <h1>Библиотека</h1>
    <div class="hrefs">

        <div>
            <form action="/login" method="get" >
                <button type="submit" class="button">Авторизация</button>
            </form>
        </div>

        <div>
            <form action="/registration" method="get" >
                <button type="submit" class="button">Регистрация</button>
            </form>
        </div>
        <sec:authorize access="hasRole('ROLE_USER')">
        <div>
            <form action="/user" method="get" >
                <button type="submit" class="button">кабинет пользователя</button>
            </form>
        </div>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div>
            <form action="/admin" method="get" >
                <button type="submit" class="button">кабинет админа</button>
            </form>
        </div>
        </sec:authorize>
        <div>
            <form action="/logout" method="post" >
                <button type="submit" class="button">Sign Out</button>
            </form>
        </div>
    </div>
</div>

<div class="content">
    <div class="author">
        <h3>Найти автора: </h3>
    <form method="GET" action="/author/search">
        <div>
            <input name="lname" type="text" placeholder="lname" autofocus="true"/>
            <button type="submit" class="button">найти</button>
        </div>
    </form>
        <div>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
            <h3>Добавить нового автора</h3>
            <form method="post" enctype="multipart/form-data" action="/main/addAuthor">
                <div class="form-group">
                    <input type="text" class="form-control" name="fname" placeholder="Введите имя" />
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="lname" placeholder="Введите фамилию" />
                </div>
                <div class="form-group">
                    <button type="submit" class="button">Добавить</button>
                </div>
            </form>
            </sec:authorize>
        </div>
    </div>

    <div class="book">
        <h3>Найти книгу: </h3>
    <form method="GET" action="/book/search">
        <div>
            <input name="name" type="text" placeholder="name" autofocus="true"/>
            <button type="submit" class="button">найти</button>
        </div>
    </form>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h3>Добавить новую книгу</h3>
    <form method="post" enctype="multipart/form-data" action="/main/addBook">

        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Введите название книги" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="lname" placeholder="Введите фамилию автора" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="publishingHouse" placeholder="publishingHouse" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="publishingDate" placeholder="publishingDate" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="description" placeholder="description" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="bookSeriesName" placeholder="bookSeriesName" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="genre" placeholder="genre" />
        </div>

        <div class="form-group">
            <button type="submit" class="button">Добавить</button>
        </div>
    </form>
        </sec:authorize>
    </div>


    <div class="genre">
        <h3>Список жанров: </h3>
        <c:forEach var="genre" items="${genres}">
            <h3><a href="/genre/${genre.id}">${genre.name}</a></h3>
        </c:forEach>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <h3>Добавить новый жанр</h3>
        <form method="post" enctype="multipart/form-data" action="/main/addGenre">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Введите название" />
            </div>
            <div class="form-group">
                <button type="submit" class="button">Добавить</button>
            </div>
        </form>

        </sec:authorize>
    </div>

</div>

</body>
</html>