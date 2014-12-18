/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

import java.util.ArrayList;
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
    
    public Personne find(String id) {
        return find(new Integer(id));
    }
    
    public int countBureau (Integer b_id) {
        String s = "SELECT COUNT(*) FROM PERSONNE WHERE BUREAU_ID = " 
                 + b_id.toString();
        return (int) em.createNativeQuery(s).getSingleResult();
    }
    
    public List<Bureau> bureauxEquipe (String equipe) {
        
        String s = "SELECT DISTINCT B_ALL.* FROM BUREAU B_ALL " +
            "JOIN BUREAU B_SELECT " +
            "ON B_ALL.BATIMENT = B_SELECT.BATIMENT " +
            "AND B_ALL.ETAGE = B_SELECT.ETAGE " +
            "JOIN PERSONNE P " +
            "ON B_SELECT.BUREAU_ID = P.BUREAU_ID " +
            "WHERE P.EQUIPE = '" + equipe+"'";
        
        List<Bureau> a = em.createNativeQuery(s, Bureau.class).getResultList();
        return a;
    }
    
//    public List<Bureau> findBonsBureaux(String equipe){
//        List<Bureau> lbons = em.createNamedQuery("Personne.findBonsBureaux").setParameter("equipe", equipe).getResultList();
//        return lbons;
//    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
}
