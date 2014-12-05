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
    
    public Personne find(String id) {
        return find(new Integer(id));
    }
    
    public int countBureau (Integer b_id) {
        String s = "SELECT COUNT(*) FROM PERSONNE WHERE BUREAU_ID = " 
                 + b_id.toString();
        return (int) em.createNativeQuery(s).getSingleResult();
    }
    
    public List<Bureau> bureauxEquipe (String equipe) {
     //   String s = "SELECT DISTINCT BUREAU_ID FROM PERSONNE WHERE EQUIPE = " + equipe
         //        + " NATURAL JOIN PERSONNE "
             
        
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
}
