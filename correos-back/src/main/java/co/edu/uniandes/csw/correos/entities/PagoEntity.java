/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author a.silvag
 */
@Entity
public class PagoEntity extends BaseEntity implements Serializable{
    
    @PodamExclude
    @ManyToOne
    private TarjetaCreditoEntity tarjetaCredito;
    
    @PodamExclude
    @ManyToOne
    private CuentaBancariaEntity cuentaBancaria;
    
    
    
    private Double valor;
    private String fecha;

    

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the tarjetaCredito
     */
    public TarjetaCreditoEntity getTarjetaCredito() {
        return tarjetaCredito;
    }

    /**
     * @param tarjetaCredito the tarjetaCredito to set
     */
    public void setTarjetaCredito(TarjetaCreditoEntity tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    /**
     * @return the cuentaBancaria
     */
    public CuentaBancariaEntity getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * @param cuentaBancaria the cuentaBancaria to set
     */
    public void setCuentaBancaria(CuentaBancariaEntity cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
}
