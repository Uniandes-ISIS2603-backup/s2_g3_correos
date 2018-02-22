/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
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
public class EnvioPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(EnvioPersistence.class.getName());
    
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
        LOGGER.info("Se creó el envio");
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
       return em.merge(entity);
    }
    
    /**
     * @param entity el envio que se desea eliminar
     */
    public void delete(EnvioEntity entity)
    {
        em.remove(entity);
    }
}