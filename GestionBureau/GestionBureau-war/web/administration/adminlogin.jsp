<%-- 
    Document   : adminlogin
    Created on : 19 déc. 2014, 01:46:41
    Author     : Camille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" ><%@include file="../css/design.css" %></style>
        <title>Connexion administration</title>
    </head>
    <body>
        <%@include file="includes/titleSite.html" %>
        
        <h1>Authentification</h1>
        
        <j:if test="${erreur.length() > 0}" >
            <p><strong>Erreur : </strong>${erreur}</p>
        </j:if>
        
        <form action="AdminLogin" method="POST" >
            <label for="login" >Identifiant :</label>
            <input type="text" name="login" id="login" /> <br />
            
            <label for="password" >Mot de passe :</label>
            <input type="password" name="password" id="password" /> <br />
            
            <input type="submit" value="Log in!" />
        </form>
    </body>
</html>
