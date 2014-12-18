<%-- 
    Document   : envoyermessage
    Created on : 2 déc. 2014, 18:11:12
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
        <title>Envoi d'un message</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <h2>Gestion Bureau</h2>
        <%@include file="menu.html" %>
        <h1>Veuillez choisir votre nom</h1>
        
        ${msg_envoye == 1 ? "<p>Message envoyé !</p>" : ""}
       
        <form action="EnvoyerMessageAdmin" method="POST">
            <select name="p">
                <jstl:forEach items="${lpersonnes}" var="p" >
                    <option value="${p.personneId}">
                       ${p.prenom} ${p.nom}
                    </option>                      
                </jstl:forEach>
            </select> <br />
            <textarea name="message" ></textarea> <br />
            <input type="submit" value="Envoyer !" />
        </form>
    </body>
</html>
