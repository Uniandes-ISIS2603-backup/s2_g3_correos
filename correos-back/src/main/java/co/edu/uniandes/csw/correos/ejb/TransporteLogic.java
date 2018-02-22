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
      private static final Logger LOGGER= Logger.getLogger(TransporteLogic.class.getName());
    
    private TransportePersistence persistence;
    
    @Inject
    public TransporteLogic(TransportePersistence persistence)
    {
        this.persistence=persistence;
    }
    
    public TransporteLogic()
    {
        this.persistence=null;
    }
    
    public TransporteEntity createMensjaero(TransporteEntity transporte)
    {
        LOGGER.info("Se inicia la creación de un Transporte");
        persistence.create(transporte);
        LOGGER.info("se termino de crear un transporte");
        return transporte;
    }
    
    public List<TransporteEntity> getTransportes()
    {
        LOGGER.info("Se inicia la consulta de todos los transportes");
        List<TransporteEntity> retorno=persistence.findAll();
        LOGGER.info("Se retornaron todos los transportes");
        return retorno;
    }
    
    public TransporteEntity getTransporte(Long id)
    {
        return persistence.find(id);
    }
    
    public TransporteEntity putTransporte(TransporteEntity transporte)
    {
        return persistence.update(transporte);
    }
    
    public void deleteTransporte(TransporteEntity transporte)
    {
        LOGGER.log(Level.INFO,"se elimina el transporte con el id={0}",transporte.getId());
        persistence.delete(transporte);
        LOGGER.log(Level.INFO,"se eliminó el transporte con el id={0}",transporte.getId());
    }
}
