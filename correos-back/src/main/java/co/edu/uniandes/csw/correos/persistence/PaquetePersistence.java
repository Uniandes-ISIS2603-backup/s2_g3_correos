/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author df.rengifo
 */
@Stateless
public class PaquetePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PaquetePersistence.class.getName());
    
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto Paquete que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PaqueteEntity create(PaqueteEntity entity)
    {
        LOGGER.info("Se crea un nuevo Paquete");
        em.persist(entity);
        LOGGER.info("Se creó el paqurte");
        return entity;
    }
    
    /**
     * @param id el ID del paquete existente que se esta buscando.
     * @return el paquete buscado.
     */
    public PaqueteEntity find(long id)
    {
        return em.find(PaqueteEntity.class, id);
    }
    
    /**
     * @return La lista de todos los paquetes en la base de datos
     */
    public List<PaqueteEntity> findAll()
    {
        LOGGER.info("consultando todos los paquetes");
        TypedQuery query= em.createQuery("select u from PaqueteEntity u", PaqueteEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity el paquete que se se va a actualizar
     * @return el paquete actualizado.
     */
    public PaqueteEntity update(PaqueteEntity entity)
    {
       return em.merge(entity);
    }
    
    /**
     * @param entity el paquete que se desea eliminar
     */
    public void delete(PaqueteEntity entity)
    {
        em.remove(entity);
    }
}