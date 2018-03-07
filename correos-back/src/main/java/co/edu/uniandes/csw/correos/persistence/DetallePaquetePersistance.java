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
    
    private static final Logger LOGGER = Logger.getLogger(DetallePaquetePersistance.class.getName());

    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

     
    /**
     * Buscar un detalle
     * 
     * Busca si hay algun detalle asociad a un paquete y con un ID específico
     * @param paqueteid El ID del paquete con respecto al cual se busca
     * @param detalleid El ID del detalle buscado
     * @return El detalle encontrado o null. Nota: Si existe una o más detalles 
     * devuelve siempre la primera que encuentra
     */
    
    /**
     * public DetallePaqueteEntity find(Long paqueteid, Long detalleid) {
        TypedQuery<DetallePaqueteEntity> q = em.createQuery("select p from ReviewEntity p where (p.book.id = :bookid) and (p.id = :reviewid)", DetallePaqueteEntity.class);
        q.setParameter("bookid", paqueteid);
        q.setParameter("reviewid", detalleid);
        List<DetallePaqueteEntity> results = q.getResultList();
        DetallePaqueteEntity review = null;
        if (results == null) {
            review = null;
        } else if (results.isEmpty()) {
            review = null;
        } else if (results.size() >= 1) {
            review = results.get(0);
        }

        return review;
    }
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
