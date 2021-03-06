/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityGestion;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 11316834
 */
@Local
public interface PersonneFacadeLocal {

    void create(Personne personne);
    
    void createPrudent(Personne personne);

    void edit(Personne personne);

    void remove(Personne personne);

    Personne find(Object id);
    Personne find(String id);

    List<Personne> findAll();

    List<Personne> findRange(int[] range);

    int count();
    
    public int countBureau (Integer b_id);
    
    public List<Bureau> bureauxEquipe (String equipe);
    
//        public List<Bureau> findBonsBureaux(String equipe);
}
