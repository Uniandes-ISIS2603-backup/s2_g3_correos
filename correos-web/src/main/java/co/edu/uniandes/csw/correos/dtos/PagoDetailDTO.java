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
    //private TarjetaDeCreditoDTO tarjetaDeCredito;
    public PagoDetailDTO(){
        
    }

    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    
}
