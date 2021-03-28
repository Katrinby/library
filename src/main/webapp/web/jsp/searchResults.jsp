<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Страница результатов поиска</title>
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
    <h1><spring:message code="label.searchResults"/></h1>
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
<div class="book">

    <c:choose>
        <c:when test="${data.size() > 0 }">
            <c:forEach var="book" items="${data}">
                <div style="border-style: double none; border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;">
                    <h3> <spring:message code="label.bookName"/><a href="/book/${book.id}">${book.name}</a></h3>
                    <h4> <spring:message code="label.publishingHouse"/>${book.publishingHouse}</h4>
                    <h4> <spring:message code="label.publishingDate"/>${book.publishingDate}</h4>
                    <h4> <spring:message code="label.description"/>${book.description}</h4>
                </div>
            </c:forEach>
        </c:when>
    </c:choose>
    <c:if test="${data.size() > 0 }">
        <div class="panel-footer">
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages-1}" var="page">
                    <a href="/book/search?page=${page}&size=5" class="page-link">${page+1}</a>
                </c:forEach>
            </ul>
        </div>
    </c:if>


</div>

<div class="author">
    <c:choose>
    <c:when test="${adata.size() > 0 }">
    <c:forEach var="author" items="${adata}" >
        <div style="border-style: double none; border-width: 5px;
        border-color: darkcyan;
        border-radius: 10px;">
        <h3><spring:message code="label.fullname"/><a href="/author/${author.id}">${author.fname} ${author.lname}</a></h3>
        <h4><spring:message code="label.dateBirth"/>${author.dateBirth}</h4>
        </div>
    </c:forEach>
    </c:when>
    </c:choose>

    <c:if test="${adata.size() > 0 }">
        <div class="panel-footer">
            <ul class="pagination">
                <c:forEach begin="0" end="${atotalPages-1}" var="page">
                    <a href="/author/search?page=${page}&size=5" class="page-link">${page+1}</a>
                </c:forEach>
            </ul>
        </div>
    </c:if>

</div>
</div>
</body>
</html>