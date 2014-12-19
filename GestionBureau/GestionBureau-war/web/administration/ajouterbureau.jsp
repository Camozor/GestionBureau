<%-- 
    Document   : bureau
    Created on : 26 nov. 2014, 16:17:22
    Author     : 11316834
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout de bureau</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="content" >
            <h1>Ajouter un bureau :</h1>
            
            
            <j:if test="${succes == 1}" >
                <p>Bureau ajouté !</p>
            </j:if>


            <j:if test="${erreur.length() > 0}" >
                <p><strong>Erreur : </strong>${erreur}</p>
            </j:if>

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
        </div>
        <%@include file="../globalincludes/footer.html" %>
    </body>
</html>
