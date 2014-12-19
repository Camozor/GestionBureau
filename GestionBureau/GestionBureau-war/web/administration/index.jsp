<%-- 
    Document   : index
    Created on : 18 déc. 2014, 14:48:39
    Author     : 11316834
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            if(userName == null) response.sendRedirect("administration/adminlogin.jsp");
        %>
        <h1>Gestion Bureau Administration</h1>
        <%@include file="menu.html" %>
        <h2>Bienvenue Administrateur !</h2>
    </body>
</html>
