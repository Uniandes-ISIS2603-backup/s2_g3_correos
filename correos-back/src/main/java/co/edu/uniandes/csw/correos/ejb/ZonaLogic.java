/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.ZonaPersistence;
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
public class ZonaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ZonaLogic.class.getName());

    @Inject
    private ZonaPersistence zP;
    
    
    public ZonaEntity createZona(ZonaEntity Zona) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de creación de la Zona");
        // Verifica la regla de negocio que dice que una zona siempre debe tener la latitud entre 90 y -90
        if (Zona.getLatitud()<90 &&Zona.getLatitud()>-90 ) {
            throw new BusinessLogicException("La zona debe tener  una latitud en el rango \"" + Zona.getLatitud() + "\"");
        }
        else if (Zona.getLongitud()<90 && Zona.getLongitud()>-90 ) {
            throw new BusinessLogicException("La zona debe tener  una longitud en el rango \"" + Zona.getLongitud() + "\"");
        }
        
        
        // Invoca la persistencia para crear la Zona
        zP.create(Zona);
        LOGGER.info("Termina proceso de creación de Zona");
        return Zona;
        
    }
    public List<ZonaEntity> getZonas() {
        LOGGER.info("Inicia proceso de consultar todas las Zonas");
        List<ZonaEntity> Zonas = zP.findAll();
        LOGGER.info("Termina proceso de consultar todas las Zonas");
        return Zonas;
    }
    
    public ZonaEntity getZona(Long id) {
        return zP.find(id);
    }
    public ZonaEntity updateZona(ZonaEntity Zona) throws BusinessLogicException  {
         if (Zona.getLatitud()<90 &&Zona.getLatitud()>-90 ) {
            throw new BusinessLogicException("La zona debe tener  una latitud en el rango  \"" + Zona.getLatitud() + "\"");
        }
        else if (Zona.getLongitud()<90 && Zona.getLongitud()>-90 ) {
            throw new BusinessLogicException("La zona debe tener  una longitud en el rango \"" + Zona.getLongitud() + "\"");
        }
        return zP.update(Zona);
    }
    
     public void deleteZona(ZonaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la zona", entity.getId());    
        zP.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso la zona", entity.getId());
    }
    
    
}
