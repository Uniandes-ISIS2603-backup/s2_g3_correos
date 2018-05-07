/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */

package co.edu.uniandes.csw.correos.entities;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**

 *

 * @author t.vargas10

 */



@Entity

public class DetallePaqueteEntity implements Serializable {

    @PodamExclude
    @OneToOne
    private PaqueteEntity paquete;
    

    // Se le quito el id ya que las demas clases, aunque esta en el UML no lo declara

    private String mensaje; // mensaje del paquete

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return el id
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

     * obtiene al atributo mensaje

     * @return mensaje del paquete

     */

    public String getMensaje() {

        return mensaje;

    }



    /**

     * Asigna el mensaje al paquete

     * @param mensaje mensaje del paquete

     */

    public void setMensaje(String mensaje) {

        this.mensaje = mensaje;

    }

     /**
     * Devuelve el paquete asociado a este detalle
     * @return Entidad de tipo paquete
     */
    public PaqueteEntity getPaquete() {
        return paquete;
    }

    /**
     * Modifica el paquete asociado a este detalle
     * @param book El nuevo paquete
     */
    public void setBook(PaqueteEntity book) {
        this.paquete = book;
    }

    

}