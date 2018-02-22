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

import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
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
public class MensajeroLogic {
    
    private static final Logger LOGGER= Logger.getLogger(MensajeroLogic.class.getName());
    
    private MensajeroPersistence persistence;
    
    @Inject
    public MensajeroLogic(MensajeroPersistence persistence)
    {
        this.persistence=persistence;
    }
    
    public MensajeroLogic()
    {
        this.persistence=null;
    }
    
    public MensajeroEntity createMensjaero(MensajeroEntity mensajero)
    {
        LOGGER.info("Se inicia la creación de un Mensajero");
        persistence.create(mensajero);
        LOGGER.info("se termino de crear un mensajero");
        return mensajero;
    }
    
    public List<MensajeroEntity> getMensajeros()
    {
        LOGGER.info("Se inicia la consulta de todos los mensajeros");
        List<MensajeroEntity> retorno=persistence.findAll();
        LOGGER.info("Se retornaron todos los mensajeros");
        return retorno;
    }
    
    public MensajeroEntity getMensajero(Long id)
    {
        return persistence.find(id);
    }
    
    public MensajeroEntity putMensajero(MensajeroEntity mensajero)
    {
        return persistence.update(mensajero);
    }
    
    public void deleteMensajero(MensajeroEntity mensajero)
    {
        LOGGER.log(Level.INFO,"se elimina el mensajero con el id={0}",mensajero.getId());
        persistence.delete(mensajero);
        LOGGER.log(Level.INFO,"se eliminó el mensajero con el id={0}",mensajero.getId());
    }
    
}
