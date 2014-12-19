<%-- 
    Document   : listebureaux
    Created on : 18 déc. 2014, 18:14:38
    Author     : 10900286
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des bureaux</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <h2>Gestion Bureau Visiteur</h2>
        
         <%@include file="menu.html" %>
        
        <h1>Affectation du personnel</h1>
        <j:if test="${lBureaux.size() > 0}">
            <table>
                <thead>
                    <tr>
                        <th>Bureau</th>
                        <th>Nombre de personnes</th>
                    </tr>
                </thead>
                <tbody>
                    <j:forEach items="${lBureaux}" var="b" >
                                        
                        <j:choose>
                            <j:when test="${b.getBureauId() != null}" >
                                <j:set value="${b.getSuccintJoliNom()}" var="bureau" />
                                <j:set value="${b.getNbMaxPersonne()} / " var="nbpersonne" />
                            </j:when>
                            <j:otherwise>
                                <j:set value="Aucun" var="bureau" />
                                <j:set value="0/0" var="nbpersonne" />
                            </j:otherwise>
                        </j:choose>
                                                    
                        <tr>
                            <td>${bureau}</td>
                            <td>${nbpersonne}</td>
                        </tr>
                    </j:forEach>
                </tbody>
            </table>
        </j:if>
    </body>
</html>
