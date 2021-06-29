<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Wystąpił nieoczekiwany problem!<br/>
                Prosimy przesłać formularz <br/>
                jeszcze raz.<br/>
                <br/><a href="<c:url value="/registration"/> " class="btn btn--without-border">Prześlij ponownie</a>
            </h1>
        </div>
    </div>
</header>
</body>
</html>
