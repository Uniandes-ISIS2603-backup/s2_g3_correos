/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.ThreeWordStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author a.silvag
 */
@Entity
public class EventoEntity implements Serializable{
    

    /**
     * ubicacion del evento
     */
    private Long ubicacion;
   
    /**
     * detalle del evento
     */
    @PodamStrategyValue(ThreeWordStrategy.class)
    private String detalle;
    
    /**
     * envio asociado al evento 
     */
    @PodamExclude
    @ManyToOne
    private EnvioEntity envio;
    
    /**
     * id del evento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set the id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return the envio
     */
    public EnvioEntity getEnvio() {
        return envio;
    }

    /**
     * set the envio
     * @param envio 
     */
    public void setEnvio(EnvioEntity envio) {
        this.envio = envio;
    }
    
    
    /**
     * @return the ubicacion
     */
    public Long getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(Long ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
}
