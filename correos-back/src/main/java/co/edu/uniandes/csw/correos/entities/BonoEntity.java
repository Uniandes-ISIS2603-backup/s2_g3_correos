/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author t.vargas10
 */

@Entity
public class BonoEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @OneToOne
    private ClienteEntity cliente;
    
    private String descripcion; // descripcion del paquete
    private Double descuento; // descuento del bono
    private String condicion; // condicion o estado del bono
    private String fechaDeVencimiento; // fecha de vencimiento del bono

   

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
    public String getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    /**
     * Asigna la fecha de vencimiento al bono deseado
     * @param fechaDeVencimiento fecha de vencimiento del bono
     */
    public void setFechaDeVencimiento(String fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }
    
    
}
