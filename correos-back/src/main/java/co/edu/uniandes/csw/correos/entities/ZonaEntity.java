/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

/**
 *
 * @author ed.diaz11
 */
public class ZonaEntity {
    
    private Long latitud;
    private Long longitud;
    
    /**
     * @return la latitud
     */    
    public Long getLatitud(){
        return this.latitud;
    }
    /**
     * @param latitud a insertar
     */
    public void setLatitud(Long latitud){
        this.latitud=latitud;
    }
    /**
     * @return la longitud
     */
    public Long getLongitud(){
        return this.longitud;
    }
    /**
     * @param longitud a insertar
     */
    
    public void setLongitud(Long longitud){
        this.longitud=longitud;
    }
}
