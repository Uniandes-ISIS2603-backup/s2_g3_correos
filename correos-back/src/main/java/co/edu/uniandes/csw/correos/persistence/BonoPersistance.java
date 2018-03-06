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
     * Buscar un bono
     * 
     * Busca si hay algun bono asociado a un cliente y con un ID específico
     * @param clienteid El ID del cliente con respecto al cual se busca
     * @param bonoid El ID del bono buscada
     * @return El bono encontrada o null. Nota: Si existe uno o más bonos 
     * devuelve siempre el primero que encuentra
     */
    public BonoEntity find(Long clienteid, Long bonoid) {
        TypedQuery<BonoEntity> q = em.createQuery("select p from BonoEntity p where (p.cliente.id = :bookid) and (p.id = :reviewid)", BonoEntity.class);
        q.setParameter("bookid", clienteid);
        q.setParameter("reviewid", bonoid);
        List<BonoEntity> results = q.getResultList();
        BonoEntity review = null;
        if (results == null) {
            review = null;
        } else if (results.isEmpty()) {
            review = null;
        } else if (results.size() >= 1) {
            review = results.get(0);
        }

        return review;
    }
      
      /**
       * Encuentra todos los bonos existentes
       * @return lista de los bonos
       */
      public List<BonoEntity> findAll() {
        LOGGER.info("Consultando todos los bonos");
        Query q = em.createQuery("select u from BonoEntity u", BonoEntity.class);
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
