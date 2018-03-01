/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EventoPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import static reactor.event.selector.Selectors.$;

/**
 *
 * @author a.silvag
 */
@Stateless
public class EventoLogic {
    private static final Logger LOGGER = Logger.getLogger(EventoLogic.class.getName());
    
    @Inject
    private EventoPersistence persistence;
    
    @Inject
    private EnvioLogic envioLogic;
    
    public List<EventoEntity> getEventos(Long envioid){
        EnvioEntity envio = envioLogic.getEnvio(envioid);
        
        return envio.getEventos();
    }
    
    public EventoEntity getEvento(Long id){
        return persistence.find(id);
    }
    
    public EventoEntity createEvento(Long envioId, EventoEntity entity) throws BusinessLogicException{
        EnvioEntity envio = envioLogic.getEnvio(envioId);
      if(entity.getDetalle().split("\\w+").length<3){
          throw new BusinessLogicException("Diga algo en el detalle");
      }
      
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
