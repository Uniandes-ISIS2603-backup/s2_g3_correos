/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author da.leon
 */

@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable {
   
    private Short securityCode; // codigo de seguridad de la tarjeta
    private String numero; // numero de la tarjeta
    private String fechaDeVencimiento; // fecha de vencimiento de la tarjeta
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetaCredito")
    private List<PagoEntity> pagos;
    
    @PodamExclude
    @ManyToOne(fetch=FetchType.LAZY)
    private ClienteEntity cliente;

    

    /**
     * Obtiene el atributo securityCode
     * @return seurityCode de la tarjeta
     */
    public Short getSecurityCode() {
        return securityCode;
    }

    /**
     * asigna el security code deseado
     * @param securityCode quee se va a añadir
     */
    public void setSecurityCode(Short securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * Obtiene el numero de la tarjeta
     * @return numero de la tarjeta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Asigna el numero de la tarjeta
     * @param numero de la tarjeta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el atributo fecha de vencimiento
     * @return fecha de vencimiento de la tarjeta
     */
    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    /**
     * Asigna la fecha de vencimiento a la tarjeta
     * @param fechaDeVencimiento fecha de vencimiento de la tarjeta
     */
    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public List<PagoEntity> getPagos() {
        return pagos;
    }

    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    
}
