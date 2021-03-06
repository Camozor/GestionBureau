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
        <title>Lecture des messages</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="content" >
            <h1>Lire les messages</h1>
            <j:if test="${lMessages.size() > 0}" >
                <ul class="mail-list" >
                    <j:forEach items="${lMessages}" var="m" >
                        <j:set value="${m.getPersonneId()}" var="p" />
                        <li>
                            <strong>
                                <span>${p.getPrenom()}</span> 
                                <span>${p.getNom()} : </span>
                                <span>${calendar.getJoliDate(m.getDateMessage())}</span>
                            </strong>
                            <p>${m.getTexte()}</p>
                        </li>
                    </j:forEach>
                </ul>
            </j:if> 
        </div>
        <%@include file="../globalincludes/footer.html" %>
    </body>
</html>
