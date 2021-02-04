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

<body>
<div>
    <div>
        <%--${user.name}--%>
        <h2>Список книг на рассмотрении: </h2>
        <c:forEach var="storage" items="${storages}">
            <h3><a href="/storage/${storage.id}">${storage.name}</a></h3>
        </c:forEach>
        <h3><a href="/main">Главная</a></h3>
    </div>
</div>
</body>
</html>