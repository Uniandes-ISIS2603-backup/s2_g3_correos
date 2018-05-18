/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import java.util.List;
import java.util.logging.Level;
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
public class EnvioPersistence {
    
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(EnvioPersistence.class.getName());
    
    /**
     * entity manager 
     */
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto Envio que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EnvioEntity create(EnvioEntity entity)
    {
        LOGGER.info("Se crea un nuevo Envio");
        em.persist(entity);
        LOGGER.info("Se creo el envio");
        return entity;
    }
    
    /**
     * @param id el ID del envio existente que se esta buscando.
     * @return el envio buscado.
     */
    public EnvioEntity find(long id)
    {
        return em.find(EnvioEntity.class, id);
    }
    
    /**
     * @return La lista de todos los envios en la base de datos
     */
    public List<EnvioEntity> findAll()
    {
        LOGGER.info("consultando todos los envios");
        TypedQuery query= em.createQuery("select u from EnvioEntity u", EnvioEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity el envio que se se va a actualizar
     * @return el envio actualizado.
     */
    public EnvioEntity update(EnvioEntity entity)
    {
       LOGGER.info("Modificando envio con id " + entity.getId());
       return em.merge(entity);
    }
    
    /**
     * @param id la ID del envio que se desea eliminar
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando el Envio de id={0}", id);
        EnvioEntity entity = em.find(EnvioEntity.class, id);
        em.remove(entity);       
    }
}