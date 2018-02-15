/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 *
 * @author a.silvag
 */
public class PagoDetailDTO extends PagoDTO {
    
    private CuentaBancariaDTO cuentaBancaria;
    private TarjetaCreditoDTO tarjetaDeCredito;
    public PagoDetailDTO(){
        
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
