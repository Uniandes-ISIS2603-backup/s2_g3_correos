/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.BonoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.BonoPersistance;
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
public class BonoLogic {
    
    private static final Logger LOGGER= Logger.getLogger(BonoLogic.class.getName());
    
    @Inject
    private BonoPersistance persistence;
    
    public BonoLogic (BonoPersistance persistence)
    {
        this.persistence=persistence;
    }
    
    public BonoLogic()

    {
        this.persistence=null;
    }
    
    public BonoEntity createBono(BonoEntity entity) throws BusinessLogicException
{
    LOGGER.info("Inicia proceso de creación del bono");
        // Verifica la regla de negocio que dice que no puede haber dos cityes con el mismo nombre
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un Bono con el id \"" + entity.getId() + "\"");
        }
        // Invoca la persistencia para crear la city
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del Bono");
        return entity;   
}
    
        public List<BonoEntity> getBonos() {
        LOGGER.info("Inicia proceso de consultar todos los bonos");
        List<BonoEntity> bonos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar toos los bonos");
        return bonos;
    }
        
        public BonoEntity getBono(Long id) {
        return persistence.find(id);
    }
        
        public BonoEntity updateBono(BonoEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un Bono con el id \"" + entity.getId() + "\"");
        }
        return persistence.update(entity);
    }
        
         public void deleteBono(BonoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el bono con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar bono con id={0}", entity.getId());
    }
}
