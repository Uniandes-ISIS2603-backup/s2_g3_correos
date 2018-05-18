/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author da.leon
 */

@Entity
public class ClienteEntity implements Serializable {
    
    private String nombre; // nombre del cliente
    private String correo; // correo del cliente
    private String telefono; // telefono del cliente
    private String password;

    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<BonoEntity> bonos;
    
    @PodamExclude
    @OneToMany (fetch = FetchType.LAZY, mappedBy="cliente")
    private List<EnvioEntity> envios;
    
    @PodamExclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true )
    private List<TarjetaCreditoEntity> tarjetasCredito;
    
    @PodamExclude
    @OneToMany(fetch =FetchType.LAZY, mappedBy = "cliente",orphanRemoval = true)
    private List <ReservaEntity> reservas;         
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * getter para el id
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * setter para el id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre del cliente
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre del cliente
     * @param nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * obtiene el correo del cliente
     * @return correo del cliente
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * cambia el correo del cliente
     *  @param correo del cliente
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    /**
     * retorna el telefono del cliente
     * @return el telefono del cliente
     */
    public String getTelefono()
    {
        return telefono;
    }
    
    /**
     * cambia el telefono del cliente
     * @param telefono el telefono del cliente
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
     /**
     * Devuelve los bonos del cliente.
     * @return Lista de entidades de tipo bono
     */
    public List<BonoEntity> getBonos() {
        return bonos;
    }

    /**
     * Modifica los bonos de un cliente.
     * @param bonos Los bonos.
     */
    public void setBonos(List<BonoEntity> bonos) {
        this.bonos = bonos;
    }
    
    
     /**
     * @return los envios asociados
     */
    public List<EnvioEntity> getEnvios() {
        return envios;
    }

    /**
     * @param envios que se modifican
     */
    public void setEnvio(List<EnvioEntity> envios) {
        this.envios = envios;
    }

    /**
     * 
     * @return todas las tarjetas de credito del cliente
     */
    public List<TarjetaCreditoEntity> getTarjetasCredito() {
        return tarjetasCredito;
    }

    /**
     * le pone al cliente las tarjetas de credito por parametro
     * @param tarjetasCredito 
     */
    public void setTarjetasCredito(List<TarjetaCreditoEntity> tarjetasCredito) {
        this.tarjetasCredito = tarjetasCredito;
    }
    
    /**
     * le agrega la tarjeta de credito por param
     * @param tarjeta 
     */
    public void agregarTarjetas(TarjetaCreditoEntity tarjeta)
    {
        this.tarjetasCredito.add(tarjeta);
    }

    /**
     * 
     * @return las reservas asociadas
     */
    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    /**
     * setter para las reservas
     * @param reservas 
     */
    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}
