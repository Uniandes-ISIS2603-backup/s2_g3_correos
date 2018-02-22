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
 * @author da.leon
 */

@Entity
public class ClienteEntity extends BaseEntity implements Serializable {
    
    private String nombre; // nombre dek cliente
   

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

    
}
