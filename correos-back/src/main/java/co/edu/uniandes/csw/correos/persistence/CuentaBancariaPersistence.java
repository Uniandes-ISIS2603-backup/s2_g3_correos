/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author a.silvag
 */
@Stateless
public class CuentaBancariaPersistence {
        private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(CuentaBancariaPersistence.class.getName());

    @PersistenceContext(unitName = "CorreosPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto cuentaBancaria que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CuentaBancariaEntity create(CuentaBancariaEntity entity) {
        LOGGER.info("Creando una cuentaBancaria nueva");
        em.persist(entity);
        LOGGER.info("Creando una cuentaBancaria nueva");
        return entity;
    }

    /**
     * Busca si hay alguna cuentaBancaria con el nombre que se envía de argumento
     *
     * @param name: Nombre de la cuentaBancaria que se está buscando
     * @return null si no existe ninguna cuentaBancaria con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public CuentaBancariaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando cuentaBancaria por nombre ", name);

        // Se crea un query para buscar cuentaBancariaes con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From CuentaBancariaEntity e where e.name = :name", CuentaBancariaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<CuentaBancariaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    /**
     * 
     * @return todas las cuentas bancarias
     */
    public List<CuentaBancariaEntity> findAll() {
        LOGGER.info("Consultando todas las cuentasBancarias");
        TypedQuery query = em.createQuery("select u from CuentaBancariaEntity u", CuentaBancariaEntity.class);
        return query.getResultList();
    }

    /**
     * 
     * @param id
     * @return la cuenta bancaria con id por param
     */
    public CuentaBancariaEntity find(Long id) {
        return em.find(CuentaBancariaEntity.class, id);
    }

    /**
     * 
     * @param entity
     * @return la cuenta bancaria actualizada
     */
    public CuentaBancariaEntity update(CuentaBancariaEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * barra la cuenta bancaria con id por param
     * @param id 
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando cuenta bancaria con id={0}", id);
        CuentaBancariaEntity entity = em.find(CuentaBancariaEntity.class, id);
        em.remove(entity);
    }
}
