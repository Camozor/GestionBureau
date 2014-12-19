/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 11316834
 */
@Stateless
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {
    @PersistenceContext(unitName = "GestionBureau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public Personne find(String id) {
        return find(new Integer(id));
    }
    
    /*
     * Compte le nombre de personnes dans un bureau d'identifiant b_id
     * 
     */
    
    @Override
    public int countBureau (Integer b_id) {
        String s = "SELECT COUNT(*) FROM PERSONNE WHERE BUREAU_ID = " 
                 + b_id.toString()
                + " AND ((DATE_FIN > CURRENT_DATE) OR (DATE_FIN IS NULL))";
        return (int) em.createNativeQuery(s).getSingleResult();
    }
    
    /*
     * Retourne une liste de bureaux proches pour une equipe
     *
     */
    
    @Override
    public List<Bureau> bureauxEquipe (String equipe) {
        
        String s = "SELECT DISTINCT B_ALL.* FROM BUREAU B_ALL " +
            "JOIN BUREAU B_SELECT " +
            "ON B_ALL.BATIMENT = B_SELECT.BATIMENT " +
            "AND B_ALL.ETAGE = B_SELECT.ETAGE " +
            "JOIN PERSONNE P " +
            "ON B_SELECT.BUREAU_ID = P.BUREAU_ID " +
            "WHERE P.EQUIPE = '" + equipe+"' " +
            "AND ((P.DATE_FIN > CURRENT_DATE) OR (P.DATE_FIN IS NULL))";
                
        List<Bureau> a = em.createNativeQuery(s, Bureau.class).getResultList();
        return a;
    }
    

    public PersonneFacade() {
        super(Personne.class);
    }
    
}
