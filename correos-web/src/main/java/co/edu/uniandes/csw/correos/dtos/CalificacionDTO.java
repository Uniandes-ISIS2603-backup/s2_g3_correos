/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;

/**
 * * CalificacionDTO Objeto de transferencia de datos de calificacion. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id":long,
 *      "calificacion": int,
 *      "comentario": String
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id":1234567890,
 *      "calificacion": 3,
 *      "comentario": "Me gustan las papas fritas"
 *   }
 *
 * </pre>
 * @author ed.diaz11
 */
public class CalificacionDTO {
    /**
     * id de la calificacion
     */
    private long id;
    /**
     * calificacion 
     */
    private Integer calificacion;
    
    /**
     * comentario 
     */
    private String comentario ;
    
    
    
    /**
     * Constructor por defecto
     */
    public CalificacionDTO ()
    {
        //Este metodo esta vacio para permitir la construccion del JSON
    }
    
    
    /**
     * 
     * Metodo constructor de CalificacionDTO a partir de un CalificacionEntity
     * 
     * @param entity que se quiere convertir a dto
     */
    public CalificacionDTO(CalificacionEntity entity){
        this.id=entity.getId();
        this.calificacion=entity.getCalificacion();
        this.comentario= entity.getComentario();
        
    }
    /**
     * Metrodo para construir un entity a partir de un DTO
     * 
     * @return un objeto de tipo CalificacionEntity con las mismas caracteristicas
     */
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(this.id);
        entity.setCalificacion(this.calificacion);
        entity.setComentario(this.comentario);
        return entity;
    }
    
    /**
     * @return el id de la calificacion
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id el nuevo id de de la calificacion
     */
    public void setId(Long pId) {
        this.id = pId;
    } 
    
    
    /**
     * @return la calificacion de las calificacion
     */
    public int getCalificacion() {
        return this.calificacion;
    }
    
    /**
     * @param pCalificacion de la calificacion
     */
    public void setCalificacion(int pCalificacion) {
        this.calificacion = pCalificacion;
    }
    /**
     * @return el comentario de la calificacion
     */
    public String getComentario() {
        return comentario;
    }
    
    /**
     * @param pComentario comentario dela calificacion
     */
    public void setComentario(String pComentario) {
        this.comentario = pComentario;
    }
    
    
}
