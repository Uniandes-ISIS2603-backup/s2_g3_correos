/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author a.silvag
 */
@Entity
public class EventoEntity extends BaseEntity implements Serializable{
    

    private Long ubicacion;
    private String detalle;

    

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
