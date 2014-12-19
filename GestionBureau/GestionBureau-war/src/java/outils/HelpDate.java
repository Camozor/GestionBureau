/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        if ((new Date()).compareTo(d) > 0) return true;
        else                               return false;
    }
    
}
