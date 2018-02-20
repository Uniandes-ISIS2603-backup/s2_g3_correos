/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.EventoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.silvag
 */
@Stateless
public class EventoPersistence {
     private static final Logger LOGGER = Logger.getLogger(EventoPersistence.class.getName());

    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto evento que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EventoEntity create(EventoEntity entity) {
        LOGGER.info("Creando una evento nueva");
        em.persist(entity);
        LOGGER.info("Creando una evento nueva");
        return entity;
    }

    /**
     * Busca si hay alguna evento con el nombre que se envía de argumento
     *
     * @param name: Nombre de la evento que se está buscando
     * @return null si no existe ninguna evento con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public EventoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando evento por nombre ", name);

        // Se crea un query para buscar eventoes con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From EventoEntity e where e.name = :name", EventoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<EventoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    public List<EventoEntity> findAll() {
        LOGGER.info("Consultando todas las eventos");
        TypedQuery query = em.createQuery("select u from EventoEntity u", EventoEntity.class);
        return query.getResultList();
    }

    public EventoEntity find(Long id) {
        return em.find(EventoEntity.class, id);
    }

    public EventoEntity update(EventoEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(EventoEntity entity) {
        em.remove(entity);
    }
}