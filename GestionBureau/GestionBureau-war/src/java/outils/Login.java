/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11316834
 */
public class Login {
    
    public static boolean nonAutorise (HttpServletRequest request, HttpServletResponse response) 
        throws IOException {
        if (searchLogin(request, response) == null) {
            response.sendRedirect("AdminLogin");
            return true;
        }
        else return false;
    }
    
    
    public static void isAdmin (HttpServletRequest request, HttpServletResponse response) 
        throws IOException {
        if (searchLogin(request, response) != null)
            request.setAttribute("admin", true);
    }
    
    
    public static String searchLogin (HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("login"))
                    return cookie.getValue();
        
        return null;
    }
}
