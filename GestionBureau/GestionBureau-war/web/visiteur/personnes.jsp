<%-- 
    Document   : personnes
    Created on : 2 déc. 2014, 13:15:52
    Author     : 10900286
--%>
<%@page import="java.util.List"%>
<%@page import="EntityGestion.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des personnes</title>
        <style type="text/css" ><%@include file="design.css" %></style>
    </head>
    <body>
        <h2>Gestion Bureau</h2>
        <%@include file="menu.html" %>
        <h1>Liste des personnes</h1>
        <ul>
            <jstl:forEach items="${lpersonnes}" var="p" >
                <li>
                    ${p.prenom} ${p.nom} :
                    <a href="AffecterBureau?idpersonne=${p.personneId}" >Affecter Bureau</a>
                </li>
            </jstl:forEach>
        </ul>
    </body>
</html>
