/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.entities.PagoEntity;
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
    
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(CuentaBancariaLogic.class.getName());
    
    /**
     * relacion con la persistencia
     */
    private CuentaBancariaPersistence persistence;
    
    /**
     * relacion con el pago
     */ 
    private PagoLogic pagoLogic;
    
    /**
     * realacion con la logica
     * @param cbp
     * @param pL 
     */
    @Inject
    public CuentaBancariaLogic(CuentaBancariaPersistence cbp,PagoLogic pL)
    {
        this.persistence=cbp;
        this.pagoLogic=pL;
    }
    
    /**
     * constructor
     */
    public CuentaBancariaLogic()
    {
        this.persistence=null;
        this.pagoLogic=null;
    }
    
    /**
     * da todas las cuentas bancarias
     */ 
    public List<CuentaBancariaEntity> getCuentasBancarias(){
        
        return persistence.findAll();
    }
    
    
    /**
     * 
     * @param id
     * @return la cuenta bancaria con id por para,
     */
    public CuentaBancariaEntity getCuentaBancaria(Long id){
        
        return persistence.find(id);
    }
    
    /**
     * 
     * @param entity
     * @return la nueva cuenta bancaria
     * @throws BusinessLogicException 
     */
    public CuentaBancariaEntity createCuentaBancaria(CuentaBancariaEntity entity) throws BusinessLogicException{
            
        
        if(entity.getNumero().length()<10){
            throw new BusinessLogicException("Se necesitan 10 digitos caballero"+ entity.getNumero()+"length"+entity.getNumero().length());
        
        }
                    LOGGER.info("llego");

        if(!entity.getNumero().matches("[0-9]+")){
            throw new BusinessLogicException("Numeros no letras");
        }
        persistence.create(entity);
        return entity;
    }
    
    
    /**
     * 
     * @param entity
     * @return la cuenta bacaria actualizada
     * @throws BusinessLogicException 
     */
    public CuentaBancariaEntity updateCuentaBancaria(CuentaBancariaEntity entity) throws BusinessLogicException{
       
        
        if(entity.getNumero().length()<10){
            throw new BusinessLogicException("Se necesitan 10 digitos caballero" + entity.getNumero()+"length"+entity.getNumero().length());
        }
        if(!entity.getNumero().matches("[0-9]+")){
            throw new BusinessLogicException("Numeros no letras");
        }
        return persistence.update(entity);
    }
    
    /**
     * borra la cuenta bancaria con id por param
     * @param id 
     */
    public void deleteCuentaBancaria(Long id){
        
        persistence.delete(id);
        
    }
    
    /**
     * se agraga pago a cuenta bancaria
     * @param id
     * @param pago 
     */
        public void agregarPago(Long id, PagoEntity pago)
    {
        CuentaBancariaEntity agregar= persistence.find(id);
        List <PagoEntity> lista=agregar.getPagos();
        lista.add(pago);
        agregar.setPagos(lista);
        persistence.update(agregar);
    }
        
        /**
         * se borra pago de cuenta bancaria
         * @param cuentaBancaria
         * @param pago
         * @throws BusinessLogicException 
         */
        public void deletePago(Long cuentaBancaria, Long pago) throws BusinessLogicException
    {
        CuentaBancariaEntity cambiar= getCuentaBancaria(cuentaBancaria);
        List<PagoEntity> trans=cambiar.getPagos();
        for(int i=0; i<trans.size(); i++)
        {
            if(trans.get(i).getId().equals(pago))
            {
                trans.remove(i);
                break;
            }
        }
        cambiar.setPagos(trans);
        updateCuentaBancaria(cambiar);
    }
    
}
