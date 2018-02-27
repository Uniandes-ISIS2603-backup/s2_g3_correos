/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.CuentaBancariaPersistence;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.silvag
 */
@Stateless
public class CuentaBancariaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CuentaBancariaLogic.class.getName());
    
    @Inject
    private CuentaBancariaPersistence persistence;
    
    @Inject
    private CuentaBancariaLogic cuentaBancariaLogic;
    
    public List<CuentaBancariaEntity> getCuentasBancarias(){
        
        return persistence.findAll();
    }
    
    public CuentaBancariaEntity getCuentaBancaria(Long id){
        
        return persistence.find(id);
    }
    
    public CuentaBancariaEntity createCuentaBancaria(Long cuentaBancariaId, CuentaBancariaEntity entity) throws BusinessLogicException{
            
        if(persistence.findByName(entity.getName())!=null){
            throw new BusinessLogicException("Ya existe una cuenta bancaria con el nombre, por dios que esta pasando?");
        }
        persistence.create(entity);
        return entity;
    }
    
    public CuentaBancariaEntity updateCuentaBancaria(CuentaBancariaEntity entity){
        return persistence.update(entity);
    }
    
    public void deleteCuentaBancaria(Long id){
        
        persistence.delete(id);
        
    }
    
}
