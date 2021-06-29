<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="#">Zaloguj</a></li>
            <li class="highlighted"><a href="<c:url value="/user/create"/> ">Załóż konto</a></li>
        </ul>
        <%@include file="jspf/header.jsp" %>
    </nav>
</header>

    <section class="login-page">
        <form:form method="post" modelAttribute="user">
        <h2>Załóż konto</h2>
            <div class="form-group">
                <form:input type="text" path="userName" placeholder="Imię"/>
            </div>
            <div class="form-group">
                <form:input type="text" path="userLastName" placeholder="Nazwisko"/>
            </div>
            <div class="form-group">
                <form:input type="text" path="email" placeholder="Email"/>
            </div>
            <div class="form-group">
                <form:input type="password" path="password" placeholder="Hasło"/>
            </div>
            <div class="form-group">
                <form:input type="password" path="passwordConfirm" placeholder="Powtórz hasło"/>
            </div>

            <div class="form-group form-group--buttons">
                <a href="login.jsp" class="btn btn--without-border">Zaloguj się</a>
                <button class="btn" type="submit">Załóż konto</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </form:form>
    </section>
<%@include file="jspf/footer.jsp" %>
</body>
</html>
