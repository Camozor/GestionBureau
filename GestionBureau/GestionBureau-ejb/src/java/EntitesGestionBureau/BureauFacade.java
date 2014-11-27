/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitesGestionBureau;

import java.util.Iterator;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author 11316834
 */
@Stateless
public class BureauFacade extends AbstractFacade<Bureau> implements BureauFacadeLocal {
    @PersistenceContext(unitName = "GestionBureau-ejbPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public void createPrudent(Bureau entity) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Bureau>> constraintViolations = validator.validate(entity);
        if(constraintViolations.size() > 0){
            Iterator<ConstraintViolation<Bureau>> iterator = constraintViolations.iterator();
            while(iterator.hasNext()){
                ConstraintViolation<Bureau> cv = iterator.next();
                System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            }
        }else{
            getEntityManager().persist(entity);
        }
    }   
    
    
    public BureauFacade() {
        super(Bureau.class);
    }
    
}
