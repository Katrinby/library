<%--икформация о пользователе,
 список книг из хранилища с возможностью изменения статуса
 (да-удаляет книгу из хранилища, добавляет в книги и добавляет пользователя в авторы)--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница админа</title>
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
    <h1>Личный кабинет</h1>
    <div class="button">
        <a href="/main">Главная</a>
    </div>
</div>
+информация о пользователе из User_info(после решения проблем с логином)
+кнопка edit возле названия для изменения статуса

<div class="content">
    <%--${user.name}--%>
    <h2>Список книг на рассмотрении: </h2>
    <c:forEach var="storage" items="${storages}">
        <h3><a href="/admin/storage/${storage.id}">${storage.name}</a></h3>
    </c:forEach>
</div>
</body>
</html>