<%-- 
    Document   : listepersonnes
    Created on : 18 déc. 2014, 17:31:07
    Author     : 10900286
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" ><%@include file="../css/design.css" %></style>
        <title>Liste des personnes</title>
    </head>
    <body>
        <h2>Gestion Bureau Visiteur</h2>
        <%@include file="menu.html" %>
        
        <h1>Affectation du personnel</h1>
        <j:if test="${lpersonnes.size() > 0}">
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Mail</th>
                        <th>Equipe</th>
                        <th>Date Début</th>
                        <th>Date Fin</th>
                        <th>Bureau</th>
                    </tr>
                </thead>
                <tbody>
                    <j:forEach items="${lpersonnes}" var="p" >
                        
                        <j:choose>
                            <j:when test="${p.getBureauId() != null}" >
                                <j:set value="${p.getBureauId().getSuccintJoliNom()}" var="bureau" />
                            </j:when>
                            <j:otherwise>
                                <j:set value="Aucun" var="bureau" />
                            </j:otherwise>
                        </j:choose>
                            
                        <j:choose>
                            <j:when test="${p.getDateFin() != null}" >
                                <j:set value="${calendar.getDate(p.getDateFin())}" var="dateFin" />
                            </j:when>
                            <j:otherwise>
                                <j:set value="Aucune" var="dateFin" />
                            </j:otherwise>
                        </j:choose>
                            
                        <tr>
                            <td>${p.getPrenom()}</td>
                            <td>${p.getNom()}</td>
                            <td>${p.getMail()}</td>
                            <td>${p.getEquipe()}</td>
                            <td>${calendar.getDate(p.getDateDebut())}</td>
                            <td>${dateFin}</td>
                            <td>${bureau}</td>
                        </tr>
                    </j:forEach>
                </tbody>
            </table>
        </j:if>
    </body>
</html>
