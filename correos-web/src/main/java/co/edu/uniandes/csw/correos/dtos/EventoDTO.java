/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.EventoEntity;

/**
 * * EventoDTO Objeto de transferencia de datos de Evento. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id":long,
 *      "ubicacion": long,
 *      "detalle": String
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id":1234567890,
 *      "ubicacion": 1234567890,
 *      "detalle": "uniandes"
 *   }
 *
 * </pre>
 * @author a.silvag
 */
public class EventoDTO {
    
    private long id;
    private long ubicacion;
    private String detalle;
    
    
public EventoDTO(){
    
}    
/**
 * @return el id del evento
 */
    
public EventoDTO(EventoEntity entity){
    if(entity!=null){
        this.id = entity.getId();
        this.ubicacion = entity.getUbicacion();
        this.detalle = entity.getDetalle();
    }
}    
    
public long getId()
{
        return id;
}

/**
     * @param id el nuevo id del evento
     */
public void setId(long id){
        this.id = id;
}    

    /**
     * @return la ubicacion del evento
     */
    public long getUbicacion() {
        return ubicacion;
    }
/**
 * @param ubicacion la nueva ubicacion del evento
 */
public void setUbicacion(long ubicacion)
{
    this.ubicacion = ubicacion;
}

/**
 * @return el detalle del evento
 */
public String getDetalle(){
    return detalle;
}    
/**
 * @param detalle el nuevo detalle del evento
 */
public void setDetalle(String detalle){
    this.detalle = detalle;
}  

public EventoEntity toEntity(){
    EventoEntity entity = new EventoEntity();
    entity.setDetalle(this.detalle);
    entity.setId(this.id);
    entity.setUbicacion(this.ubicacion);
    return entity;
}
  
}
