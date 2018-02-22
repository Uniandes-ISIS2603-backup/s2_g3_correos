/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author l.mejia
 */
@Stateless
public class TransportePersistence {
    private static final Logger LOGGER= Logger.getLogger(TransportePersistence.class.getName());
    
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    
    /**
     *
     * @param entity objeto Transporte que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TransporteEntity create(TransporteEntity entity)
    {
        LOGGER.info("Se inicia la creación de un Transporte");
        em.persist(entity);
        LOGGER.info("Se creó el transporte");
        return entity;
    }
    
    /**
     * @param id el id del transporte existente que se esta buscando
     * @return el transporte buscado
     */
    public TransporteEntity find(long id)
    {
        return em.find(TransporteEntity.class, id);
    }
    
    /**
     * @return La lista de todos los transportes en la base de datos
     */
    public List<TransporteEntity> findAll()
    {
        LOGGER.info("consultando todos los transportes");
        TypedQuery query= em.createQuery("select u from TransporteEntity u", TransporteEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity el transporte que se se va a actualizar
     * @return el transporte actualizado
     */
    public TransporteEntity update(TransporteEntity entity)
    {
       return em.merge(entity);
    }
    
    /**
     * @param entity el transporte que se desea eliminar
     */
    public void delete(TransporteEntity entity)
    {
        em.remove(entity);
    }
}
