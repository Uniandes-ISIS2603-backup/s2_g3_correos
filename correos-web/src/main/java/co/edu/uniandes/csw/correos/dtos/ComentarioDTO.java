/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 *
 * @author ed.diaz11
 */
public class ComentarioDTO {
    private long id;
    private double calificacion;
    private String comentario ;
    
    
    
    /**
     * Constructor por defecto
     */
    public ComentarioDTO ()
    {
        //Este metodo esta vacio para permitir la construccion del JSON
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
    public void setCalificacion(double pCalificacion) {
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
