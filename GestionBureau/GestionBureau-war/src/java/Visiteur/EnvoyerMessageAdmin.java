/*
 * Servlet Visiteur : Envoyer un message aux administrateurs en sélectionnant son nom
 * JSP associé : visiteur/envoyermessage.jsp
 */
package Visiteur;

import EntityGestion.Message;
import EntityGestion.MessageFacadeLocal;
import EntityGestion.Personne;
import EntityGestion.PersonneFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
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
public class EnvoyerMessageAdmin extends HttpServlet {
    @EJB
    private PersonneFacadeLocal personneFacade;
    @EJB
    private MessageFacadeLocal messageFacade;

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
     
            List<Personne> lPersonnes = personneFacade.findAll();
            
            request.setAttribute("lpersonnes", lPersonnes);
            
            RequestDispatcher rd = request.getRequestDispatcher("visiteur/envoyermessage.jsp");
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
        try (PrintWriter out = response.getWriter()) {
            String message = request.getParameter("message");
            String personneId = request.getParameter("p");
            Message m = new Message();
            m.setTexte(message);
            m.setDateMessage((new GregorianCalendar()).getTime());
            Personne p = personneFacade.find(personneId);
            m.setPersonneId(p);
            
            messageFacade.create(m);
           
            request.setAttribute("msg_envoye", 1);
            doGet(request, response);
            
        }
        catch(Exception e){System.out.println("gregerg");}
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
