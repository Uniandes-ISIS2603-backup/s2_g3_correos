/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EnvioPersistence;
import co.edu.uniandes.csw.correos.persistence.PaquetePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.rengifo
 */
@Stateless
public class PaqueteLogic {
    
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(PaqueteLogic.class.getName());

    /**
     * relacion con persistencia
     */
    private PaquetePersistence persistence;
    
    /**
     * relacion con envio
     */
    private EnvioPersistence pEnvio;
    
    /**
     * constructor con parametros
     * @param pP
     * @param eP 
     */
    @Inject
    public PaqueteLogic(PaquetePersistence pP, EnvioPersistence eP)
    {
        this.persistence=pP;
        this.pEnvio=eP;
    }
    
    /**
     * constructor vacio
     */
    public PaqueteLogic()
    {
        this.persistence=null;
        this.pEnvio=null;
    }
    
    /**
     * 
     * @param entity el paquete a ser creado
     * @return el paquete creado
     * @throws BusinessLogicException 
     */
    public PaqueteEntity createPaquete(PaqueteEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Se comienza a crear un Paquete"); 
        
        if((entity.getDimensionA()==0)||(entity.getDimensionB()==0)||(entity.getDimensionC()==0)){
            throw new BusinessLogicException("El volumen del paquete ha sido evaluado en 0.");
        }
        else if(entity.getPeso()<=0){
            throw new BusinessLogicException("El peso del paquete ha sido evaluado en 0.");
        }     
        
        persistence.create(entity);
        LOGGER.info("Se termina de crear un Paquete");
        return entity;        
    }

    /**
     * 
     * @return todos los paquetes del sistema
     * @throws BusinessLogicException 
     */
    public List<PaqueteEntity> getPaquetes() throws BusinessLogicException {
        LOGGER.info("Se comienzan a buscar todos los Paquetes");       
        List<PaqueteEntity> paquetes = persistence.findAll();
        
        if(paquetes.isEmpty())
        {
            throw new BusinessLogicException("No hay paquetes en el sistema.");
        } 
        
        LOGGER.info("Se terminan de buscar todos los Paquetes");
        return paquetes;
    }
    
    /**
     * 
     * @param id el id del paquete buscado
     * @return  el paquete buscado
     */
    public PaqueteEntity getPaquete(Long id, Long envioId) throws BusinessLogicException {
        EnvioEntity envio = pEnvio.find(envioId);
        boolean found = false;
        for (int i = 0 ;envio.getPaquetes().size()>i && !found;i++)
        {
            if(id.equals(envio.getPaquetes().get(i).getId()))
            {
                found = true;
            }
        }
        if (found)
        {
        return persistence.find(id);
        }
        else
        {
           throw new BusinessLogicException("No se encuentra el paquete en el sistema."); 
        }
    }
    
    public PaqueteEntity getPaqueteFull(Long id)
    {
        return persistence.find(id);
    }
    
    /**
     * 
     * @param entity el paquete a ser acutalizado
     * @return el paquete actualizado
     * @throws BusinessLogicException 
     */
    public PaqueteEntity updatePaquete(PaqueteEntity entity) throws BusinessLogicException  {
        
        LOGGER.log(Level.INFO, "Se comienza a actualizar un paquete");
        
        if((entity.getDimensionA()==0)||(entity.getDimensionB()==0)||(entity.getDimensionC()==0)){
            throw new BusinessLogicException("El volumen del paquete ha sido evaluado en 0.");
        }
        if(entity.getPeso()<=0){
            throw new BusinessLogicException("El peso del paquete ha sido evaluado en 0.");
        }   
        
        return persistence.update(entity);
    }
    
    /**
     * 
     * @param id el ID del pquete a ser eliminado
     */
    public void deletePaquete(Long id){
        LOGGER.log(Level.INFO, "Comienza a borrar el paquete de id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina a borrar el paquete de id={0}", id);
    } 
    
    /**
     * 
     * @param id el ID del paquete al que se le va a anadir el nuevo detalle
     * @param detalle el detalle a ser anadido
     */
    public void agregarDetallePaquete(Long id, DetallePaqueteEntity detalle)
    {
       PaqueteEntity paquete= persistence.find(id);;
       paquete.setDetalle(detalle);
       persistence.update(paquete);
    }
}

