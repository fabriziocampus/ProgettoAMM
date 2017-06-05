<%-- 
    Document   : listaUtentijson
    Created on : 3-giu-2017, 15.02.38
    Author     : Fabrizio
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="utente" items="${listaUtenti}">
        <json:object>
            <json:property name="nome" value="${utente.nome}"/>
            <json:property name="cognome" value="${utente.cognome}"/>
            <json:property name="data" value="${utente.data}"/>
            <json:property name="frase" value="${utente.frase}"/>
            <json:property name="urlimg" value="${utente.urlimg}"/>
            <json:property name="id" value="${utente.id}"/>
            <json:property name="email" value="${utente.email}"/>
            <json:property name="password" value="${utente.password}"/>
            <json:property name="urlFotoProfilo" value="${utente.urlFotoProfilo}"/>
        </json:object>
    </c:forEach>
</json:array>
