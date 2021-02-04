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
    body {

        background: url("static/books2.jpg") repeat-y,
        /*#fc0*/ url("static/books2.jpg") repeat-y 100% 0;
        /*background-color: #CC99FF*/;
    }
    header {
        background: url("static/books2.jpg") repeat-y,
        /*#fc0*/ url("static/books2.jpg") repeat-y 100% 0;
    }
</style>

<body>
<%--<div><img src="static/books2.jpg"/></div>--%>
<div class="header"><h1>Библиотека</h1></div>

<div>
    <form method="GET" action="/author/search">
        <div>
            <input type="hidden" name="_csrf" value="_csrf.token">
            <input name="lname" type="text" placeholder="lname" autofocus="true"/>
            <button type="submit">найти автора</button>
        </div>
    </form>
</div>

<div>
    <form method="GET" action="/book/search">
        <div>
            <input type="hidden" name="_csrf" value="_csrf.token">
            <input name="name" type="text" placeholder="name" autofocus="true"/>
            <button type="submit">найти книгу</button>
        </div>
    </form>
</div>

<h2>Список жанров: </h2>
<c:forEach var="genre" items="${genres}">
    <h3><a href="/genre/${genre.id}">${genre.name}</a></h3>
</c:forEach>

<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="_csrf.token">
    <input type="submit" value="Sign Out"/>
</form>

<%--<form action="/user" method="post">
    <input type="hidden" name="_csrf" value="_csrf.token">
    <input type="submit" value="Личный кабинет"/>
</form>--%>

<%--<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Book
</a>--%>
Add new Book
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Введите название" />
            </div>
            <%--<div class="form-group">
                <input type="text" class="form-control" name="genre" placeholder="жанр">
            </div>--%>
            <div class="form-group">
                <input type="text" class="form-control" name="lname" placeholder="фамилию автора" />
            </div>
            <input type="hidden" name="_csrf" value="_csrf.token" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>

    <a href="login.jsp">Авторизация</a>
    <a href="registration.jsp">Регистрация</a>
    <a href="/user">Личный кабинет</a>
<%--<c:if test="user.role=USER">
<a href="userCabinet.jsp">Личный кабинет</a>
</c:if>
<c:if test="user.role=ADMIN">
    <a href="adminCabinet.jsp">Личный кабинет</a>
</c:if>--%><%--это работоспособно?--%>
<%--Сделать дополнительную страницу с результатами поиска
для авторов с одинаковыми фамилиями и книг с одинаковыми названиями--%>

</body>
</html>