/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Utilisateur
 */
@Stateless
public class BureauFacade extends AbstractFacade<Bureau> implements BureauFacadeLocal {
    @PersistenceContext(unitName = "GestionBureau-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BureauFacade() {
        super(Bureau.class);
    }
    
}
