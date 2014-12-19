<%-- 
    Document   : listebureaux
    Created on : 18 déc. 2014, 18:14:38
    Author     : 10900286
--%>

<%@page import="java.util.Iterator"%>
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
        <%@include file="includes/header.jsp" %>
        
        <h1>Affectation du personnel</h1>
        <j:if test="${map.size() > 0}">
            <table>
                <caption>Bureaux</caption>
                <thead>
                    <tr>
                        <th>Bâtiment</th>
                        <th>Etage</th>
                        <th>Numéro</th>
                        <th>Nombre de personnes</th>
                    </tr>
                </thead>
                <tbody>
                    <j:forEach items="${map}" var="b" >

                        <j:set value="${b.key}" var="bu" />
                        <j:set value=" ${b.value} / ${b.key.getNbMaxPersonne()}" var="nbpersonne" />                                                
                        <tr>
                            <td>${bu.getBatiment()}</td>
                            <td>${bu.getEtage()}</td>
                            <td>${bu.getNumero()}</td>
                            <td>${nbpersonne}</td>
                        </tr>
                    </j:forEach>
                </tbody>
            </table>
        </j:if>
    </body>
</html>
