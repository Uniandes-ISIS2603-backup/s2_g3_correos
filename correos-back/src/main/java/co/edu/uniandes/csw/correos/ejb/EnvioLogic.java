/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EnvioPersistence;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.rengifo
 */
@Stateless
public class EnvioLogic {
    
    private static final Logger LOGGER = Logger.getLogger(EnvioLogic.class.getName());

    private EnvioPersistence persistence;
    

    private MensajeroLogic mensajeroLogic;
    
    
    private MensajeroPersistence mensajeroP;

    @Inject
    public EnvioLogic(EnvioPersistence persistence, MensajeroLogic mensajeroLogic, MensajeroPersistence mensajeroP)
    {
        this.persistence=persistence;
        this.mensajeroP=mensajeroP;
        this.mensajeroLogic=mensajeroLogic;
    }
    
    public EnvioLogic()
    {
        this.persistence=null;
        this.mensajeroP=null;
        this.mensajeroLogic=null;
    }
    

    /**
     * @param entity el envio a ser creado
     * @return el envio recien creado
     * @throws BusinessLogicException 
     */
    public EnvioEntity createEnvio(EnvioEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Se comienza a crear un Envio "); 
        LOGGER.info(entity.getEstado()); 
        LOGGER.info((entity.getHoraFinal().toString()));
        LOGGER.info(entity.getHoraInicio().toString());
        
        if (entity.getHoraInicio()>entity.getHoraFinal()){
            throw new BusinessLogicException("La Hora Final es anterior a la Hora Incial.");
        }
        else if (entity.getCliente()==null){
            throw new BusinessLogicException("No se reconoce un cliente.");
        }
        else if (entity.getEstado()==null){
            throw new BusinessLogicException("No se reconoce un estado.");
        }
        else if (entity.getPaquetes().isEmpty()){
            throw new BusinessLogicException("No hay paquetes en el envio.");
        }
        else{
            persistence.create(entity);      
        }
        

        persistence.create(entity);
        asignarMensajero(entity);

        LOGGER.info("Se termina de crear un Envio");
        return entity;
    }
    
    /**
     * 
     * @param id ID del envio buscado
     * @return el envio buscado
     */
    public EnvioEntity getEnvio(Long id){
        return persistence.find(id);
    }
    
    /**
     * 
     * @return todos los envios del sistema
     * @throws BusinessLogicException 
     */
    public List<EnvioEntity> getEnvios() throws BusinessLogicException {
        
        LOGGER.info("Se comienzan a buscar todos los Envios"); 

        List<EnvioEntity> envios = persistence.findAll();

        for(EnvioEntity x:envios)
        {
            if(!x.getEstado().equals("FINALIZADO"))
                asignarMensajero(x);
        }


        LOGGER.info("Se terminan de buscar todos los Envios");
        return envios;
    } 
    
    /**
     * 
     * @param entity el envio a ser actualizado
     * @return el envio atualizado
     * @throws BusinessLogicException 
     */
    public EnvioEntity updateEnvio(EnvioEntity entity) throws BusinessLogicException  {
        
        LOGGER.info("se comienza a actualizar un envio");
        
        if (entity.getHoraInicio()>entity.getHoraFinal()){
            throw new BusinessLogicException("La Hora Final es anterior a la Hora Incial.");
        }
        if (entity.getCliente()==null){
           throw new BusinessLogicException("No se reconoce un cliente.");
        }
        if (entity.getEstado()==null){
            throw new BusinessLogicException("No se reconoce un estado.");
        }
        if (entity.getPaquetes().isEmpty()){
           throw new BusinessLogicException("No hay paquetes en el envio.");
        }
        
        return persistence.update(entity);
    }
    
    /**
     * 
     * @param id ID del envio a ser borrado
     * @throws BusinessLogicException 
     */
    public void deleteEnvio(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Comienza a borrar el envio de id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina a borrar el envio de id={0}", id);
    }   
    
    /**
     * 
     * @param id el ID del evento al que se le va a anadir el nuevo detalle
     * @param evento el evento a ser anadido
     */
    public void agregarEvento(Long id, EventoEntity evento)
    {
       EnvioEntity envio= persistence.find(id);
       List<EventoEntity> eventos = envio.getEventos();
       eventos.add(evento);
       envio.setEventos(eventos);
       persistence.update(envio);
    }
    
    public void asignarMensajero(EnvioEntity envio)
    {
        for(MensajeroEntity x:mensajeroLogic.getMensajeros())
        {
            if(!x.isOcupado())
            {
                for(TransporteEntity w:x.getTransportes() ){
                    if(w.isActivo()){
                    envio.setMensajero(x);
                    x.agregarEnvio(envio);
                    x.setOcupado(true);
                    mensajeroP.update(x);
                    break;
                    }
                }
                if(x.isOcupado())
                    break;
            }
        }
        persistence.update(envio);
    }
}

