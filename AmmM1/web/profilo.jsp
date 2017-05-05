<%-- 
    Document   : profilo
    Created on : 3-mag-2017, 18.30.43
    Author     : Fabrizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Fabrizio">
        <meta name="keywords" content="profilo">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
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
        <div class="immagineProfilo">
            <img title="Foto Profilo" alt="Foto Del Profilo" src="profilo.jpg">
        </div>
        <div id="idBody">
                   
            <form action="#" method="POST">
                <div id="datiAnagrafici">
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" value="Inserisci nome">
                <label for="cognome">Cognome</label>
                <input type="text" name="cognome" id="cognome" value="Inserisci cognome">
                 <label for="data">Data di nascita</label>
                <input type="date" name="data" id="data">
                <label for="immagineProfilo">Immagine del profilo</label>
                <input type="text" name="immagineProfilo" id="immagineProfilo" value="Inserisici Url">
                <label for="frase">Frase di presentazione</label>
                <input type="text" name="frase" id="frase" value="Inserisci frase">
                <label for="password">Password</label>
                <input type="text" name="password" id="password" value="Inserisci password">
                <label for="conferma">Conferma password</label>
                <input type="text" name="conferma" id="conferma" value="Conferma password">
                <button type="submit">Aggiorna</button>
                </div>
            </form>
        </div>
    </body>
</html>
