/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.PagoEntity;
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
public class PagoPersistence {
     private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto pago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PagoEntity create(PagoEntity entity) {
        LOGGER.info("Creando una pago nueva");
        em.persist(entity);
        LOGGER.info("Creando una pago nueva");
        return entity;
    }

    /**
     * Busca si hay alguna pago con el nombre que se envía de argumento
     *
     * @param name: Nombre de la pago que se está buscando
     * @return null si no existe ninguna pago con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public PagoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando pago por nombre ", name);

        // Se crea un query para buscar pagoes con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From PagoEntity e where e.name = :name", PagoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<PagoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    public List<PagoEntity> findAll() {
        LOGGER.info("Consultando todas las pagos");
        TypedQuery query = em.createQuery("select u from PagoEntity u", PagoEntity.class);
        return query.getResultList();
    }

    public PagoEntity find(Long id) {
        return em.find(PagoEntity.class, id);
    }

    public PagoEntity update(PagoEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando pago con id={0}", id);
        PagoEntity entity = em.find(PagoEntity.class, id);
        em.remove(entity);
    }
}
