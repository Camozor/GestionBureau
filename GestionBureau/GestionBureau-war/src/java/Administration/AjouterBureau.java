/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;


import EntityGestion.Bureau;
import EntityGestion.BureauFacadeLocal;
import java.io.IOException;
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
public class AjouterBureau extends HttpServlet {
    @EJB
    private BureauFacadeLocal bureauFacade;


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
        request.setCharacterEncoding("UTF-8") ;
            
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
            
        RequestDispatcher rd = request.getRequestDispatcher("administration/ajouterbureau.jsp");

        String batiment = request.getParameter("batiment");
        String numero = request.getParameter("numero");
        String etage = request.getParameter("etage");
        String nb_personnes = request.getParameter("nb_personnes");

        if (batiment != null && numero != null && etage != null && nb_personnes != null) {  
            Bureau newBureau = new Bureau();
            newBureau.setBatiment(batiment);
            newBureau.setNumero(numero);
            newBureau.setEtage(etage);
            newBureau.setNbMaxPersonne(new Integer(nb_personnes));
            bureauFacade.createPrudent(newBureau);
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
