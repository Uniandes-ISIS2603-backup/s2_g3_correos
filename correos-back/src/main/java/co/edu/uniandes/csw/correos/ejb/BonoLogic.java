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
    
    /**
     * La persistencia de bono
     */
    private BonoPersistance persistence;
    
  
    /**
     * se inyecta la logica del bono
     * @param persistence
     * @param cl 
     */
    @Inject
    public BonoLogic (BonoPersistance persistence,ClienteLogic cl)
    {
        this.persistence=persistence;
    }
    /**
     * constructor se inicializan las persistencias a null
     */
    public BonoLogic()

    {
        this.persistence=null;
    }
    
    /**
     * Se encarga de crear un bono en la base de datos.
     *
     * @param entity Objeto de BonoEntity con los datos nuevos
     * @param Clienteid id del cliente el cual sera padre del nuevo bono.
     * @return Objeto de BonoEntity con los datos nuevos y su ID.
     * 
     */
    public BonoEntity createBono(BonoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de crear bono");
        if(entity.getDescuento() < 0.0)
        {
            throw new BusinessLogicException("El descuento debe ser un número mayor a cero");
        } 
        if(entity.getCondicion().isEmpty())
        {
             throw new BusinessLogicException("La condicion no puede estar vacia");
        }
        
        if(entity.getDescripcion().isEmpty())
        {
             throw new BusinessLogicException("La descripción no puede estar vacia");
        }
       persistence.create(entity);
        LOGGER.info("Se termina de crear un Bono");
        return entity;
    }
    
    /**
     * 
     * @return todos los bonos
     * @throws BusinessLogicException 
     */
       public List<BonoEntity> getBonos() throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todos los bonos");
       
        List<BonoEntity> bonos = persistence.findAll();
        
        if(bonos.isEmpty())
        {
            throw new BusinessLogicException("No hay bonos en el sistema.");
        }
        return bonos;
    }
        
     /**
     * Obtiene los datos de una instancia de Bono a partir de su ID.
     * La existencia del elemento padre Cliente se debe garantizar.
     *
     * @param clienteid El id del Cliente buscado
     * @param bonoid Identificador de la Bono a consultar
     * @return Instancia de BonoEntity con los datos del Bono consultado.
     * 
     */
    public BonoEntity getBono(Long bonoid) {
        return persistence.find(bonoid);
    }
        
       /**
     * Actualiza la información de una instancia de bono.
     *
     * @param entity Instancia de BonoEntity con los nuevos datos.
     * @param clienteid id del Cliente el cual sera padre del Bono actualizado.
     * @return Instancia de BonoEntity con los datos actualizados.
     * 
     */
    public BonoEntity updateBono(BonoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de actualizar bono");
        if(entity.getDescuento() < 0.0)
        {
            throw new BusinessLogicException("El descuento debe ser un número mayor a cero");
        } 
        if(entity.getCondicion().isEmpty())
        {
             throw new BusinessLogicException("La condicion no puede estar vacia");
        }
        
        if(entity.getDescripcion().isEmpty())
        {
             throw new BusinessLogicException("La descripción no puede estar vacia");
        }
        return persistence.update(entity);
    }
        
        /**
     * Elimina una instancia de bono de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param clienteid id del cliente el cual es padre del bono.
     * 
     */
    public void deleteBono(Long id) {
        LOGGER.log(Level.INFO, "Comienza a borrar el bono de id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina a borrar el bono de id={0}", id);
    }
}
