/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.BonoEntity;
import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.BonoPersistance;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author t.vargas10
 */

@Stateless
public class BonoLogic {
    
    private static final Logger LOGGER= Logger.getLogger(BonoLogic.class.getName());
    
    @Inject
    private BonoPersistance persistence;
    
    @Inject
    private ClienteLogic clienteLogic;
    
    public BonoLogic (BonoPersistance persistence)
    {
        this.persistence=persistence;
    }
    
    public BonoLogic()

    {
        this.persistence=null;
    }
    
    /**
     * Se encarga de crear un bono en la base de datos.
     *
     * @param entity Objeto de BonoEntity con los datos nuevos
     * @param Clienteid id del cliente el cual sera padre del nuevo bono.
     * @return Objeto de BonoEntity con los datos nuevos y su ID.
     * 
     */
    public BonoEntity createBono(Long Clienteid, BonoEntity entity) {
        LOGGER.info("Inicia proceso de crear bono");
        ClienteEntity cliente = clienteLogic.getCliente(Clienteid);
        entity.setCliente(cliente);
        return persistence.create(entity);
    }
    
    
        public List<BonoEntity> getBonos() {
        LOGGER.info("Inicia proceso de consultar todos los bonos");
        List<BonoEntity> bonos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar toos los bonos");
        return bonos;
    }
        
        public BonoEntity getBono(Long id) {
        return persistence.find(id);
    }
        
        public BonoEntity updateBono(BonoEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) != null) {
            throw new BusinessLogicException("Ya existe un Bono con el id \"" + entity.getId() + "\"");
        }
        return persistence.update(entity);
    }
        
         public void deleteBono(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el bono con id={0}");    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar bono con id={0}");
    }
}
