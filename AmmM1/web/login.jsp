<%-- 
    Document   : login
    Created on : 4-mag-2017, 8.24.03
    Author     : Fabrizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
         <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Fabrizio">
        <meta name="keywords" content="login registrazione">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header>
            <c:set var="title" value="" scope="request"/>
            <jsp:include page="header.jsp"/>
            
            <c:set var="page" value="" scope="request"/>
            <jsp:include page="DesNav.jsp"/>
            
        </header>
        
        <h1 id="testo"><img title="nerdbook" alt="nerdbook" src="nerd.jpg">Login</h1>
        <div class="accesso">
             <c:if test="${invalidData == true}">
                 <div id="invalidDataWarning"><h3>I dati inseriti non sono corretti. Riprova!</h3></div>
            </c:if>
            <form action="Login" method="POST">
                <div id="post">
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username"/>
                    <label for="password">Password</label>
                    <input type="text" name="password" id="password" />
                    </div>
                    <button type="submit">Invio</button>  
            </form>
        </div>
    </body>
</html>
