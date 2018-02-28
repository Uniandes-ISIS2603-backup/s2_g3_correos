/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.PaquetePersistence;
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
public class PaqueteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PaqueteLogic.class.getName());

    @Inject
    private PaquetePersistence persistence;

    public PaqueteEntity createPaquete(PaqueteEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Se comienza a crear un Paquete"); 
        
        if(entity.getDimensionA()*entity.getDimensionB()*entity.getDimensionC()==0){
            throw new BusinessLogicException("El volumen del paquete ha sido evaluado en 0.");
        }
        if(entity.getPeso()<=0){
            throw new BusinessLogicException("El peso del paquete ha sido evaluado en 0.");
        }     
        
        persistence.create(entity);
        LOGGER.info("Se termina de crear un Paquete");
        return entity;        
    }

    public List<PaqueteEntity> getPaquetes() throws BusinessLogicException {
        LOGGER.info("Se comienzan a buscar todos los Paquetes");       
        List<PaqueteEntity> paquetes = persistence.findAll();
        
        if(paquetes.isEmpty())
        {
            throw new BusinessLogicException("No hay paquetes en el sistema.");
        } 
        
        LOGGER.info("Se terminan de buscar todos los Paquetes");
        return paquetes;
    }

    public PaqueteEntity getCity(Long id) {
        return persistence.find(id);
    }

    public PaqueteEntity updateCity(PaqueteEntity entity) throws BusinessLogicException  {
        
        LOGGER.log(Level.INFO, "Se comienza a actualizar un paquete");
        
        if(entity.getDimensionA()*entity.getDimensionB()*entity.getDimensionC()==0){
            throw new BusinessLogicException("El volumen del paquete ha sido evaluado en 0.");
        }
        if(entity.getPeso()<=0){
            throw new BusinessLogicException("El peso del paquete ha sido evaluado en 0.");
        }   
        
        return persistence.update(entity);
    }
    
    public void deleteCity(PaqueteEntity entity){
        LOGGER.log(Level.INFO, "Comienza a borrar el paquete de id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina a borrar el paquete de id={0}", entity.getId());
    }    
}

