/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.ReservaEntity;
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
public class ReservaPersistence {
    
    private static final Logger LOGGER= Logger.getLogger(ReservaPersistence.class.getName());
    
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    
    /**
     *
     * @param entity objeto Reserva que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ReservaEntity create(ReservaEntity entity)
    {
        LOGGER.info("Se inicia la creación de un Reserva");
        em.persist(entity);
        LOGGER.info("Se creó el reserva");
        return entity;
    }
    
    /**
     * @param id el id de ña reserva existente que se esta buscando
     * @return la reserva buscada
     */
    public ReservaEntity find(long id)
    {
        return em.find(ReservaEntity.class, id);
    }
    
    /**
     * @return La lista de todos los reservas en la base de datos
     */
    public List<ReservaEntity> findAll()
    {
        LOGGER.info("consultando todas las reservas");
        TypedQuery query= em.createQuery("select u from ReservaEntity u", ReservaEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity la reserva que se se va a actualizar
     * @return la reserva actualizada
     */
    public ReservaEntity update(ReservaEntity entity)
    {
       return em.merge(entity);
    }
    
    /**
     * @param id la reserva que se desea eliminar
     */
    public void delete(Long id)
    {
        em.remove(em.find(ReservaEntity.class, id));
    }
}
