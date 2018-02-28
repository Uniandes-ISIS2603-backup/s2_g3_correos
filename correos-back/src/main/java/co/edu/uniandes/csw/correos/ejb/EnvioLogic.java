/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
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

    public EnvioEntity createEnvio(EnvioEntity entity) throws BusinessLogicException {
        LOGGER.info("Se comienza a crear un Envio");      
        persistence.create(entity);
        LOGGER.info("Se termina de crear un Envio");
        return entity;
    }

    public List<EnvioEntity> geEnvios() {
        LOGGER.info("Se comienzan a buscar todos los Envios");       
        List<EnvioEntity> envios = persistence.findAll();
        LOGGER.info("Se terminan de buscar todos los Envios");
        return envios;
    }

    public EnvioEntity getCity(Long id) {
        return persistence.find(id);
    }

    public EnvioEntity updateCity(EnvioEntity entity) throws BusinessLogicException  {       
        return persistence.update(entity);
    }
    
    public void deleteCity(EnvioEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Comienza a borrar el envio de id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina a borrar el envio de id={0}", entity.getId());
    }    
}
