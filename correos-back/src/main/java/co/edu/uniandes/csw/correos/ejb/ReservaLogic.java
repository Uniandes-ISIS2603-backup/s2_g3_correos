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

import co.edu.uniandes.csw.correos.entities.ReservaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.ReservaPersistence;
import java.util.Date;
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
public class ReservaLogic {
    /**
     * loggger
     */
      private static final Logger LOGGER= Logger.getLogger(ReservaLogic.class.getName());
    
      /**
       * persistecia
       */
    private ReservaPersistence persistence;
    
    /**
     * constructor con params
     * @param persistence 
     */
    @Inject
    public ReservaLogic(ReservaPersistence persistence)
    {
        this.persistence=persistence;
    }
    
    /**
     * constructor vacio
     */
    public ReservaLogic()
    {
        this.persistence=null;
    }
    
    /**
     * 
     * @param reserva
     * @return la reserva creada
     * @throws BusinessLogicException 
     */
    public ReservaEntity createReserva(ReservaEntity reserva) throws BusinessLogicException
    {
        LOGGER.info("Se inicia la creación de un Reserva");
        if(reserva.getFecha().before(new Date()))
            throw new BusinessLogicException("no se puede crear una reserva en el pasado");
        persistence.create(reserva);
        LOGGER.info("se termino de crear un reserva");
        return reserva;
    }
    
    /**
     * 
     * @return todas las reservas
     */
    public List<ReservaEntity> getReservas()
    {
        LOGGER.info("Se inicia la consulta de todos los reservas");
        List<ReservaEntity> retorno=persistence.findAll();
        LOGGER.info("Se retornaron todos los reservas");
        return retorno;
    }
    
    /**
     * 
     * @param id
     * @return la reserva con id por param
     */
    public ReservaEntity getReserva(Long id)
    {
        return persistence.find(id);
    }
    
    /**
     * 
     * @param reserva
     * @return la reserva actualizada
     * @throws BusinessLogicException 
     */
    public ReservaEntity putReserva(ReservaEntity reserva) throws BusinessLogicException
    {
        if(reserva.getFecha().before(new Date()))
            throw new BusinessLogicException("no se puede crear una reserva en el pasado");
        return persistence.update(reserva);
    }
    
    /**
     * borra la reserva por id
     * @param reserva 
     */
    public void deleteReserva(ReservaEntity reserva)
    {
        LOGGER.log(Level.INFO,"se elimina el reserva con el id={0}",reserva.getId());
        persistence.delete(reserva.getId());
        LOGGER.log(Level.INFO,"se eliminó el reserva con el id={0}",reserva.getId());
    }
    
    public void convertirAReserva (ReservaEntity reseva)
    {
      
        
    }
}
