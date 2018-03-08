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
public class PositiveIntegerStrategy implements AttributeStrategy<Double> {

    @Override
    public Double getValue() {
        return Math.random()*Integer.MAX_VALUE;
        
    }
    
}
