/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author df.rengifo
 */
@Entity
public class EnvioEntity extends BaseEntity implements Serializable{   
   
   private Long horaInicio;
   private Long horaFinal;    
   private String estado;
   private String direccionEntrega;
   private String direccionRecogida;  

    /**
     * @return the horaInicio
     */
    public Long getHoraInicio() {
        return horaInicio;
    }

    /**
     * @param horaInicio the horaInicio to set
     */
    public void setHoraInicio(Long horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * @return the horaFinal
     */
    public Long getHoraFinal() {
        return horaFinal;
    }

    /**
     * @param horaFinal the horaFinal to set
     */
    public void setHoraFinal(Long horaFinal) {
        this.horaFinal = horaFinal;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the direccionEntrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * @param direccionEntrega the direccionEntrega to set
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * @return the direccionRecogida
     */
    public String getDireccionRecogida() {
        return direccionRecogida;
    }

    /**
     * @param direccionRecogida the direccionRecogida to set
     */
    public void setDireccionRecogida(String direccionRecogida) {
        this.direccionRecogida = direccionRecogida;
    }     
}
