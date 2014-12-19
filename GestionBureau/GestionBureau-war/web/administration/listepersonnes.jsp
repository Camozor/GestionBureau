<%-- 
    Document   : personnes
    Created on : 2 déc. 2014, 13:15:52
    Author     : 10900286
--%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.List"%>
<%@page import="EntityGestion.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des personnes</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        
        <h1>Liste des personnes</h1>
 

                        
        <j:if test="${lpersonnes.size() > 0}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Mail</th>
                        <th>Equipe</th>
                        <th>Date Début</th>
                        <th>Date Fin</th>
                        <th>Bureau</th>
                        <th>Actions</th>
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
                                <j:set value="${helpD.getJoliDate(p.getDateFin())}" var="dateFin" />
                                <j:set value="${helpD.obsolete(p.getDateFin())}" var="isObso" />
                                
                                <j:choose>
                                    <j:when test="${isObso == true}" >
                                        <j:set value="obsolete" var="obsolete" />
                                    </j:when>
                                    
                                    <j:otherwise>
                                        <j:set value="" var="obsolete" />
                                    </j:otherwise>
                                </j:choose>
                            </j:when>
                            
                            <j:otherwise>
                                <j:set value="Aucune" var="dateFin" />
                                <j:set value="" var="obsolete" />
                            </j:otherwise>
                        </j:choose>
                            
                        <tr>
                            <td> ${p.getPrenom()}</td>
                            <td>${p.getNom()}</td>
                            <td>${p.getMail()}</td>
                            <td>${p.getEquipe()}</td>
                            <td>${helpD.getJoliDate(p.getDateDebut())}</td>
                            <td class="${obsolete}" >${dateFin}</td>
                            <td class="${obsolete}" >${bureau}</td>
                            <td>
                                <j:choose>
                                    <j:when test="${isObso == true}" >
                                        <span>-</span>
                                    </j:when>
                                    <j:otherwise>
                                        <a href="AffecterBureau?idpersonne=${p.personneId}" >Affecter Bureau</a>
                                    </j:otherwise>
                                </j:choose>
                            </td>
                        </tr>
                    </j:forEach>
                </tbody>
            </table>
        </j:if>
    </body>
</html>
