/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 

package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.PositiveIntegerStrategy;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author df.rengifo
 */

@Entity
public class PaqueteEntity implements Serializable{        
   
   @PodamStrategyValue(PositiveIntegerStrategy.class)
   private Double dimensionA;
   @PodamStrategyValue(PositiveIntegerStrategy.class)
   private Double dimensionB;
   @PodamStrategyValue(PositiveIntegerStrategy.class)
   private Double dimensionC;
   @PodamStrategyValue(PositiveIntegerStrategy.class)
   private Double peso;
   private String tipo;

   @PodamExclude
   @ManyToOne (fetch = FetchType.EAGER)
   private EnvioEntity envio; 

   @PodamExclude
   @OneToOne (cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private DetallePaqueteEntity detalle;  
   
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
     * @return the dimensionA
     */
    public Double getDimensionA() {
        return dimensionA;
    }

    /**
     * @param dimensionA the dimensionA to set
     */
    public void setDimensionA(Double dimensionA) {
        this.dimensionA = dimensionA;
    }

    /**
     * @return the envio
     */
    public EnvioEntity getEnvio() {
        return envio;
    }

    /**
     * @param envio the envio to set
     */
    public void setEnvio(EnvioEntity envio) {
        this.envio = envio;
    }
    
    /**
     * @return the detalle
     */
    public DetallePaqueteEntity getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalles to set
     */
    public void setDetalle(DetallePaqueteEntity detalle) {
        this.detalle = detalle;
    }
    
    /**
     * @return the dimensionB
     */
    public Double getDimensionB() {
        return dimensionB;
    }

    /**
     * @param dimensionB the dimensionB to set
     */
    public void setDimensionB(Double dimensionB) {
        this.dimensionB = dimensionB;
    }

    /**
     * @return the dimensionC
     */
    public Double getDimensionC() {
        return dimensionC;
    }

    /**
     * @param dimensionC the dimensionC to set
     */
    public void setDimensionC(Double dimensionC) {
        this.dimensionC = dimensionC;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  
}