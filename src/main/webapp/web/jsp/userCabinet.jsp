<%--добавить книгу,
икформация о пользователе(с кнопкой изменить),
список книг пользователя--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница пользователя</title>
</head>

<body>
<div>
    <%--${user.name}--%>
        <h2>Список книг на рассмотрении: </h2>
        <c:forEach var="storage" items="${storages}">
            <h3><a href="/user/storage/${storage.id}">${storage.name}</a></h3>
        </c:forEach>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>