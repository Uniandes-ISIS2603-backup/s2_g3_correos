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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author da.leon
 */

@Entity
public class ClienteEntity extends BaseEntity implements Serializable {
    
    private String nombre; // nombre del cliente
   
    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<BonoEntity> bonos = new ArrayList<BonoEntity>();
    
    @PodamExclude
    @OneToMany (fetch = FetchType.EAGER)
    private List<EnvioEntity> envios; 

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
}
