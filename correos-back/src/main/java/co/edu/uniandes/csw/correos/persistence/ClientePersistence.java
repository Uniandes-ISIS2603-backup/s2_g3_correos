/*
MIT License
Copyright (c) 2017 ISIS2603
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.correos.persistence;

import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author da.leon
 */
@Stateless
public class ClientePersistence {
    
    private static final Logger LOGGER= Logger.getLogger(ClientePersistence.class.getName());
    
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    
    /**
     *
     * @param entity objeto Cliente que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ClienteEntity create(ClienteEntity entity)
    {
        LOGGER.info("Se inicia la creación de un Cliente");
        em.persist(entity);
        LOGGER.info("Se creó el Cliente");
        return entity;
    }
    
    /**
     * @param id el id del Cliente existente que se esta buscando
     * @return el Cliente buscado
     */
    public ClienteEntity find(long id)
    {
        return em.find(ClienteEntity.class, id);
    }
    
     /**
     * Busca si hay alguna Cliente con el nombre que se envía de argumento
     *
     * @param name: Nombre de la Cliente que se está buscando
     * @return null si no existe ningun Cliente con el nombre del argumento. Si
     * existe alguno devuelve el primero.
     */
    public ClienteEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando Cliente por nombre ", name);

        // Se crea un query para buscar Clientees con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.name = :name", ClienteEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<ClienteEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
    /**
     * @return La lista de todos los Clientes en la base de datos
     */
    public List<ClienteEntity> findAll()
    {
        LOGGER.info("consultando todos los Clientes");
        TypedQuery query= em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity el Cliente que se se va a actualizar
     * @return el Cliente actualizado
     */
    public ClienteEntity update(ClienteEntity entity)
    {
       return em.merge(entity);
    }
    
    /**
     * @param entity el Cliente que se desea eliminar
     */
    public void delete(ClienteEntity entity)
    {
        em.remove(entity);
    }
}