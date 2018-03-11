/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.podamstrategy;

import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author ed.diaz11
 */
public class DoubleZonaStrategy implements AttributeStrategy<Double>{


    public Double getValue() {
        double random= Math.random()*89.10213;
        return random;
    }
    
}
