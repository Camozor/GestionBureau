<%-- 
    Document   : affecterbureau
    Created on : 2 déc. 2014, 14:57:28
    Author     : 10900286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ page isELIgnored="false" %>
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
        
        <h3>${p.prenom} ${p.nom}</h3>
        <p>
            <span>Actuellement dans le  bureau : ${p.bureauId.getJoliNom()}</span> <br />
            <span>Equipe : ${p.equipe}</span>
        </p>
        
   
        <jstl:if test="${bureau_change} = 1" >
            <p>Changement effectué !</p>
        </jstl:if>

        
        <jstl:if test="${erreur.length() > 0}" >
            <p><strong>Erreur : </strong>${erreur}</p>
        </jstl:if>
        
            
        <form action="AffecterBureau" method="POST" >
            
            Liste des bureaux proches : <br />
            
            <input type="radio" name="bu-id-selected" value="null" 
                       id="id-radio-bu-null" checked />
            <label for="id-radio-bu-null" >Sans Bureau Fixe</label>
            <br />
            
            <jstl:forEach items="${lbuproches}" var="bu" >
                
                <jstl:set var="checked" value="" />
                
                <jstl:if test="${p.bureauId.bureauId == bu.bureauId}" >
                    <jstl:set var="checked" value=" checked " />
                </jstl:if>
    
                <input type="radio" ${checked} name="bu-id-selected" value="${bu.bureauId}" 
                       id="id-radio-bu-${bu.bureauId}" />
                <label for="id-radio-bu-${bu.bureauId}" >${bu.batiment} ${bu.etage} ${bu.numero}</label>
                <br />
                
            </jstl:forEach>
                
                <input type="hidden" name="idpersonne" value="${p.personneId}" />
                
            Autres bureaux : <br />
            
            <jstl:forEach items="${lbuautres}" var="bu" >
                
                <jstl:set var="checked" value="" />
                
                <jstl:if test="${p.bureauId.bureauId == bu.bureauId}" >
                    <jstl:set var="checked" value=" checked " />
                </jstl:if>
    
                <input type="radio" ${checked} name="bu-id-selected" value="${bu.bureauId}" 
                       id="id-radio-bu-${bu.bureauId}" />
                <label for="id-radio-bu-${bu.bureauId}" >${bu.batiment} ${bu.etage} ${bu.numero}</label>
                <br />
                
                
            </jstl:forEach>
              
            <input type="submit" value="Changer" />
        </form>
    </body>
</html>