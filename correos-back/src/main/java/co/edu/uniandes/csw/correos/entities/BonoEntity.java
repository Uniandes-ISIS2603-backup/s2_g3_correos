/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author t.vargas10
 */

@Entity
public class BonoEntity implements Serializable {
    
    /**
     * id del bono
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * cliente al que el bono esta asociado
     */
    @PodamExclude
    @OneToOne
    private ClienteEntity cliente;
    
    private String descripcion; // descripcion del paquete
    private Double descuento; // descuento del bono
    private String condicion; // condicion o estado del bono
    @Temporal(TemporalType.TIMESTAMP) 
    private Date fechaDeVencimiento; // fecha de vencimiento del bono

    /**
     * getter para el id
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * seter para el id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

   

    /**
     * Obtiene el atributo descripcion
     * @return descripcion del bono
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Inserta la descripcion al bono deseado
     * @param descripcion descripcion del bono
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el atributo descuento
     * @return descuento del bono
     */
    public Double getDescuento() {
        return descuento;
    }

    /**
     * asigna el descuento al bono deseado
     * @param descuento descuento del bono
     */
    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene el atributo condicion
     * @return condicion del bono
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * Asigna la condicion al bono deseado
     * @param condicion condicion del bono
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * Obtiene el atributo fecha de vencimiento
     * @return fecha de vencimiento del bono
     */
    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    /**
     * Asigna la fecha de vencimiento al bono deseado
     * @param fechaDeVencimiento fecha de vencimiento del bono
     */
    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    
    /**
     * Devuelve el cliente asociado a este bono
     * @return Entidad de tipo Cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Modifica el cliente asociado a este bono
     * @param cliente El nuevo cliente
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
     
}
