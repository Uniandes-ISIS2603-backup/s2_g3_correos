/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author l.mejia
 */
@Entity
public class ReservaEntity implements Serializable{
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private Long horaInicio;
    private Long horaFinal;
    private String direccionEntrega;
    private String direccionRecogida;
    private String estado;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
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
     * setter del id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return la fecha de la reserva
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * @param fecha la nueva fecha de la reserva
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    /**
     * @return la hora inicial de la reserva
     */
    public Long getHoraInicio() {
        return horaInicio;
    }
    
    /**
     * @param hora la nueva hora inicial de la reserva
     */
    public void setHoraInicio (Long horaInicio) {
        this.horaInicio = horaInicio;
    }
        
    /**
     * @return la hora de la reserva
     */
    public Long getHoraFinal() {
        return horaFinal;
    }
    
    /**
     * @param hora la nueva hora final de la reserva
     */
    public void setHoraFinal (Long horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    /**
     * direccion de recogida 
     * @return la direccion de recogida
     */
    public String getDireccionRecogida()
    {
        return direccionRecogida;
    }

    /**
     * direccion recogida 
     * @param direccionRecogida 
     */
    public void setDireccionRecogida(String direccionRecogida)
    {
        this.direccionRecogida = direccionRecogida;
    }
    
    /**
     * direccion de entrega 
     * @return la direccion de entrega
     */
    public String getDireccionEntrga()
    {
        return direccionEntrega;
    }

    /**
     * direccion recogida 
     * @param direccionRecogida 
     */
    public void setDireccionEntrega(String direccionEntrega)
    {
        this.direccionEntrega = direccionEntrega;
    }
    
    /**
    * hace get del estado 
     * @return el estado
     */
    public String getEstado(){
        return estado;
    }
    
    /**
     * cambia el estado 
     * @param estado que se va a cambiar 
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }
    /**
     * 
     * @return el cliente asociado a la reserva
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * setter del cliente asociado
     * @param cliente 
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
 
}
