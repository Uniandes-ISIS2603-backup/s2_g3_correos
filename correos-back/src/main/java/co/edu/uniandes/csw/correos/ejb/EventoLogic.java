/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EventoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.silvag
 */
@Stateless
public class EventoLogic {
    
    private EventoPersistence persistence;
       
    private EnvioLogic envioLogic;
    
    @Inject
    public EventoLogic(EventoPersistence eP, EnvioLogic eL)
    {
        this.persistence=eP;
        this.envioLogic=eL;
    }
    
    public EventoLogic()
    {
        this.persistence=null;
        this.envioLogic=null;
    }
    
    public List<EventoEntity> getEventos(){
        
        
        return persistence.findAll();
    }
    
    public EventoEntity getEvento(Long id){
        return persistence.find(id);
    }
    
    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException{
        
      
      return persistence.create(entity);
    }
    
    public EventoEntity updateEvento(EventoEntity entity) throws BusinessLogicException{
        if(entity.getDetalle().split("\\w+").length<3){
          throw new BusinessLogicException("Diga algo en el detalle");
      }
        return persistence.update(entity);
    }
    
    public void deleteEvento(long id){
     persistence.delete(id);
    }


}
