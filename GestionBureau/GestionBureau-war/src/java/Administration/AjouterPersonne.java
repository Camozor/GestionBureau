/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;


import EntityGestion.Personne;
import EntityGestion.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11316834
 */
public class AjouterPersonne extends HttpServlet {
    @EJB
    private PersonneFacadeLocal personneFacade;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        RequestDispatcher rd = request.getRequestDispatcher("administration/ajouterpersonne.jsp"); 
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String equipe = request.getParameter("equipe");
        String date_debut = request.getParameter("date_debut");
        String date_fin = request.getParameter("date_fin");
        
         if (nom != null && prenom != null && mail != null && equipe != null && date_debut != null) {
            
            try {
                Personne p = new Personne();
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setMail(mail);
                p.setEquipe(equipe);
                p.setDateDebut(Date.valueOf(date_debut));
                
                try {
                    Date dateFin = Date.valueOf(date_fin);
                    p.setDateFin(dateFin);
                    System.out.println(Date.valueOf(date_fin).toString());
                }
                catch (Exception err) {
                    System.out.println(err);
                }
                
                personneFacade.create(p);
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
         else { 
             
         }
         
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
