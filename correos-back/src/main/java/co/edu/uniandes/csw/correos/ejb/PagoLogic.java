/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.entities.PagoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @pago a.silvag
 */
@Stateless
public class PagoLogic {
     private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());

    @Inject
    private PagoPersistence persistence;
    

    @Inject
    private CuentaBancariaLogic cuentaBancariaLogic;

    /**
     * Obtiene la lista de los registros de Pago.
     *
     * @return Colección de objetos de PagoEntity.
     */
    public List<PagoEntity> getPagos(Long cuentaBancariaid) throws BusinessLogicException{
        LOGGER.info( "Inicia proceso de consultar todos los pagos");
        CuentaBancariaEntity cuentaBancaria = cuentaBancariaLogic.getCuentaBancaria(cuentaBancariaid);
        if(cuentaBancaria.getPagos() == null){
            throw new BusinessLogicException("la cuenta que se consulta no tiene pagos");
        }
        if(cuentaBancaria.getPagos().isEmpty()){
            throw new BusinessLogicException("la cuenta que se consulta no tiene pagos");
        }
        return cuentaBancaria.getPagos();
    }

    /**
     * Obtiene los datos de una instancia de Pago a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de PagoEntity con los datos del Pago consultado.
     */
    public PagoEntity getPago(Long pagoId) {
        
        return persistence.find(pagoId);
    }

    /**
     * Se encarga de crear un Pago en la base de datos.
     *
     * @param entity Objeto de PagoEntity con los datos nuevos
     * @return Objeto de PagoEntity con los datos nuevos y su ID.
     */
    public PagoEntity createPago(Long id, PagoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de crear un pago ");
        CuentaBancariaEntity cuentaBancaria = cuentaBancariaLogic.getCuentaBancaria(id);
        if(entity.getValor()<0.0){
            throw new BusinessLogicException("UUUUUY que paso aca, no les vamos a regalar plata. No se puede tener un valor menor a cero");
        }
        if(entity.getCuentaBancaria()!=cuentaBancaria){
            throw new BusinessLogicException("Esta plata debe ir para alguien");
        }
        if(entity.getTarjetaCredito()==null){
            throw new BusinessLogicException("Paila mi pez, hay que cobrarle esto a alguien");
        }
        return persistence.create(entity);
    }

    /**
     * Actualiza la información de una instancia de Pago.
     *
     * @param entity Instancia de PagoEntity con los nuevos datos.
     * @return Instancia de PagoEntity con los datos actualizados.
     */
    public PagoEntity updatePago(PagoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un pago ");
        if(entity.getValor()<0.0){
            throw new BusinessLogicException("UUUUUY que paso aca, no les vamos a regalar plata. No se puede tener un valor menor a cero");
        }
        if(entity.getCuentaBancaria()==null){
            throw new BusinessLogicException("Esta plata debe ir para alguien");
        }
        if(entity.getTarjetaCredito()==null){
            throw new BusinessLogicException("Paila mi pez, hay que cobrarle esto a alguien");
        }
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Pago de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deletePago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un pago ");
        persistence.delete(id);
    }
}
