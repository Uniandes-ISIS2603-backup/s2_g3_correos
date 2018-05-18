/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;


/**
 * Clase que extiende de {@link TarjetaCreditoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del ReservaDTO vaya a la documentacion de {@link ReservaDTO}
 *@author da.leon
 */

public class TarjetaCreditoDetailDTO extends TarjetaCreditoDTO
{
    
    private TarjetaCreditoDTO tarjeta;
/**
 * contructor
 */
   
    /**
 * constructor con entity por param
 * @param entity 
 */
     public TarjetaCreditoDetailDTO(TarjetaCreditoEntity entity)
    {
        super(entity);
       
    }
     
     /**
      * 
      * @return la terjeta de  credito como entity
      */
    @Override
    public TarjetaCreditoEntity toEntity(){
        return super.toEntity();
    }

   /**
    * retorna la tarjeta que corresponde
    */
    
    public TarjetaCreditoDTO getTarjeta()
    {
        return tarjeta;
    }
    
    /**
     * cambia la tarjeta 
     * @param tarjeta tarjeta que se va a cambiar 
     */
    public void setTarjeta( TarjetaCreditoDTO tarjeta)
    {
        this.tarjeta = tarjeta;
    }

}

