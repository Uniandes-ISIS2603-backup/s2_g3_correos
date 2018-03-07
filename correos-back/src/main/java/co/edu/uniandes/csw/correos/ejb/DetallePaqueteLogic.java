/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
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
    
    @Inject
    PaqueteLogic paqueteLogic;
    
    public DetallePaqueteLogic (DetallePaquetePersistance persistence)
    {
        this.persistence=persistence;
    }
    
    public DetallePaqueteLogic()

    {
        this.persistence=null;
    }
    
     /**
     * Se encarga de crear un detalle en la base de datos.
     *
     * @param entity Objeto de DetallePaqueteEntity con los datos nuevos
     * @param bookid id del paquete el cual sera padre del nuevo detalle.
     * @return Objeto de DetallePaqueteEntity con los datos nuevos y su ID.
     * 
     */
    public DetallePaqueteEntity createDetallePaquete(Long paqueteid, DetallePaqueteEntity entity) {
        LOGGER.info("Inicia proceso de crear detalle");
        PaqueteEntity paquete = paqueteLogic.getPaquete(paqueteid);
        entity.setBook(paquete);
        return persistence.create(entity);
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
    public DetallePaqueteEntity getDetallePaquete(Long bookid, Long reviewid) {
        return persistence.find(reviewid);
    }
        
        /**
     * Actualiza la información de una instancia de detallePaquete.
     *
     * @param entity Instancia de DetallePaqueteEntity con los nuevos datos.
     * @param bookid id del paquete el cual sera padre del detalle actualizado.
     * @return Instancia de DetallePaqueteEntity con los datos actualizados.
     * 
     */
    public DetallePaqueteEntity updateDetallePaquete(Long paqueteid, DetallePaqueteEntity entity) {
        LOGGER.info("Inicia proceso de actualizar el detalle");
        PaqueteEntity paquete = paqueteLogic.getPaquete(paqueteid);
        entity.setBook(paquete);
        return persistence.update(entity);
    }
        
         /**
     * Elimina una instancia de detalle de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param bookid id del paqute el cual es padre del detalle.
     * 
     */
    public void deleteDetallePaquete(Long paqueteid, Long id) {
        LOGGER.info("Inicia proceso de borrar detalle");
        DetallePaqueteEntity old = getDetallePaquete(paqueteid, id);
        persistence.delete(old.getId());
    }
}
