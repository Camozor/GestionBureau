/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author 11316834
 */
public class HelpDate extends GregorianCalendar {    
    
    public String getDate (Date d) {
       
        this.setGregorianChange(d);
        String result = 
            this.get(DAY_OF_MONTH) + " " + 
            this.getDisplayName(MONTH, SHORT, Locale.FRENCH) + " " + 
            this.get(YEAR);
        
        System.out.println(result);
        return result;
    }
    
}
