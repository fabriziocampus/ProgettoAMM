<%-- 
    Document   : nav
    Created on : 26-apr-2017, 16.06.18
    Author     : Fabrizio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav id="navBar">
    <ul>
        <li <c:if test="${page=='Bacheca'}" class="active"></c:if><a href="Bacheca">Bacheca</a></li>
        <li <c:if test="${page=='Profilo'}"class="active"></c:if><a href="Profilo">Profilo</a></li>
    </ul>
</nav>
