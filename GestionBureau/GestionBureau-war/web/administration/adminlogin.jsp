<%-- 
    Document   : adminlogin
    Created on : 19 déc. 2014, 01:46:41
    Author     : Camille
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style type="text/css" ><%@include file="../css/design.css" %></style>
        <title>Connexion administration</title>
    </head>
    <body>
        <h2>Gestion Bureau Admin</h2>
        <form action="AdminLogin" method="POST" >
            <label for="login" >Identifiant :</label>
            <input type="text" name="login" id="login" /> <br />
            
            <label for="password" >Mot de passe :</label>
            <input type="password" name="password" id="password" /> <br />
            
            <input type="submit" value="Log in!" />
        </form>
    </body>
</html>
