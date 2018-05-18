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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author da.leon
 */

@Entity
public class TarjetaCreditoEntity implements Serializable {
   
    
    private String anio; // anio de vencimiento de la tarjeta
    private String numero; // numero de la tarjeta
    private String mes; // mes de vencimiento de la tarjeta
    
    /**
     * asociacion con pagos 
     */
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarjetaCredito")
    private List<PagoEntity> pagos;
    
    /**
     * asociacion con cliente 
     */
    @PodamExclude
    @ManyToOne(fetch=FetchType.LAZY)
    private ClienteEntity cliente;

    /**
     * id del tarjeta 
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
     * setter del id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo securityCode
     * @return anio de la tarjeta
     */
    public String getAnio() {
        return anio;
    }

    /**
     * asigna el security code deseado
     * @param anio que se va a añadir de la tarjeta
     */
    public void setAnio(String anio) {
        this.anio = anio;
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
     * @return mes de vencimiento de la tarjeta
     */
    public String getMes() {
        return mes;
    }

    /**
     * Asigna la fecha de vencimiento a la tarjeta
     * @param mes fecha de vencimiento de la tarjeta
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * 
     * @return the pagos
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }

    /**
     * setter de los pagos
     * @param pagos 
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    /**
     * 
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * setter de the cliente
     * @param cliente 
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
    
    
}
