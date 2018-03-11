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
    
    /**
     * Crar Califiacion, crea una calificacion
     * @param calificacion CalifiacionEntity
     * @return CalificacionEntity guardada en la base de datos
     * @throws BusinessLogicException si no se cumples las reglas de negocio
     */
    public CalificacionEntity createCalificacion(CalificacionEntity calificacion) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de creación de la Calificacion");
        // Verifica la regla de negocio que dice que una calificacion siempre debe tener un mensajero asociado
        
         // Verifica que la calificacion sea un numero entero de 1 a 5
        if(calificacion.getCalificacion()!=1 && calificacion.getCalificacion()!=2 && calificacion.getCalificacion()!=3 && calificacion.getCalificacion()!=4&& calificacion.getCalificacion()!=5 ){
            throw new BusinessLogicException("Calificacion fuera del rango \"" + calificacion.getCalificacion() + "\"");
        }
        // Invoca la persistencia para crear la Zona
        cP.create(calificacion);
        LOGGER.info("Termina proceso de creación de Zona");
        return calificacion;
        
    }
    /** 
     * Obtener Calificaciones
     * @return una lista con todas las calificaciones en la base de datos
     */
    public List<CalificacionEntity> getCalificaciones() {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
        List<CalificacionEntity> calificaciones = cP.findAll();
        LOGGER.info("Termina proceso de consultar todas las calificaciones");
        return calificaciones;
    }
    /**
     * Obtener Calificacion
     * @param id calificaicon a buscar
     * @return calificacion encontrada en la base de datos
     */
    public CalificacionEntity getCalificacion(Long id) {
        return cP.find(id);
    }
    /**
     * Actualizar Califiacion
     * @param entity calificacion a actualizar 
     * @return el entity de la calificacion actualizada
     * @throws BusinessLogicException 
     */
    public CalificacionEntity updateCalificacion(CalificacionEntity entity) throws BusinessLogicException  {
        if(entity.getMensajero()==null){
            
        }
            
        return cP.update(entity);
    }
    
    /**
     * Eliminar califiacion
     * @param entity calificacion a eliminar;
     * @throws BusinessLogicException 
     */
     public void deleteCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la calficacion", entity.getId());    
        cP.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar la calificaion", entity.getId());
    }
}
