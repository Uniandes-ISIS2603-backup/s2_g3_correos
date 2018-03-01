/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.DetallePaquetePersistance;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author t.vargas10
 */

@Stateless
public class DetallePaqueteLogic {
    
     private static final Logger LOGGER= Logger.getLogger(DetallePaqueteLogic.class.getName());
    
    @Inject
    private DetallePaquetePersistance persistence;
    
    public DetallePaqueteLogic (DetallePaquetePersistance persistence)
    {
        this.persistence=persistence;
    }
    
    public DetallePaqueteLogic()

    {
        this.persistence=null;
    }
    
    public DetallePaqueteEntity createDetallePaquete(DetallePaqueteEntity entity) throws BusinessLogicException
{
    LOGGER.info("Inicia proceso de creación del detalle");
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un detalle con el id \"" + entity.getId() + "\"");
        }
        
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del detalle");
        return entity;   
}
        public DetallePaqueteEntity getDetallePaquete(Long id) {
        return persistence.find(id);
    }
        
        public DetallePaqueteEntity updateDetallePaquete(DetallePaqueteEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un detalle con el id \"" + entity.getId() + "\"");
        }
        return persistence.update(entity);
    }
        
         public void deleteDetallePaquete(DetallePaqueteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el detalle con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar detalle con id={0}", entity.getId());
    }
}
