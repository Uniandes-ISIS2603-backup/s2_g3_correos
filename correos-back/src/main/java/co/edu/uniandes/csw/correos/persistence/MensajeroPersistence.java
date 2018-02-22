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

import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
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
public class MensajeroPersistence {
    
    private static final Logger LOGGER= Logger.getLogger(MensajeroPersistence.class.getName());
    
    @PersistenceContext(unitName="CorreosPU")
    protected EntityManager em;
    
    
    /**
     *
     * @param entity objeto Mensajero que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MensajeroEntity create(MensajeroEntity entity)
    {
        LOGGER.info("Se inicia la creación de un Mensajero");
        em.persist(entity);
        LOGGER.info("Se creó el mensajero");
        return entity;
    }
    
    /**
     * @param id el id del mensajero existente que se esta buscando
     * @return el mensajero buscado
     */
    public MensajeroEntity find(long id)
    {
        return em.find(MensajeroEntity.class, id);
    }
    
    /**
     * @return La lista de todos los mensajeros en la base de datos
     */
    public List<MensajeroEntity> findAll()
    {
        LOGGER.info("consultando todos los mensajeros");
        TypedQuery query= em.createQuery("select u from MensajeroEntity u", MensajeroEntity.class);
        return query.getResultList();
    }
    
    /**
     * @param entity el mensajero que se se va a actualizar
     * @return el mensajero actualizado
     */
    public MensajeroEntity update(MensajeroEntity entity)
    {
       return em.merge(entity);
    }
    
    /**
     * @param entity el mensajero que se desea eliminar
     */
    public void delete(MensajeroEntity entity)
    {
        em.remove(entity);
    }
}
