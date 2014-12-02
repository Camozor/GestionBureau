/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administration;

import EntityGestion.Bureau;
import EntityGestion.BureauFacadeLocal;
import EntityGestion.Personne;
import EntityGestion.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 10900286
 */
public class AffecterBureau extends HttpServlet {
    @EJB
    private BureauFacadeLocal bureauFacade;
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
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            
            Personne p = personneFacade.find(new Integer(request.getParameter("id")));
            request.setAttribute("p", p);
            
            List<Bureau> lbureaux = bureauFacade.findAll();
            
            request.setAttribute("lbu", lbureaux);
            
            
            
            RequestDispatcher rd = request.getRequestDispatcher("affecterbureau.jsp");
            
            rd.forward(request, response);
        }
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
            String bureauId = request.getParameter("bu-id-selected");
            String personneId = request.getParameter("idpersonne");
            
            try{
                Personne p = personneFacade.find(new Integer(personneId));
                try{
                    Bureau b = bureauFacade.find(new Integer(bureauId));
                    p.setBureauId(b);
                    SuperMail m = new SuperMail();
                    m.sendMail(p.getMail(), "nouvelle affectation :" +b.getJoliNom());
                }
                catch(Exception e1){
                    p.setBureauId(null);
                    SuperMail m = new SuperMail();
                    m.sendMail(p.getMail(), "Vous etes vire !");
                }
                
                personneFacade.edit(p);
                response.sendRedirect("ListePersonnes");
                return;
            }
            catch(Exception e){e.printStackTrace();}
            
            
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
