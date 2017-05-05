<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 15.54.56
    Author     : Fabrizio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="author" content="Fabrizio">
        <meta name="keywords" content="bacheca">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>Bacheca</title>
    </head>
    
    <body>
        
        <header>
        <c:set var="title" value="" scope="request"/>
        <jsp:include page="header.jsp"/>

         <c:set var="page" value="Bacheca" scope="request"/>
         <jsp:include page="BacNav.jsp"/>
        
       </header>
       
         <div id="colonna">
            <form action="#" method="POST">
                <label>Cerca</label>
                <input type="text" name="cerca" id="cerca" value="Cerca" />
                <button type="submit">Cerca</button>
            </form>
            <h2>Persone</h2>
            <img title="foto profilo" alt="Foto del profilo" src="prof.jpg"><a href="#">Ronaldinho</a>
            <img title="foto profilo" alt="Foto del profilo" src="prof.png"><a href="#">Schelotto</a>
            <img title="foto profilo" alt="Foto del profilo" src="prof.jpeg"><a href="#">Simone Padoin</a>
            <h2>Gruppi</h2>
            <img title="foto mongolfieristi" alt="Foto mongolfieristi" src="mon.jpg"><a href="#">Mongolfieristi</a>
            <img title="foto ritardatari" alt="Foto ritardatari" src="sv.jpg"><a href="#">Ritardatari</a>
         </div>
        <div id="idBody">
            <div id="nuovoPost">
                <form action="#" method="POST">
                    <img title="allegato" alt="allegato" src="allegato.png"><input type="text" name="nuovoPost" id="nuovo" value="Nuovo post"><br />
                    <img title="allegato" alt="allegato" src="allegato.png"><input type="text" name="allegato" id="allegato" value="Url Allegato(opzionale)"><br />
                    <input type="radio" name="scelta" id="img" value="immagine" checked="checked">Immagine
                    <input type="radio" name="scelta" id="link" value="link">Link<br />
                    <button type="submit">Crea Post</button>
                </form>
            </div>
            
            <c:forEach var="post" items="${posts}">
                    <div class="post">
                        <img alt="Foto del profilo" src="${post.user.urlimg}">
                        <h3>${post.user.nome} ${post.user.cognome}</h3><br />
                        <c:if test="${post.postType == 'TEXT'}">
                            ${post.contenuto}
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                        <div class="immagine">
                            <img alt="Post con foto" src="${post.contenuto}">
                        </div>
                        </c:if>
                        <c:if test="${post.postType == 'LINK'}">
                            <a href="${post.contenuto}">Sito unica</a>
                        </c:if>
                    </div>
            </c:forEach>
        </div>
    </body>
</html>
