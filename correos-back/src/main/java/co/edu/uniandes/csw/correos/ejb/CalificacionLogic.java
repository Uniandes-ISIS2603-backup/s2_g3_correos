/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ed.diaz11
 */
@Stateless
public class CalificacionLogic {
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());

    @Inject
    private CalificacionPersistence cP;
    
    
    public CalificacionEntity createCalificacion(CalificacionEntity calificacion) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de creación de la Calificacion");
        // Verifica la regla de negocio que dice que una calificacion siempre debe tener un mensajero asociado
        if (calificacion.getMensajero()== null) {
            throw new BusinessLogicException("La calificacion debe tener un mensajero \"" + calificacion.getCalificacion() + "\"");
        }
         // Verifica que la calificacion sea un numero entero de 1 a 5
        else if(calificacion.getCalificacion()!=1 && calificacion.getCalificacion()!=2 && calificacion.getCalificacion()!=3 && calificacion.getCalificacion()!=4&& calificacion.getCalificacion()!=5 ){
            throw new BusinessLogicException("Calificacion fuera del rango \"" + calificacion.getCalificacion() + "\"");
        }
        // Invoca la persistencia para crear la city
        cP.create(calificacion);
        LOGGER.info("Termina proceso de creación de city");
        return calificacion;
        
    }
    public List<CalificacionEntity> getCalificaciones() {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
        List<CalificacionEntity> calificaciones = cP.findAll();
        LOGGER.info("Termina proceso de consultar todas las calificaciones");
        return calificaciones;
    }
    
    public CalificacionEntity getCalificacion(Long id) {
        return cP.find(id);
    }
    public CalificacionEntity updateCity(CalificacionEntity entity) throws BusinessLogicException  {
        if (entity.getMensajero()==null) {
            throw new BusinessLogicException("El mensajero no puede ser nulo \"" + entity.getName() + "\"");
        }
        return cP.update(entity);
    }
    
     public void deleteCity(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar ciudad con id={0}", entity.getId());    
        cP.delete(entity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar libro con id={0}", entity.getId());
    }
}
