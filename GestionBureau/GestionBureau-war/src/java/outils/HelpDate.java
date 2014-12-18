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
    
    public String getDateTime (Date d) {
       
        this.setGregorianChange(d);
        
        Integer minutes = this.get(MINUTE);
        String minutestr = "";
        if (minutes > 10) minutestr = minutes.toString();
        else minutestr = "0" + minutes.toString();
        
        System.out.println(minutestr);
        
        String result = 
            this.get(DAY_OF_MONTH) + " " + 
            this.getDisplayName(MONTH, SHORT, Locale.FRENCH) + " " + 
            this.get(YEAR) + " " + 
            this.get(HOUR_OF_DAY) + ":" + this.get(MINUTE) +
            minutestr;
        
        System.out.println(result);
        return result;
    }
    
}
