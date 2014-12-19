<%-- 
    Document   : adminloginsucess
    Created on : 19 déc. 2014, 03:13:59
    Author     : Camille
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Success Page</title>
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
        Yeah !
    </body>
</html>
