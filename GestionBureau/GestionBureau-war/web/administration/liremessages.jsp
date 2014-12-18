<%-- 
    Document   : liremessages
    Created on : 18 déc. 2014, 14:23:05
    Author     : 11316834
--%>

<%@page import="java.util.GregorianCalendar"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <h2>Gestion Bureau Administration</h2>
        <%@include file="menu.html" %>
        <h1>Lire les messages</h1>
        <j:if test="${lMessages.size() > 0}" >
            <ul class="mail-list" >
                <j:forEach items="${lMessages}" var="m" >
                    <j:set value="${m.getPersonneId()}" var="p" />
                    <li>
                        <strong>${p.getPrenom()} ${p.getNom()} : ${m.getDateMessage()}</strong>
                        <p>${m.getTexte()}</p>
                    </li>
                </j:forEach>
            </ul>
        </j:if>
    </body>
</html>
