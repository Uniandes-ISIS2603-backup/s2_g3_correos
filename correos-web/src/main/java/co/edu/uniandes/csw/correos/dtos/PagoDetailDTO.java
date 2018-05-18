/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.PagoEntity;

/**
 *
 * @author a.silvag
 */
public class PagoDetailDTO extends PagoDTO {
    
    private CuentaBancariaDTO cuentaBancaria; // cuenta bancaria 
    private TarjetaCreditoDTO tarjetaDeCredito; // tarjeta de credito 
    
    /**
     * constructor por defecto
     */
    public PagoDetailDTO(){
             //Constructor vacio para la construccion del JSON   
    }
    
    /**
 * constructor con entity por param
 * @param entity 
 */
    public PagoDetailDTO(PagoEntity entity){
        super(entity);
        
    }
    
    /**
     * 
     * @return el pago en formato entity
     */
    @Override
    public PagoEntity toEntity(){
        PagoEntity entity =  super.toEntity();
        if(cuentaBancaria!=null)
            entity.setCuentaBancaria(cuentaBancaria.toEntity());
        
        entity.setTarjetaCredito(this.tarjetaDeCredito.toEntity());
        return entity;
    }

    /**
     * 
     * @return la cuenta bancaria asociada
     */
    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * 
     * @param cuentaBancaria la cuenta bancaria asociada
     */
    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    /**
     * 
     * @return la tarjeta de credito asociada
     */
    public TarjetaCreditoDTO getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * 
     * @param tarjetaDeCredito la tarjeta de credito asociada
     */
    public void setTarjetaDeCredito(TarjetaCreditoDTO tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
    
    
    
}
