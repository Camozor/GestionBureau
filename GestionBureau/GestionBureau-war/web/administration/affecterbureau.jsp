<%-- 
    Document   : affecterbureau
    Created on : 2 déc. 2014, 14:57:28
    Author     : 10900286
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Changer de bureau</title>
        <style type="text/css" ><%@include file="../css/design.css" %></style>
    </head>
    <body>
       <%
            String userName = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("login")) 
                        userName = cookie.getValue();
                }
            }
            if(userName == null){
                response.sendRedirect("AdminLogin");
                return;
            }
        %>
        <h2>Gestion Bureau Admin</h2>
        <%@include file="menu.html" %>
        <h1>Affecter un bureau :</h1>
        <img src="img/bubu.jpg" alt="Bruno le bureau" title="Bruno le bureau" />
        <br />
        
        <h3>${p.prenom} ${p.nom}</h3>
        <p>
            <span>Actuellement dans le  bureau : ${p.bureauId.getJoliNom()}</span> <br />
            <span>Equipe : ${p.equipe}</span>
        </p>
        
   
        <j:if test="${bureau_change} = 1" >
            <p>Changement effectué !</p>
        </j:if>

        
        <j:if test="${erreur.length() > 0}" >
            <p><strong>Erreur : </strong>${erreur}</p>
        </j:if>
        
            
        <form action="AffecterBureau" method="POST" >
            
            Liste des bureaux proches de ceux des équipiers : <br />
            
            <j:forEach items="${mapProches}" var="b" >
                <j:set value="${b.key}" var="bu" />
                <j:set value="${b.value}" var="nb" /> 
                
                <j:set var="checked" value="" />
                <j:if test="${p.bureauId.bureauId == bu.bureauId}" >
                    <j:set var="checked" value=" checked " />
                </j:if>
    
                <span class="bureau" ></span>
                <input type="radio" ${checked} name="bu-id-selected" value="${bu.bureauId}" 
                       id="id-radio-bu-${bu.bureauId}" />
                <label for="id-radio-bu-${bu.bureauId}" >${bu.getSuccintJoliNom()} : ${nb} / ${bu.getNbMaxPersonne()}</label>
                <br />
                
            </j:forEach>
                
                <input type="hidden" name="idpersonne" value="${p.personneId}" />
                
            Autres bureaux : <br />
            
            <j:forEach items="${mapAutres}" var="b" >
                <j:set value="${b.key}" var="bu" />
                <j:set value="${b.value}" var="nb" /> 
                
                <j:set var="checked" value="" />  
                <j:if test="${p.bureauId.bureauId == bu.bureauId}" >
                    <j:set var="checked" value=" checked " />
                </j:if>
    
                <span class="bureau" ></span>
                <input type="radio" ${checked} name="bu-id-selected" value="${bu.bureauId}" 
                       id="id-radio-bu-${bu.bureauId}" />
                <label for="id-radio-bu-${bu.bureauId}" >${bu.getSuccintJoliNom()} : ${nb} / ${bu.getNbMaxPersonne()}</label>
                <br />
                
                
            </j:forEach>
                
            <j:set var="checked" value="" />  
            <j:if test="${p.bureauId == null}" >
                <j:set var="checked" value=" checked " />
            </j:if>
            <span class="bureau" ></span>
            <input type="radio" ${checked} name="bu-id-selected" value="null" 
                       id="id-radio-bu-null" />
            <label for="id-radio-bu-null" >Sans Bureau Fixe</label>
            <br />
              
            <input type="submit" value="Changer" />
        </form>
    </body>
</html>