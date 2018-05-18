/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.PositiveIntegerStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author a.silvag
 */
@Entity
public class PagoEntity implements Serializable{
    
    /**
     * relacion con tarjetas de credito
     */
    @PodamExclude
    @ManyToOne
    private TarjetaCreditoEntity tarjetaCredito;
    
    /**
     * relacion con cuenta bancaria 
     */
    @PodamExclude
    @ManyToOne
    private CuentaBancariaEntity cuentaBancaria;
    
    /**
     * valor 
     */
    @PodamStrategyValue(PositiveIntegerStrategy.class)
    private Double valor;
    
    /**
     * fecha del pago 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    /**
     * id del pago 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set the id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

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
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
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
