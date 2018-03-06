/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;

/**
 *
 * @author ed.diaz11
 */
public class CalificacionDTO {
    private long id;
    private int calificacion;
    private String comentario ;
    
    
    
    /**
     * Constructor por defecto
     */
    public CalificacionDTO ()
    {
        //Este metodo esta vacio para permitir la construccion del JSON
    }
    
    public CalificacionDTO(CalificacionEntity entity){
        this.id=entity.getId();
        this.calificacion=entity.getCalificacion();
        this.comentario= entity.getComentario();
        
    }
    
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setCalificacion(this.calificacion);
        entity.setComentario(this.comentario);
        return entity;
    }
    
    /**
     * @return el ID del comentario
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id el nuevo id del comentario
     */
    public void setId(Long pId) {
        this.id = pId;
    } 
    
    
    /**
     * @return la calificacion del comentairo
     */
    public double getCalificacion() {
        return calificacion;
    }
    
    /**
     * @param pCalificacion del nuevo comentario
     */
    public void setCalificacion(int pCalificacion) {
        this.calificacion = pCalificacion;
    }
    /**
     * @return el comentario del comentairo
     */
    public String getComentario() {
        return comentario;
    }
    
    /**
     * @param pComentario comentario del comentario
     */
    public void setComentario(String pComentario) {
        this.comentario = pComentario;
    }
    
}
