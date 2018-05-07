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
public class TenPlusNumericString implements AttributeStrategy<String>{

    /**
     * 
     * @return genera un string de numeros mayor igual a 10 caracteres
     */
    @Override
    public String getValue() {
        String num = "0123456789";
        String ret = "";
        Double d = Math.random()*5;
        int sum = d.intValue()+10;
        for (int i = 0; i < sum; i++) {
            Double dou = Math.random()*num.length();
            int rad = dou.intValue();
            ret+=Character.toString(num.charAt(rad));
        }
        return ret;
    }
    
}
