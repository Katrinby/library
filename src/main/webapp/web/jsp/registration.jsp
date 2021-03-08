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
    .content{
        /*width: 32%;*/
        font-size: 20px;
        float: left;
        min-height: 35%;
        backdrop-filter: blur(4px);
        background: rgba(255,255,255,0.4);
        border-style: double;
        padding: 5px;
        /*margin: 10px;*/
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
</style>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="internationalization.js"></script>
<div class="header">
    <h1><fmt:message key="label.registration"/></h1>
    <div>
        <form action="/main" method="get" >
            <button type="submit" class="button">Главная</button>
        </form>
    </div>
</div>
<div class="center">
<div class="content">
    
    
    <span><fmt:message key="label.lang.change"/></span>
    <select id="locales">
        <option><a href="?lang=en"><fmt:message key="label.lang.eng"/></a></option>
        <option><a href="?lang=ru"><fmt:message key="label.lang.ru"/></a></option>
    </select>

        <%--<span th:text="#{label.lang.change}"></span>:
        <select id="locales">
            <option value=""></option>
            <option value="en" th:text="#{label.lang.eng}"></option>
            <option value="fr" th:text="#{label.lang.ru}"></option>
        </select>--%>

    <%--<button type="submit" class="button">Выбрать</button>--%>
    
<form action="/registration" method="post">
    <div><label> Логин: <input type="text" name="username"/> </label></div>
    <div><label> Пароль: <input type="password" name="password"/> </label></div>
    <div><label> Имя : <input type="text" name="lname"/> </label></div>
    <div><label> Фамилия : <input type="text" name="fname"/> </label></div>
    <div><label> Дата рождения : <input type="text" name="dateBirth"/> </label></div>
    <button type="submit" class="button">Зарегистрироваться</button>
</form>
</div>
</div>
</body>
</html>