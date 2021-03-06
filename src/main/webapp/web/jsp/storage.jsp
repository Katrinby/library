<%@ page import="com.company.libraryFinal.entity.YesNoEnum" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница книги</title>
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
        font-size: 20px;
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
    <h1>${storage.name}</h1>
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
    <h3> <spring:message code="label.bookInfo"/> </h3>
    <h3> <spring:message code="label.publishingDate"/> ${storage.yearOfPublishing}</h3>
    <h3> <spring:message code="label.description"/> ${storage.description}</h3>
    <h3> <spring:message code="label.genre"/>  ${storage.genre}</h3>
    <h3> <spring:message code="label.currentStatus"/>${storage.status} </h3>


    <div>
        <form method="get" enctype="multipart/form-data" action="/storage/${storage.id}/read">
            <button type="submit" class="button" style="height: 70px; width: 150px">
                <img src="../../resources/static/read.jpg" alt=" " style="vertical-align: middle; height: 45px; width: 45px "><spring:message code="label.read"/></button>
        </form>
    </div>


    <sec:authorize access="hasRole('ROLE_ADMIN')">
    <form method="get" enctype="multipart/form-data" action="/storage/${storage.id}/edit">
        <select id="dropDown" name="answer" size="1">
                <option>true</option>
                <option>false</option>
        </select>
        <button type="submit" class="button"><spring:message code="label.send"/></button>
    </form>
    </sec:authorize>
</div>
</body>
</html>