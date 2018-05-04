/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.podamstrategy;

import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author a.silvag
 */
public class ThreeWordStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue() {
        String random = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789" ;
        String toReturn = "";
        for (int i = 0; i < 3; i++) {
            double ran = Math.random();
            for(int j = 0; j<ran*10;j++){
                Double d = random.length()*Math.random();
                toReturn +=Character.toString(random.charAt(d.intValue()));
            }
            toReturn+=" ";
        }
        return toReturn;
    }
    
}
