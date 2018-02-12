/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 * * EventoDTO Objeto de transferencia de datos de Evento. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      
 *      "ubicacion": long,
 *      "detalle": String
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "ubicacion": 1234567890,
 *      "detalle": "uniandes"
 *   }
 *
 * </pre>
 * @author a.silvag
 */
public class EventoDTO {
    
    private long ubicacion;
    private String detalle;
    
/**
 * @return la ubicacion del evento
 */
public long ubicacion(){
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
  
}
