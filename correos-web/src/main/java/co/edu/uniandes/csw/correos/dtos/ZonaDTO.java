/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.ZonaEntity;

/**
 * * ZonaDTO Objeto de transferencia de datos de zona. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id":long,
 *      "longitud": long,
 *      "latitud": long,
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id":1234567890,
 *      "longitud": 68.9797658,
 *      "calificacion": 60.9776467,
 *   }
 *
 * </pre>
 * @author ed.diaz11
 */
public class ZonaDTO {
    private long id;
    private long latitud;
    private long longitud;
    
    /**
     * Contructor vacio
     */
    public ZonaDTO(){
        
    }
    /**
     * Contructor a partir de entity
     * @param entity 
     */
    public ZonaDTO(ZonaEntity entity){
        this.id=entity.getId();
        this.latitud=entity.getLatitud();
        this.longitud=entity.getLongitud();
    }
    
    /**
     * @return El ID de la zona
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }
    
     /**
     * @return La latidud asociada a la zona
     */
    public Long getLatitud() {
        return id;
    }

    /**
     * @param latitud La nueva latitud
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }
    
     /**
     * @return El ID de la ciudad
     */
    public Long getLongitud() {
        return longitud;
    }

    /**
     * @param id El nuevo ID
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
    /**
     * Retorna un DTO a Entity
     * @return una ZonaEntity
     */
    public ZonaEntity toEntity(){
        ZonaEntity entity= new ZonaEntity();
        entity.setId(this.id);
        entity.setLatitud(this.latitud);
        entity.setLongitud(this.longitud);
        return entity;
    }
    
}
