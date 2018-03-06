/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;


import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ed.diaz11
 */
@Stateless
public class ZonaPersistence {

    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());

    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto Zona que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ZonaEntity create(ZonaEntity entity) {
        LOGGER.info("Creando una Zona nueva");
        em.persist(entity);
        LOGGER.info("Creando una Zona nueva");
        return entity;
    }



    public List<ZonaEntity> findAll() {
        LOGGER.info("Consultando todas las zonas ");
        TypedQuery query = em.createQuery("select u from ZonaEntity u", ZonaEntity.class);
        return query.getResultList();
    }

    public ZonaEntity find(Long id) {
        return em.find(ZonaEntity.class, id);
    }

    public ZonaEntity update(ZonaEntity entity) {
         return em.merge(entity);
    }
    
    public void delete( Long id) {
        em.remove(em.find(ZonaEntity.class, id));
    }
    
}
