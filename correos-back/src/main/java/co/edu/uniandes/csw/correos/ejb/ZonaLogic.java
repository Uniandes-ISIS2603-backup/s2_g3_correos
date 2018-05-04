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

    
    private ZonaPersistence zP;
    
    @Inject
    public ZonaLogic(ZonaPersistence zP)
    {
        this.zP=zP;
    }
    
    public ZonaLogic()
    {
        this.zP=null;
    }
    
    public ZonaEntity createZona(ZonaEntity zona) throws BusinessLogicException{
        LOGGER.info("Inicia proceso de creación de la Zona");
        // Verifica la regla de negocio que dice que una zona siempre debe tener la latitud entre 90 y -90
        if (zona.getLatitud()>90.0 &&zona.getLatitud()<-90.0 ) {
            throw new BusinessLogicException("La zona debe tener  una latitud en el rango \"" + zona.getLatitud() + "\"");
        }
        else if (zona.getLongitud()>90.0 && zona.getLongitud()<-90.0 ) {
            throw new BusinessLogicException("La zona debe tener  una longitud en el rango \"" + zona.getLongitud() + "\"");
        }
        
        
        // Invoca la persistencia para crear la Zona
        zP.create(zona);
        LOGGER.info("Termina proceso de creación de Zona");
        return zona;
        
    }
    public List<ZonaEntity> getZonas() {
        LOGGER.info("Inicia proceso de consultar todas las Zonas");
        List<ZonaEntity> zonas = zP.findAll();
        LOGGER.info("Termina proceso de consultar todas las Zonas");
        return zonas;
    }
    
    public ZonaEntity getZona(Long id) {
        return zP.find(id);
    }
    public ZonaEntity updateZona(ZonaEntity zona) throws BusinessLogicException  {
         if (zona.getLatitud()>90 &&zona.getLatitud()<-90 ) {
            throw new BusinessLogicException("La zona debe tener  una latitud en el rango  \"" + zona.getLatitud() + "\"");
        }
        else if (zona.getLongitud()>90 && zona.getLongitud()<-90 ) {
            throw new BusinessLogicException("La zona debe tener  una longitud en el rango \"" + zona.getLongitud() + "\"");
        }
        return zP.update(zona);
    }
    
     public void deleteZona(ZonaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la zona", entity.getId());    
        zP.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso la zona", entity.getId());
    }
    
    
}
