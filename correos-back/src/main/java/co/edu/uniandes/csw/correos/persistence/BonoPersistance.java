/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.BonoEntity;
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
public class BonoPersistance {
    
      private static final Logger LOGGER = Logger.getLogger(BonoPersistance.class.getName());
      
      @PersistenceContext(unitName = "CorreosPU")
      protected EntityManager em;
      
      /**
       * Encuentra el bono con el id dado
       * @param id id del bono
       * @return bono con el id ingresado
       */
      public BonoEntity find(Long id)
      {
        LOGGER.log(Level.INFO, "Consultando bono con id={0}", id);
        return em.find(BonoEntity.class, id);
      }
      
      /**
       * Encuentra todos los bonos existentes
       * @return lista de los bonos
       */
      public List<BonoEntity> findAll() {
        LOGGER.info("Consultando todos los bonos");
        Query q = em.createQuery("select u from BonoEntity u");
        return q.getResultList();
    }
      
      /**
       * Crea un nuevo bono
       * @param entity bono a crear
       * @return bono ya creado
       */
      public BonoEntity create(BonoEntity entity) {
        LOGGER.info("Creando un bono nuevo");
        em.persist(entity);
        LOGGER.info("bono creado");
        return entity;
    }

      /**
       * Actualiza el bono identificado con id ingresado
       * @param entity Bono a actualizar
       * @return Bono actualizado
       */
    public BonoEntity update(BonoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando bono con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Elimina el bono con el id ingresado
     * @param id id del bono a eliminar
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando employee con id={0}", id);
        BonoEntity entity = em.find(BonoEntity.class, id);
        em.remove(entity);
    }
}
