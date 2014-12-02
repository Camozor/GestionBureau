<%-- 
    Document   : envoyermessage
    Created on : 2 déc. 2014, 18:11:12
    Author     : 10900286
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Envoi d'un message aux admins</title>
    </head>
    <body>
        <h1>Envoi d'un message aux admins</h1>
        <form action="EnvoyerMessageAdmin" method="POST">
            <label for="message">Texte : </label>
            <input type="text" name="message" id="message" />
        </form>
    </body>
</html>
