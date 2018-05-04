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
       
    private DetallePaquetePersistance persistence;
      
    PaqueteLogic paqueteLogic;
    
    @Inject
    public DetallePaqueteLogic (DetallePaquetePersistance persistence, PaqueteLogic paqueteLogic)
    {
        this.persistence=persistence;
        this.paqueteLogic=paqueteLogic;
    }
    
    public DetallePaqueteLogic()

    {
        this.persistence=null;
        this.paqueteLogic=null;
    }
    
     /**
     * Se encarga de crear un detalle en la base de datos.
     *
     * @param entity Objeto de DetallePaqueteEntity con los datos nuevos
     * @param bookid id del paquete el cual sera padre del nuevo detalle.
     * @return Objeto de DetallePaqueteEntity con los datos nuevos y su ID.
     * 
     */
    public DetallePaqueteEntity createDetallePaquete(DetallePaqueteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de crear detalle");
        
        if(entity.getMensaje().isEmpty())
        {
            throw new BusinessLogicException ("El mensaje del detalle no puede estar vacío");
        }
        
        
        
       persistence.create(entity);
        LOGGER.info("Se termina de crear un detalle");
        return entity;
    }
       /**
     * Obtiene los datos de una instancia de detalle a partir de su ID.
     * La existencia del elemento padre paquete se debe garantizar.
     *
     * @param bookid El id del paquete buscado
     * @param reviewid Identificador del detalle a consultar
     * @return Instancia de DetallePaqueteEntity con los datos del detalle consultado.
     * 
     */
    public DetallePaqueteEntity getDetallePaquete(Long detalleid) {
        return persistence.find(detalleid);
    }
        
        /**
     * Actualiza la información de una instancia de detallePaquete.
     *
     * @param entity Instancia de DetallePaqueteEntity con los nuevos datos.
     * @param bookid id del paquete el cual sera padre del detalle actualizado.
     * @return Instancia de DetallePaqueteEntity con los datos actualizados.
     * 
     */
    public DetallePaqueteEntity updateDetallePaquete(DetallePaqueteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de actualizar el detalle");
         if(entity.getMensaje().isEmpty())
        {
            throw new BusinessLogicException ("El mensaje del detalle no puede estar vacío");
        }
        
        return persistence.update(entity);
    }
        
         /**
     * Elimina una instancia de detalle de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * 
     */
    public void deleteDetallePaquete(Long id) {
        LOGGER.log(Level.INFO, "Comienza a borrar el detalle de id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina a borrar el detalle de id={0}", id);
    }
    
    public List<DetallePaqueteEntity> getAll()
    {
        return persistence.findAll();
    }
}
