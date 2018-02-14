/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

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
public class detallePaqueteDTO {
    private long idDetalle;
    private String mensaje;
    /**
     * Constructor por defecto
     */
    public detallePaqueteDTO()
    {
        //Este método esta vacio para la contruccion del JSON
    }
    
    //public datellaPaqueteDTO (detallePaqueteEntity entity){} este constructor sera realizado una vez se realice la capa de persistencia
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
    
    // public detallePaqueteEntity toEntity(){} este metodo se realizara cuando se haya realizado la capa de persistencia
    
    
    
}
