/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
/**
 *
 * @author t.vargas10
 */
@Stateless
public class DetallePaquetePersistance {
    
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(DetallePaquetePersistance.class.getName());

    /**
     * entity manager 
     */
    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

     
  /**
   * metodo find de detalle paquete
   * @param id que se busca
   * @return la entidad conrrespondiente al id 
   */
    
    public DetallePaqueteEntity find(long id)
    {
        return em.find(DetallePaqueteEntity.class, id);
    }

    /**
     * Encuentra todos los detalles del paquete
     * @return lista con los detalles del paquete
     */
    public List<DetallePaqueteEntity> findAll() {
        LOGGER.info("Consultando todos los detalles del paquete");
        Query q = em.createQuery("select u from DetallePaqueteEntity u");
        return q.getResultList();
    }

    /**
     * Crea un nuevo detalle para el paquete
     * @param entity detalle a crear
     * @return detalle creado
     */
    public DetallePaqueteEntity create(DetallePaqueteEntity entity) {
        LOGGER.info("Creando un detalle nuevo");
        em.persist(entity);
        LOGGER.info("detalle creado");
        return entity;
    }

    /**
     * Modifica el detalle
     * @param entity detalle a modificar
     * @return detalle modificado
     */
    public DetallePaqueteEntity update(DetallePaqueteEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando detalle con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Elimina el detalle identificado con el id id
     * @param id id del detalle
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando detalle con id={0}", id);
        DetallePaqueteEntity entity = em.find(DetallePaqueteEntity.class, id);
        em.remove(entity);
    }
}
