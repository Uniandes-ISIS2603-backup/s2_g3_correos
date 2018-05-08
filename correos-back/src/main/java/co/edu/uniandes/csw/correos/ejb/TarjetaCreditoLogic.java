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
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.TarjetaCreditoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author da.leon
 */
@Stateless
public class TarjetaCreditoLogic {

    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());
    
    /**
     * // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
     */
    private TarjetaCreditoPersistence persistence; 
    
    /**
     * constructor con parametros
     * @param tP 
     */
    @Inject
    public TarjetaCreditoLogic(TarjetaCreditoPersistence tP)
    {
        this.persistence=tP;
    }
    
    /**
     * constructor vacio
     */
    public TarjetaCreditoLogic()
    {
        this.persistence=null;
    }
    
    /**
     * 
     * @param entity
     * @returnla nueva tarjeta de credito
     * @throws BusinessLogicException 
     */
    public TarjetaCreditoEntity createTarjetaCredito(TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de la tarjeta de credito");
        // Verifica la regla de negocio que dice que no puede haber dos tarjetas repetidas
        // Invoca la persistencia para crear la tarjeta
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de la tarjeta");
        return entity;
    }

    /**
     * 
     * @return todas las tarjetas de credito
     */
    public List<TarjetaCreditoEntity> getTarjetasCredito() {
        LOGGER.info("Inicia proceso de consultar todas las tarjetas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<TarjetaCreditoEntity> tarjetas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las tarjetas");
        return tarjetas;
    }

    /**
     * 
     * @param id
     * @return la tarjeta de credito por id
     */
    public TarjetaCreditoEntity getTarjetaCredito(Long id) {
        return persistence.find(id);
    }

    /**
     * 
     * @param entity
     * @return la tarjeta de credito actualizada
     * @throws BusinessLogicException 
     */
    public TarjetaCreditoEntity updateTarjetaCredito(TarjetaCreditoEntity entity) throws BusinessLogicException  {

        return persistence.update(entity);
    }
    
    /**
     * borra la tarjeta de credito por id
     * @param id
     * @throws BusinessLogicException 
     */
    public void deleteTarjetaCredito(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la tarjeta de credito con id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la tarjeta de credito con id={0}", id);
    }
}
