/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;

/**
 * MensajeroDTO Objeto de transferencia de datos de Mensajeros. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "idDetalle": long,
 *      "mensaje": string,
 *   }
 * @author t.vargas10
 */
public class DetallePaqueteDTO {
    private String name;
    private long idDetalle;
    private String mensaje;
    /**
     * Constructor por defecto
     */
    public DetallePaqueteDTO() 
    {
        //Constructor vacio para permitir la construccion del JSON
    }

    /**
 * constructor con entity por param
 * @param entity 
 */
    public DetallePaqueteDTO(DetallePaqueteEntity entity) {

        this.idDetalle = entity.getId();
        this.mensaje = entity.getMensaje();
    }

    /**
     * 
     * @return el detalle paquete como un entity
     */
    public DetallePaqueteEntity toEntity() {
        DetallePaqueteEntity entity = new DetallePaqueteEntity();
        entity.setId(this.idDetalle);
        entity.setMensaje(this.mensaje);
        return entity;
    }
    /**
     * @return id el paquete 
     */
    public Long getId()
    {
        return idDetalle;
    }
    /**
     * @param idDetalle nuevo id del paquete
     */
    public void setId(Long idDetalle)
    {
        this.idDetalle = idDetalle;
    }
    /**
     * @return mensaje del paquete 
     */
    public String getMensaje()
    {
        return mensaje;
    }
    /**
     * @param mensaje nuevo mensaje para el paquete  
     */
    public void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }
    
    
    
    
}
