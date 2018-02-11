/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 *
 * @author t.vargas10
 */
public class detallePaqueteDTO {
    private long idDetalle;
    private String mensaje;
    
    public detallePaqueteDTO()
    {
        //Este método esta vacio para la contruccion del JSON
    }
    
    //public datellaPaqueteDTO (detallePaqueteEntity entity){} este constructor sera realizado una vez se realice la capa de persistencia
    
    public Long getId()
    {
        return idDetalle;
    }
    
    public void setId(Long idDetalle)
    {
        this.idDetalle = idDetalle;
    }
    
    public String getMensaje()
    {
        return mensaje;
    }
    
    public void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }
    
    // public detallePaqueteEntity toEntity(){} este metodo se realizara cuando se haya realizado la capa de persistencia
    
    
    
}
