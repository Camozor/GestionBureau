/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntitesGestionBureau;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 11316834
 */
@Local
public interface BureauFacadeLocal {

    void create(Bureau bureau);
    
    void createPrudent(Bureau bureau);

    void edit(Bureau bureau);

    void remove(Bureau bureau);

    Bureau find(Object id);

    List<Bureau> findAll();

    List<Bureau> findRange(int[] range);

    int count();
    
}
