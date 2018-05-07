/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
import co.edu.uniandes.csw.correos.persistence.ZonaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author l.mejia
 */
public class ZonaMensajeroLogic {
    
    /**
     * persistencia zona
     */
    ZonaPersistence zonaPersistence;
    
    /**
     * persistencia mensajero
     */
    MensajeroPersistence mesnajeroPersistence;
    
    /**
     * logica zona
     */
    ZonaLogic zonaLogic;
    
    /**
     * logica mensajero
     */
    MensajeroLogic mensajeroLogic;
    
    /**
     * constructor con parametros
     * @param zonaPersistence
     * @param mensajeroPersistence
     * @param zonaLogic
     * @param mensajeoLogic 
     */
    @Inject
    public ZonaMensajeroLogic(ZonaPersistence zonaPersistence, MensajeroPersistence mensajeroPersistence, ZonaLogic zonaLogic, MensajeroLogic mensajeoLogic)
    {
        this.zonaPersistence=zonaPersistence;
        this.mesnajeroPersistence=mensajeroPersistence;
        
        this.mensajeroLogic=mensajeoLogic;
        this.zonaLogic=zonaLogic;
    }
    
    /**
     * constructor
     */
    public ZonaMensajeroLogic()
    {
        zonaPersistence=null;
        zonaLogic=null;
        
        mesnajeroPersistence=null;
        mensajeroLogic=null;
    }
    
    /**
     * vincula mensajero con zona
     * @param mensajero
     * @param zona 
     */
    public void agregarRelacion(MensajeroEntity mensajero, ZonaEntity zona)
    {
        MensajeroEntity mensajeroAgregar=mensajeroLogic.getMensajero(mensajero.getId());
        ZonaEntity zonaAgregar= zonaLogic.getZona(zona.getId());
        
        if(mensajeroAgregar!=null && zonaAgregar!=null)
        {
            List<ZonaEntity> zonas=mensajeroAgregar.getZonas();
            zonas.add(zona);
            mensajeroAgregar.setZonas(zonas);
            List<MensajeroEntity> mensajeros=zonaAgregar.getMensajeros();
            mensajeros.add(mensajero);
            zonaAgregar.setMensajeros(mensajeros);
            mesnajeroPersistence.update(mensajeroAgregar);
            zonaPersistence.update(zonaAgregar);
        }
    }
    
}
