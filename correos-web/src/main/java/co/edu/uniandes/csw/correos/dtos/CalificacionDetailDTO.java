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
    
    public CalificacionDetailDTO(){
        super();
    }
    
    public CalificacionDetailDTO(CalificacionEntity entity){
        super();
        MensajeroDTO m= new MensajeroDTO(entity.getMensajero());
        this.mensajero=m;
        
    }
    
    public CalificacionEntity toEntity(){
        CalificacionEntity entity= super.toEntity();
        if(mensajero!=null){
            MensajeroEntity m= mensajero.toEntity();
            entity.setMensajero(m);
        }
        return entity;
    }

    public MensajeroDTO getMensajero() {
        return mensajero;
    }

    public void setMensajero(MensajeroDTO mensajero) {
        this.mensajero = mensajero;
    }
    
   
            
    
    
    
    
}
