/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author df.rengifo
 */
@Entity
public class EnvioEntity implements Serializable{   
   
   private Long horaInicio;
   private Long horaFinal;    
   private String estado;
   private String direccionEntrega;
   private String direccionRecogida; 
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @PodamExclude
   @ManyToOne (fetch = FetchType.LAZY)
   private MensajeroEntity mensajero;
   
   @PodamExclude
   @ManyToOne (fetch = FetchType.LAZY)
   private ClienteEntity cliente;
   
   @PodamExclude
   @OneToOne (fetch = FetchType.LAZY)
   private PagoEntity pago;
   
   @PodamExclude
   @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy = "envio", fetch = FetchType.LAZY)
   private List<EventoEntity> eventos = new ArrayList<>();
   
   @PodamExclude
   @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy = "envio", fetch = FetchType.LAZY)
   private List<PaqueteEntity> paquetes = new ArrayList<>();
   
   @PodamExclude
   @OneToMany(fetch = FetchType.EAGER)
   private List<BonoEntity> bonos = new ArrayList<>();
   
   
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @return the id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
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

    /**
     * @return the mensajero
     */
    public MensajeroEntity getMensajero() {
        return mensajero;
    }

    /**
     * @param mensajero the mensajero to set
     */
    public void setMensajero(MensajeroEntity mensajero) {
        this.mensajero = mensajero;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the pago
     */
    public PagoEntity getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(PagoEntity pago) {
        this.pago = pago;
    }

    /**
     * @return the eventos
     */
    public List<EventoEntity> getEventos() {
        return eventos;
    }

    /**
     * @param eventos the eventos to set
     */
    public void setEventos(List<EventoEntity> eventos) {
        this.eventos = eventos;
    }

    /**
     * @return the paquetes
     */
    public List<PaqueteEntity> getPaquetes() {
        return paquetes;
    }

    /**
     * @param paquetes the paquetes to set
     */
    public void setPaquetes(List<PaqueteEntity> paquetes) {
        this.paquetes = paquetes;
    }

    /**
     * @return the bonos
     */
    public List<BonoEntity> getBonos() {
        return bonos;
    }

    /**
     * @param bonos the bonos to set
     */
    public void setBonos(List<BonoEntity> bonos) {
        this.bonos = bonos;
    }
}
