<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        width: 800px;
        position: absolute;
        top: 40%;
        left: 30%;
        margin: -100px 100px 100px -100px;
        float: left;
        min-height: 100%;
        backdrop-filter: blur(4px);
        background: rgba(255,255,255,0.4);
        border-style: double;
        padding: 5px;
        border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;
        cursor: default;
        font-family: Monotype Corsiva, Chiller, cursive;
    }
    .comment{
        text-align: left;
        backdrop-filter: blur(8px);
        border: 3px #c7959e solid;
        margin: 15px;
        padding: 3px;
        border-radius: 10px;
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
    <h1>${book.name}</h1>
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
    <div>
        <form method="get" enctype="multipart/form-data" action="/book/${book.id}/read">
            <button type="submit" class="button" style="height: 70px; width: 150px">
                <img src="../../resources/static/read.jpg" alt=" " style="vertical-align: middle; height: 45px; width: 45px "><spring:message code="label.read"/></button>
        </form>
    </div>
       <h2> <spring:message code="label.publishingHouse"/> ${book.publishingHouse}</h2>
       <h2> Серия: <a href="/bookSeries/${bookSeries.id}">${bookSeries.name}</a></h2>
       <h2> <spring:message code="label.publishingDate"/>${book.publishingDate}</h2>
       <h2> <spring:message code="label.description"/>${book.description}</h2>
       <h2> <spring:message code="label.authorsList"/></h2>
    <c:forEach var="author" items="${book.authors}">
        <h3><spring:message code="label.fullname"/><a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h3><spring:message code="label.dateBirth"/>${author.dateBirth}</h3>
    </c:forEach>
    <div><h3><spring:message code="label.rateBook"/></h3>
        <form method="get" enctype="multipart/form-data" action="/book/${book.id}/chooseMark">
            <select id="dropDown" name="mark" size="1">
                <c:forEach begin="1" end="5" varStatus="num">
                    <option>${num.index} </option>
                </c:forEach>

            </select>
            <button type="submit" class="button"><spring:message code="label.rate"/></button>
        </form>
    </div>
    <div><h1><spring:message code="label.avg"/></h1>
        <form method="get" enctype="multipart/form-data" action="/book/${book.id}">
            <h1>${avg}</h1>
        </form>
    </div>
    <h3><spring:message code="label.comments"/></h3>
        <c:forEach var="comment" items="${comments}">
    <div class="comment">
        <h2>${user.username} : </h2><h3>${comment.text}</h3>
    </div>
        </c:forEach>
    <div>
        <form method="get" enctype="multipart/form-data" action="/book/${book.id}/addComment">
            <input type="text" class="form-control" name="text" placeholder="<spring:message code="label.addComment"/>" style="width: 600px; height: 45px"/>
            <button type="submit" class="button"><spring:message code="label.write"/><img src="../../resources/static/pero.png" alt=" " style="vertical-align: middle; height: 28px; width: 28px "></button>
        </form>
    </div>
</div>
</body>
</html>