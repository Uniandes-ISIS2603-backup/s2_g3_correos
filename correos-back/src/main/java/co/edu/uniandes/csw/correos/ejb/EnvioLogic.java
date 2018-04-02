/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EnvioPersistence;
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

    @Inject
    private EnvioPersistence persistence;
    
    /**
     * 
     * @param entity el envio a ser creado
     * @return el envio recien creado
     * @throws BusinessLogicException 
     */
    public EnvioEntity createEnvio(EnvioEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Se comienza a crear un Envio"); 
        
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
        
        persistence.create(entity);
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
        
        if(envios.isEmpty())
        {
            throw new BusinessLogicException("No hay envios en el sistema.");
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
    
    public double calcularHoraFinal(EnvioEntity envio)
    {
        if(envio.getDireccionEntrega().equals(envio.getDireccionRecogida())){
            return envio.getHoraInicio();
        }
        else {
            return envio.getHoraInicio()+2000;
        }     
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
}

