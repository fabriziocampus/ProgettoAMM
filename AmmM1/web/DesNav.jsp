<%-- 
    Document   : nav
    Created on : 26-apr-2017, 16.06.18
    Author     : Fabrizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="navBar">
    <ul>
        <li <c:if test="${page=='Descrizione'}"class="active"></c:if><a href="descrizione.jsp">Descrizione</a></li>
        <li <c:if test="${page=='Login'}"></c:if><a href="Login">Login</a></li>
        
    </ul>
</nav>
