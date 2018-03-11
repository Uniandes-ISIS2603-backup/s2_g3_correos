/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;

/**
 *
 * @author ed.diaz11
 */
public class CalificacionDetailDTO  extends CalificacionDTO {
    private MensajeroDTO mensajero;
    
    /**
     * Constructor de la clase vacio
     */
    public CalificacionDetailDTO(){
        super();
    }
    /**
     * Constrctor de la clase a partir de un entity
     * @param entity CalificacionEntity
     */
    
    public CalificacionDetailDTO(CalificacionEntity entity){
        super();
        MensajeroDTO m= new MensajeroDTO(entity.getMensajero());
        this.mensajero=m;
        
    }
    /**
     * Metodo para convertir DetailDTO a Entity de la Calificaicon
     * @return un objeto CalificacionEntity con las caracteristicas del DeatailDTO
     */
    
    public CalificacionEntity toEntity(){
        CalificacionEntity entity= super.toEntity();
        if(mensajero!=null){
            MensajeroEntity m= mensajero.toEntity();
            entity.setMensajero(m);
        }
        return entity;
    }
    /**
     * Obtener Mensajero
     * @return MensajeroDTO el mensajero asociado a la calificacion
     */
    public MensajeroDTO getMensajero() {
        return mensajero;
    }
    /**
     * Poner mensajero
     * @param mensajero MensajeroDTO
     */
    public void setMensajero(MensajeroDTO mensajero) {
        this.mensajero = mensajero;
    }
    
   
            
    
    
    
    
}
