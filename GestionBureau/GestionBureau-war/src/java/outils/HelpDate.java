/*
 * Outil de mise en forme de date
 */
package outils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 11316834
 */
public class HelpDate {    
    
    public SimpleDateFormat normal;

    public HelpDate() {
        normal = new SimpleDateFormat("dd MMM yyyy");
    }
    
    public String getJoliDate (Date d) {
        return normal.format(d);
    }
    
    public Boolean obsolete (Date d) {
       return ((new Date()).compareTo(d) > 0);
    }
    
}
