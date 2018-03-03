/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ed.diaz11
 */
@Entity
public class ZonaEntity extends BaseEntity implements Serializable{
    
    private Long latitud;
    private Long longitud;
    
    @PodamExclude
    @ManyToMany(mappedBy = "zonas")
    private List<MensajeroEntity> mensajeros;
    

    
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

    public List<MensajeroEntity> getMensajeros() {
        return mensajeros;
    }

    public void setMensajeros(List<MensajeroEntity> mensajeros) {
        this.mensajeros = mensajeros;
    }
    
}
