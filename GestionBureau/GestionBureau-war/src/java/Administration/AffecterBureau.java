/*
 * Servlet Administration : Affecter un bureau à une personne
 * JSP associé : affecterbureau.jsp
 */
package Administration;

import outils.SuperMail;
import EntityGestion.Bureau;
import EntityGestion.BureauFacadeLocal;
import EntityGestion.Personne;
import EntityGestion.PersonneFacadeLocal;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import outils.HelpDate;
import outils.Login;

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
        request.setCharacterEncoding("UTF-8");

        if (Login.nonAutorise(request, response)) return;

        Personne p = null;
        try{
            p = personneFacade.find(new Integer(request.getParameter("idpersonne")));
        }catch(NumberFormatException e){
            response.sendRedirect("AdminListePersonnes");
            return;
        }
        request.setAttribute("p", p);

        List<Bureau> lbutous = bureauFacade.findAll();
        List<Bureau> lbuproches = personneFacade.bureauxEquipe(p.getEquipe());
        List<Bureau> lbuautres = Bureau.getAutresBureaux(lbutous, lbuproches);

        Map<Bureau, Integer> mapProches = new HashMap<>();
        Map<Bureau, Integer> mapAutres = new HashMap<>();

        for(Bureau b : lbuproches){
            mapProches.put(b, personneFacade.countBureau(b.getBureauId()));
        }

        for(Bureau b : lbuautres){
            mapAutres.put(b, personneFacade.countBureau(b.getBureauId()));
        }

        request.setAttribute("mapProches", mapProches);
        request.setAttribute("mapAutres", mapAutres);

        RequestDispatcher rd = request.getRequestDispatcher("administration/affecterbureau.jsp");

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

    
    private class BureauCompletException extends Exception {}
    private class MemeBureauException extends Exception {}
    private class PersonneException extends Exception {}
    
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

        // Si on trouve pas la personne on arrête
        Personne p = null;
        try{
            p = personneFacade.find(new Integer(personneId));
        }catch(NumberFormatException e){response.sendRedirect("AdminListePersonnes"); return;}

        // Sinon
        try{

            Integer bureauActuel = null, bureauDemande = null;
            
            
            // Si la date de fin de présence est nulle on peut continuer
            // sinon il faut vérifier qu'elle n'est pas obsolète
            HelpDate hd = new HelpDate();
            Date d = p.getDateFin();
            if(d != null){
                if(hd.obsolete(d)){
                    throw new PersonneException();
                }
            }
                        
            // Si on trouve un bureau avec l'id demandée
            Bureau b = null;
            try{ 
                b = bureauFacade.find(new Integer(bureauId));
                bureauDemande = b.getBureauId();
            } catch (NumberFormatException e) {} // sinon on laisse à null

            // Si on trouve un bureau actuel de la personne
            try{
                bureauActuel = p.getBureauId().getBureauId();
            }
            catch(NullPointerException npe){} // sinon on laisse à null

            // Si ce sont les mêmes bureaux afficher une erreur
            if (Objects.equals(bureauDemande, bureauActuel)) {
                throw new MemeBureauException();
            }

            // sinon tester si le bureau n'est pas complet
            if (bureauDemande != null) {
                int nb_occupants = personneFacade.countBureau(b.getBureauId());
                if (nb_occupants >= b.getNbMaxPersonne()) {
                    throw new BureauCompletException(); 
                }
            }
            
            // enfin affecter le nouveau bureau
            p.setBureauId(b);

            // Choisir le message selon le nouveau bureau
            String message;
            if (bureauDemande == null) { message = "Vous êtes viré de votre bureau !"; }
            else { message = "nouvelle affectation :" + b.getJoliNom(); }
            
            // Envoyer le mail
            try {
                SuperMail m = new SuperMail();
                m.sendMail(p.getMail(), message);
            }
            catch (Exception e){}
            
            // Persister
            personneFacade.edit(p);

            // Fin : succès
            request.setAttribute("bureau_change", 1);
            
            doGet(request, response);
        }
        catch (BureauCompletException e){
            request.setAttribute("erreur", "Ce bureau est complet !");
            doGet(request, response);
        }
        catch (MemeBureauException e){
            request.setAttribute("erreur", "C'est le même bureau...");
            doGet(request, response);
        }
        catch (PersonneException e) {
            request.setAttribute("erreur", "Personne plus membre...");
            doGet(request, response);
        }

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
