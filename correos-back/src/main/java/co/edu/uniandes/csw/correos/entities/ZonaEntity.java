/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.DoubleZonaStrategy;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author ed.diaz11
 */
@Entity
public class ZonaEntity extends BaseEntity implements Serializable{
    
    @PodamStrategyValue(DoubleZonaStrategy.class)
    private Double latitud;
    @PodamStrategyValue(DoubleZonaStrategy.class)
    private Double longitud;
    
    @PodamExclude
    @ManyToMany
    private List<MensajeroEntity> mensajeros;
    

    
    /**
     * @return la latitud
     */    
    public Double getLatitud(){
        return this.latitud;
    }
    /**
     * @param latitud a insertar
     */
    public void setLatitud(Double latitud){
        this.latitud=latitud;
    }
    /**
     * @return la longitud
     */
    public Double getLongitud(){
        return this.longitud;
    }
    /**
     * @param longitud a insertar
     */
    
    public void setLongitud(Double longitud){
        this.longitud=longitud;
    }

    public List<MensajeroEntity> getMensajeros() {
        return mensajeros;
    }

    public void setMensajeros(List<MensajeroEntity> mensajeros) {
        this.mensajeros = mensajeros;
    }
    
}
