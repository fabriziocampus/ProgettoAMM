<%-- 
    Document   : descrizione
    Created on : 27-apr-2017, 11.21.25
    Author     : Fabrizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Informazioni sul sito</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Fabrizio">
        <meta name="keywords" content="info informazioni descrizione">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <header>
            <c:set var="title" value="" scope="request"/>
           <jsp:include page="header.jsp"/>

                <c:set var="page" value="Descrizione" scope="request"/>
                <jsp:include page="DesNav.jsp"/>
        </header>
     
        
        <div id="idBodyinf">
            <a id="info">
            <h2>Descrizione</h2>
            </a>
            <p> Questo social network è indirizzato alle persone che desiderano fare nuove amicizie, e si vuole discutere
                soppratutto di informatica e tecnologie legate ad essa.
                Per iscriversi basta compilare un semplice form di iscrizione inserendo dei dati personali.
            </p>
        </div>
        <div id="infoo">
            <h2>Il social, è a pagamento?</h2>
            <p>
                No, il social è totalmente gratuito, per consentire a chiunque di potersi iscrivere.
                Per utilizzarlo basta una semplice connessione ad internet. Dopodiche ci si può divertire e iniziare a 
                stringere nuove amicizie.<br /> 
            </p>
        </div>
        <div id="regolamento">
                 <a id="regole">
                    <h3>Fondamentale rispettare alcune regole:</h3>
                </a>
            <ol>
                <li>Non importunare gli altri utenti</li>
                <li>Non scrivere post offensivi o razzisti</li>
                <li>Rispettare gli altri utenti</li>
                <li>Durante l'iscrizione utilizzare dati veri</li>
            </ol>
            <p>
                Se non vengono rispettate queste regole, l'utente potrebbe essere bloccato o cancellato definitivamente dal social. 
            </p>
                <a href="#info">Descrizione</a>
                <a href="#regole">Regole</a>
            
        </div>
    </body>
</html>
