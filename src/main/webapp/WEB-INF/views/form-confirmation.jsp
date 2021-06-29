<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
  </head>
  <body>
    <header class="header--form-page">
      <nav class="container container--70">
        <ul class="nav--actions">
          <li class="logged-user">
            Witaj Agata
            <ul class="dropdown">
              <li><a href="#">Profil</a></li>
              <li><a href="#">Moje zbiórki</a></li>
              <li><a href="#">Wyloguj</a></li>
            </ul>
          </li>
        </ul>
        <%@include file="jspf/header.jsp"%>
      </nav>

      <div class="slogan container container--90">
        <h2>
          Dziękujemy za przesłanie formularza. <br/>
          Na maila prześlemy wszelkie
          informacje.<br/>
          <br/>DZIĘKUJEMY! <br/>
          <br/><a href="<c:url value="/" />" class="btn btn--without-border">Strona główna</a><br/>
        </h2>
      </div>
    </header>
  <%@include file="jspf/footer.jsp"%>
  </body>
</html>
