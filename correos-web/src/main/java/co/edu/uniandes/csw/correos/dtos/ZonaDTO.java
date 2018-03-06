/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.ZonaEntity;

/**
 *
 * @author ed.diaz11
 */
public class ZonaDTO {
    private long id;
    private long latitud;
    private long longitud;
    
    
    public ZonaDTO(){
        
    }
    
    /**
     * @return El ID de la zona
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * @return La latidud asociada a la zona
     */
    public Long getLatitud() {
        return id;
    }

    /**
     * @param latitud La nueva latitud
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }
    
     /**
     * @return El ID de la ciudad
     */
    public Long getLongitud() {
        return longitud;
    }

    /**
     * @param id El nuevo ID
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
    
    public ZonaEntity toEntity(){
        ZonaEntity entity= new ZonaEntity();
        entity.setId(this.id);
        entity.setLatitud(this.latitud);
        entity.setLongitud(this.longitud);
        return entity;
    }
}
