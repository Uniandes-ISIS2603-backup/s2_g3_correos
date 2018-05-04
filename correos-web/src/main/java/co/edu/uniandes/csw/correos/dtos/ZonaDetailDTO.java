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
    
    /**
     * Contructor vacio
     */
    public ZonaDetailDTO()
    {
        //Constructor vacio para la construccion del JSON
    }
    /**
     * Contructor a partir de un entity
     * @param entity 
     */
    public ZonaDetailDTO(ZonaEntity entity){
        super(entity);
        if(!entity.getMensajeros().isEmpty()){
            List<MensajeroDTO> mL=new ArrayList();
            for(MensajeroEntity m: entity.getMensajeros())
                mL.add(new MensajeroDTO(m));
            setMensajeros(mL);
            
        }
        
    }
    /**
     * Convertir a entity
     * @return ZonaEntity
     */
    @Override
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
    /**
     * Obtener mensajeros
     * @return lista de mensajeros
     */
    public List<MensajeroDTO> getMensajeros() {
        return mensajeros;
    }
    /**
     * Poner mensajeros
     * @param mensajeros 
     */
    public void setMensajeros(List<MensajeroDTO> mensajeros) {
        this.mensajeros = mensajeros;
    }
    
    
    
}
