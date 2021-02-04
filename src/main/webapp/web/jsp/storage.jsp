<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
</head>

<body>
<div>
    ${storage.name}
    ${storage.publishingDate}
    ${storage.status}
    <h3><a href="/main">Главная</a></h3>
</div>
</body>
</html>