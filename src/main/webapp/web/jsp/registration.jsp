<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registration</title>
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
    .content {
        font-size: 20px;
        float: left;
        min-height: 35%;

        backdrop-filter: blur(4px);
        background: rgba(255, 255, 255, 0.4);
        border-style: double;
        padding: 5px;

        border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;
        cursor: default;
        font-family: Monotype Corsiva, Chiller, cursive;

        width: 250px;
        height: 150px;

        position: absolute;
        top: 10%;
        left: 50%;
        margin: -125px 0 0 -125px;
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
    input[type=password] {
        padding:10px;
        margin: 10px;
        border:0;
        width:200px;
        border-radius:10px;
        cursor: text;
        font-size: 20px;
        font-family: Monotype Corsiva, Chiller, cursive;
    }

    .center{

        width: 100%;
        height: 200%;
        position: absolute;
        top: 175px;
        left: 0;
        overflow: auto;
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
</style>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<div class="header">
    <h1><spring:message code="label.registration"/></h1>
    <div>
        <form action="/main" method="get" >
            <button type="submit" class="button"><spring:message code="label.main"/></button>
        </form>
    </div>
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
</div>
<div class="center">
<div class="content">
<form action="/registration" method="post">
    <div><label> <spring:message code="label.login"/> <input type="text" name="username"/> </label></div>
    <div><label> <spring:message code="label.password"/> <input type="password" name="password"/> </label></div>
    <div><label> <spring:message code="label.lastname"/><input type="text" name="lname"/> </label></div>
    <div><label> <spring:message code="label.name"/> <input type="text" name="fname"/> </label></div>
    <div><label> <spring:message code="label.dateBirth"/> <input type="date" name="dateBirth"/> </label></div>
    <button type="submit" class="button"><spring:message code="label.register"/></button>
</form>
</div>
</div>
</body>
</html>