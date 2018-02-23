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
import co.edu.uniandes.csw.correos.persistence.ReservaPersistence;
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
      private static final Logger LOGGER= Logger.getLogger(ReservaLogic.class.getName());
    
    private ReservaPersistence persistence;
    
    @Inject
    public ReservaLogic(ReservaPersistence persistence)
    {
        this.persistence=persistence;
    }
    
    public ReservaLogic()
    {
        this.persistence=null;
    }
    
    public ReservaEntity createMensjaero(ReservaEntity reserva)
    {
        LOGGER.info("Se inicia la creación de un Reserva");
        persistence.create(reserva);
        LOGGER.info("se termino de crear un reserva");
        return reserva;
    }
    
    public List<ReservaEntity> getReservas()
    {
        LOGGER.info("Se inicia la consulta de todos los reservas");
        List<ReservaEntity> retorno=persistence.findAll();
        LOGGER.info("Se retornaron todos los reservas");
        return retorno;
    }
    
    public ReservaEntity getReserva(Long id)
    {
        return persistence.find(id);
    }
    
    public ReservaEntity putReserva(ReservaEntity reserva)
    {
        return persistence.update(reserva);
    }
    
    public void deleteReserva(ReservaEntity reserva)
    {
        LOGGER.log(Level.INFO,"se elimina el reserva con el id={0}",reserva.getId());
        persistence.delete(reserva);
        LOGGER.log(Level.INFO,"se eliminó el reserva con el id={0}",reserva.getId());
    }
}
