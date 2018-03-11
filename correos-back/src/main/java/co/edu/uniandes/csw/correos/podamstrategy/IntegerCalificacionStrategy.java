/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.podamstrategy;

import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author ed.diaz11
 */
public class IntegerCalificacionStrategy implements AttributeStrategy<Integer> {

    @Override
    public Integer getValue() {
        Random aleatorio = new Random(System.currentTimeMillis());
        int intAletorio = aleatorio.nextInt(5);
        if(intAletorio==0){
            intAletorio++;
            
        }
        return intAletorio;
    }
    
}
