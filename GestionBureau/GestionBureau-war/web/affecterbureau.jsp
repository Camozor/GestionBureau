<%-- 
    Document   : affecterbureau
    Created on : 2 déc. 2014, 14:57:28
    Author     : 10900286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Changer de bureau</title>
        <style type="text/css" ><%@include file="design.css" %></style>
    </head>
    <body>
        <%@include file="menu.html" %>
        <h1>Affecter un bureau :</h1>
        <img src="bubu.jpg" alt="Bruno le bureau" title="Bruno le bureau" />
        <br />
        
        ${p.nom}
        
        <form action="AffecterBureau" method="POST" >
            
            <input type="radio" name="bu-id-selected" value="null" 
                       id="id-radio-bu-null" />
            <label for="id-radio-bu-null" >Sans Bureau Fixe</label>
            <br />
            
            <jstl:forEach items="${lbu}" var="bu" >
                <jstl:if test="${p.bureauId} = ${bu.bureauId}" >COUCOU</jstl:if>
                <input type="radio" name="bu-id-selected" value="${bu.bureauId}" 
                       id="id-radio-bu-${bu.bureauId}" />
                <label for="id-radio-bu-${bu.bureauId}" >${bu.batiment} ${bu.etage} ${bu.numero}</label>
                <br />
                
            </jstl:forEach>
                
                <input type="hidden" name="idpersonne" value="${p.personneId}" />
            
              
            <input type="submit" value="Changer" />
        </form>
    </body>
</html>