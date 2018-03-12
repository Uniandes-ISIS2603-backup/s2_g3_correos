/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.EventoEntity;

/**
 *
 * @author a.silvag
 */
public class EventoDetailDTO extends EventoDTO {
    
    /**
     *Constructor por defectp
     */
    public EventoDetailDTO(){
        
    }
    
    public EventoDetailDTO(EventoEntity entity){
        super(entity);
    }
    
    /*
    * @return el evento en una entity
    */
    public EventoEntity toEntity(){
        return super.toEntity();
    }
            }
