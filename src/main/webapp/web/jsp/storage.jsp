<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
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
<div class="header"><h1>${storage.name}</h1></div>
<div>
   <h3>Информация о рассматриваемой книге: </h3>
    <h3> Дата публикации: ${storage.publishingDate}</h3>
    <h3> Текущий статус: ${storage.status}</h3>
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>