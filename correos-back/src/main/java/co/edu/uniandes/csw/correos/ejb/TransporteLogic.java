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

import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.persistence.TransportePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author l.mejia
 */
@Stateless
public class TransporteLogic {
    /**
     * logger
     */
      private static final Logger LOGGER= Logger.getLogger(TransporteLogic.class.getName());
    
      /**
       * persistencia
       */
    private TransportePersistence persistence;
    
    /**
     * constructor con parametros
     * @param persistence 
     */
    @Inject
    public TransporteLogic(TransportePersistence persistence)
    {
        this.persistence=persistence;
    }
    
    /**
     * constructor vacio
     */
    public TransporteLogic()
    {
        this.persistence=null;
    }
    
    /**
     * 
     * @param transporte
     * @return el nuevo transporte
     */
    public TransporteEntity createTransporte(TransporteEntity transporte)
    {
        LOGGER.info("Se inicia la creación de un Transporte");
        
        persistence.create(transporte);
        LOGGER.info("se termino de crear un transporte");
        return transporte;
    }
    
    /**
     * 
     * @return todos los transportes
     */
    public List<TransporteEntity> getTransportes()
    {
        LOGGER.info("Se inicia la consulta de todos los transportes");
        List<TransporteEntity> retorno=persistence.findAll();
        LOGGER.info("Se retornaron todos los transportes");
        return retorno;
    }
    
    /**
     * 
     * @param id
     * @return el transporte con id por param
     */
    public TransporteEntity getTransporte(Long id)
    {
        return persistence.find(id);
    }
    
    /**
     * 
     * @param transporte
     * @return el transporte actualizado
     */
    public TransporteEntity putTransporte(TransporteEntity transporte)
    {
        return persistence.update(transporte);
    }
    
    /**
     * borra el transporte por param
     * @param transporte 
     */
    public void deleteTransporte(TransporteEntity transporte)
    {
        LOGGER.log(Level.INFO,"se elimina el transporte con el id={0}",transporte.getId());
        persistence.delete(transporte.getId());
        LOGGER.log(Level.INFO,"se eliminó el transporte con el id={0}",transporte.getId());
    }
}
