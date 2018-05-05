/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.IntegerCalificacionStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author ed.diaz11
 */
@Entity
public class CalificacionEntity implements Serializable{
    

    @PodamStrategyValue(IntegerCalificacionStrategy.class)
    private Integer calificacion;


    private String comentario;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     /**
     * @return la calificacion
     */
    public int getCalificacion(){
        return this.calificacion;
    }
    
     /**
     * @param calificacion a insertar
     */
    public void setCalificacion(int calificacion){
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
    public void setComentario(String comentario){
        this.comentario=comentario;
    }
    
}
