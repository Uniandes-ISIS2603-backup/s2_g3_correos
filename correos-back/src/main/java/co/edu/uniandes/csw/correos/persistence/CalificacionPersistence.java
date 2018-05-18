/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ed.diaz11
 */
@Stateless
public class CalificacionPersistence {
    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());

    /**
     * entity manager 
     */
    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto calificacion que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CalificacionEntity create(CalificacionEntity entity) {
        LOGGER.info("Creando una Calificacion nueva");
        em.persist(entity);
        LOGGER.info("Creando una Calificacion nueva");
        return entity;
    }


    /**
     * 
     * @return todas las calificaciones
     */
    public List<CalificacionEntity> findAll() {
        LOGGER.info("Consultando todas las calificaciones ");
        TypedQuery query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }

    /**
     * 
     * @param id
     * @return la calificacion con id por param
     */
    public CalificacionEntity find(Long id) {
        return em.find(CalificacionEntity.class, id);
    }

    /**
     * 
     * @param entity
     * @return actualiza la califcacion
     */
    public CalificacionEntity update(CalificacionEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * borra la calificacion con id por param
     * @param id 
     */
    public void delete(Long id) {
        em.remove(em.find(CalificacionEntity.class, id));
    }
}
