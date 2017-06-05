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
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/filter.js"></script>
        <title>Bacheca</title>
    </head>
    
    <body>
        
        <header>
        <c:set var="title" value="" scope="request"/>
        <jsp:include page="header.jsp"/>

         <c:set var="page" value="Bacheca" scope="request"/>
         <jsp:include page="BacNav.jsp"/>
         
         <c:if test="${empty param.user}">
                    <a id="logout" href="Login?logout=1">Logout</a>   
        </c:if>
        
       </header>
       
         <div id="colonna">
                <input id="searchField" type="text" placeholder="search" value="">
                <button id="search">Cerca</button>
              <c:forEach var="utente" items="${utente}">
                    <img alt="Foto Profilo" src="${utente.urlimg}">
                    <h2>${utente.nome}</h2>
                    <a href="index.html?user=${utente.id}">Link al profilo</a>
                </c:forEach>
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
                      <c:choose>
                          <c:when test="${empty newpost}">
                            <form action="NuovoPost" method="post">
                                <img title="allegato" alt="allegato" src="allegato.png"><textarea name="textPost" id="textPost"></textarea><br />
                                 <input type="radio" name="postType" id="textType" value="textType" checked="checked">Testo
                                 <input type="radio" name="postType" id="imgType" value="imgType">Immagine
                                 <input type="radio" name="postType" id="linkType" value="linkType">Link<br />
                                 <button type="submit" name="thereIsPost" value="needConfirm">Crea Post</button>
                            </form>
                        </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <c:if test="${typePost == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                            <c:if test="${typePost == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                             <c:if test="${typePost == 'linkType'}">
                                 <a href="${content}">${content}</a>
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
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
                            <a href="${post.contenuto}">${post.contenuto}</a>
                        </c:if>
                    </div>
            </c:forEach>
        </div>
    </body>
</html>
