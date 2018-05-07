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
    
    /**
     * conexion con persistencia
     */
    private EventoPersistence persistence;
       
    /**
     * conexion con logica de envio
     */
    private EnvioLogic envioLogic;
    
    /**
     * constructor con parametros
     * @param eP
     * @param eL 
     */
    @Inject
    public EventoLogic(EventoPersistence eP, EnvioLogic eL)
    {
        this.persistence=eP;
        this.envioLogic=eL;
    }
    
    /**
     * constructor
     */
    public EventoLogic()
    {
        this.persistence=null;
        this.envioLogic=null;
    }
    
    /**
     * 
     * @return todos los eventos
     */
    public List<EventoEntity> getEventos(){
        
        
        return persistence.findAll();
    }
     /**
      * 
      * @param id
      * @return el evento con id por param
      */
    public EventoEntity getEvento(Long id){
        return persistence.find(id);
    }
    
    /**
     * 
     * @param entity
     * @return el nuevo evento
     * @throws BusinessLogicException 
     */
    public EventoEntity createEvento(EventoEntity entity) throws BusinessLogicException{
        
      
      return persistence.create(entity);
    }
    
    /**
     * 
     * @param entity
     * @return el evento actualizado
     * @throws BusinessLogicException 
     */
    public EventoEntity updateEvento(EventoEntity entity) throws BusinessLogicException{
        if(entity.getDetalle().split("\\w+").length<3){
          throw new BusinessLogicException("Diga algo en el detalle");
      }
        return persistence.update(entity);
    }
    
    /**
     * se borra el evento con id por param
     * @param id 
     */
    public void deleteEvento(long id){
     persistence.delete(id);
    }


}
