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
    
    
       public List<BonoEntity> getBonos(Long clienteid) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todos los bonos");
        ClienteEntity cliente = clienteLogic.getCliente(clienteid);
        if (cliente.getBonos()== null) {
            throw new BusinessLogicException("El libro que consulta aún no tiene reviews");
        }
        if (cliente.getBonos().isEmpty()) {
            throw new BusinessLogicException("El libro que consulta aún no tiene reviews");
        }
        return cliente.getBonos();
    }
        
     /**
     * Obtiene los datos de una instancia de Bono a partir de su ID.
     * La existencia del elemento padre Cliente se debe garantizar.
     *
     * @param clienteid El id del Cliente buscado
     * @param bonoid Identificador de la Bono a consultar
     * @return Instancia de BonoEntity con los datos del Bono consultado.
     * 
     */
    public BonoEntity getBono(Long clienteid, Long bonoid) {
        return persistence.find(bonoid);
    }
        
       /**
     * Actualiza la información de una instancia de bono.
     *
     * @param entity Instancia de BonoEntity con los nuevos datos.
     * @param clienteid id del Cliente el cual sera padre del Bono actualizado.
     * @return Instancia de BonoEntity con los datos actualizados.
     * 
     */
    public BonoEntity updateBono(Long clienteid, BonoEntity entity) {
        LOGGER.info("Inicia proceso de actualizar bono");
        ClienteEntity cliente = clienteLogic.getCliente(clienteid);
        entity.setCliente(cliente);
        return persistence.update(entity);
    }
        
        /**
     * Elimina una instancia de bono de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param clienteid id del cliente el cual es padre del bono.
     * 
     */
    public void deleteBono(Long clienteid, Long id) {
        LOGGER.info("Inicia proceso de borrar bono");
        BonoEntity old = getBono(clienteid, id);
        persistence.delete(old.getId());
    }
}
