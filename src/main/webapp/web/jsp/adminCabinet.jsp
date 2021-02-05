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
<div class="header"><h1>Личный кабинет</h1></div>
+информация о пользователе из User_info(после решения проблем с логином)
+кнопка edit возле названия для изменения статуса

<div>
    <%--${user.name}--%>
    <h2>Список книг на рассмотрении: </h2>
    <c:forEach var="storage" items="${storages}">
        <h3><a href="/admin/storage/${storage.id}">${storage.name}</a></h3>
    </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>