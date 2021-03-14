<%--добавить книгу,
икформация о пользователе(с кнопкой изменить),
список книг пользователя--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница пользователя</title>
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
    input[type=date] {
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
    <h1>Личный кабинет пользователя ${user.username}</h1>
    <div class="dropdown">
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="?lang=en">
                <img src="../../resources/static/en.png" alt="en" style="top: 0px;
                 right: 0px; position: absolute; vertical-align: middle; height: 45px;
                 width: 45px; border: double; border-radius: 30px "></a>
            <a class="dropdown-item" href="?lang=ru">
                <img src="../../resources/static/ru.png" alt="ru" style="top: 0px;
                right: 50px; position: absolute; vertical-align: middle; height: 45px;
                 width: 45px; border: double; border-radius: 30px "></a>
        </div>
    </div>
    <div>
        <form action="/main" method="get" >
            <button type="submit" class="button"><spring:message code="label.main"/></button>
        </form>
    </div>
</div>
<div class="content">
        <h1> Информация о пользователе: </h1>
        <h2><spring:message code="label.dateBirth"/>${user.userInfo.dateBirth}</h2>
        <h2><spring:message code="label.name"/>${user.userInfo.fname}</h2>
        <h2><spring:message code="label.lastname"/>${user.userInfo.lname}</h2>
        <h2>Список книг на рассмотрении: </h2>
        <c:forEach var="storage" items="${storages}">
            <h3> <a href="/user/storage/${storage.id}">${storage.name}</a></h3>
        </c:forEach>

    <h3>Добавить новую книгу</h3>
    <form method="post" enctype="multipart/form-data" action="/user/addStorage">

        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Введите название книги" />
        </div>
        <div class="form-group">
            <input type="date" class="form-control" name="publishingDate" placeholder="publishingDate" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="description" placeholder="description" />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="genre" placeholder="genre" />
        </div>
        <div class="form-group">
            <button type="submit" class="button">Добавить</button>
        </div>
    </form>
</div>


</body>
</html>