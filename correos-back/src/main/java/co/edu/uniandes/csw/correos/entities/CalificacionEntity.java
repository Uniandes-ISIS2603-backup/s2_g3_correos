/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ed.diaz11
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable{
    
    private Integer calificacion;
    private String comentario;
    
    @PodamExclude
    @ManyToOne()
    private MensajeroEntity mensajero;
     /**
     * @return la calificacion
     */
    public Integer getCalificacion(){
        return this.calificacion;
    }
    
     /**
     * @param calificacion a insertar
     */
    public void setCalificacion(Integer calificacion){
        this.calificacion=calificacion;
    }
     /**
     * @return el comentario asociado a la calificacion
     */ 
    
    
     public String getComentario(){
        return this.comentario;
    }
    
    /**
     * @param comentario a insertar
     */
    public void setComentario(String Comentario){
        this.comentario=comentario;
    }

    public MensajeroEntity getMensajero() {
        return mensajero;
    }

    public void setMensajero(MensajeroEntity mensajero) {
        this.mensajero = mensajero;
    }
    
    
    
    
}
