                                                                                                                                                                                                                                                                                                                                                                                                            <%-- 
    Document   : personne
    Created on : 27 nov. 2014, 16:51:38
    Author     : 11316834
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout de personne</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
        <%@include file="includes/header.jsp" %>
        <div class="content" >
            <h1>Ajouter une personne :</h1>

            <j:if test="${succes == 1}" >
                <p>Personne ajoutée !</p>
            </j:if>


            <j:if test="${erreur.length() > 0}" >
                <p><strong>Erreur : </strong>${erreur}</p>
            </j:if>
            
            
            <form action="AjouterPersonne" method="POST" >
                <label for="nom" >Nom :</label>
                <input type="text" name="nom" id="nom" /> <br />

                <label for="prenom" >Prénom :</label>
                <input type="text" name="prenom" id="prenom" /> <br />

                <label for="mail" >Mail :</label>
                <input type="text" name="mail" id="mail" /> <br />

                <label for="equipe" >Equipe :</label>
                <input type="text" name="equipe" id="equipe" /> <br />

                <label for="date_debut" >Date de début (AAAA-MM-JJ) :</label>
                <input type="date" name="date_debut" id="date_debut" /> <br />

                <label for="date_fin" >Date de fin (AAAA-MM-JJ) (optionnel) :</label>
                <input type="date" name="date_fin" id="date_fin" /> <br />

                <input type="submit" value="Créer !" />
            </form>
        </div>
        <%@include file="../globalincludes/footer.html" %>
    </body>
</html>
