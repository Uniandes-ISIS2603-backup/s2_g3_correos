/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ed.diaz11
 */
public class ZonaDetailDTO extends ZonaDTO {
    
    private List<MensajeroDTO> mensajeros;
    
    
    public ZonaDetailDTO(){
        
    }
    
    public ZonaEntity toEntity(){
        ZonaEntity entity= super.toEntity();
        if(mensajeros!=null){
            ArrayList<MensajeroEntity> m = new ArrayList();
            for (MensajeroDTO en : mensajeros) {
                MensajeroEntity mEntity= en.toEntity();
                m.add(mEntity);
                
            }
            entity.setMensajeros(m);
        }
        return entity;
        
    }
    
    
    
}
