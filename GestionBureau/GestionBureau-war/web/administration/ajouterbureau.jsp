<%-- 
    Document   : bureau
    Created on : 26 nov. 2014, 16:17:22
    Author     : 11316834
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout de bureau</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <h2>Gestion Bureau Administration</h2>
        <%@include file="menu.html" %>
        <h1>Ajouter un bureau :</h1>
        
        <form action="AjouterBureau" method="POST" >
            <label for="batiment" >Bâtiment (A ou B) :</label>
            <input type="text" name="batiment" id="batiment" /> <br />
            
            <label for="batiment" >Numéro ([0-9]{3}) :</label>
            <input type="text" name="numero" id="numero" /> <br />
            
            <label for="etage" >Etage (1, 2 ou 3) : </label>
            <input type="text" name="etage" id="etage" /> <br />
            
            <label for="nb_personnes" >Nombre de personnes : </label>
            <input type="text" name="nb_personnes" id="nb_personnes" /> <br />
            
            <input type="submit" value="Créer !" />
        </form>
    </body>
</html>
