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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ajouter un bureau :</h1>
        
        <form action="AdminGestionBureau" method="POST" >
            <label for="batiment" >Bâtiment :</label>
            <input type="text" name="batiment" id="batiment" /> <br />
            
            <label for="batiment" >Numéro :</label>
            <input type="text" name="numero" id="numero" /> <br />
            
            <label for="etage" >Etage :</label>
            <input type="text" name="etage" id="etage" /> <br />
            
            <input type="submit" value="Créer !" />
        </form>
    </body>
</html>
