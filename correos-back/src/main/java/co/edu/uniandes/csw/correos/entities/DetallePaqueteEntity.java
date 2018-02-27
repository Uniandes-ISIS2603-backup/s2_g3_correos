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

 * @author t.vargas10

 */



@Entity

public class DetallePaqueteEntity extends BaseEntity implements Serializable {

    

    // Se le quito el id ya que las demas clases, aunque esta en el UML no lo declara

    private String mensaje; // mensaje del paquete



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

    

    

}