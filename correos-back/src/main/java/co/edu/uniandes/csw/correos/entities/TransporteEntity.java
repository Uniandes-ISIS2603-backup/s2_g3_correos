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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author l.mejia
 */
@Entity
public class TransporteEntity implements Serializable {
    
    private String tipo;
    private Double capacidad;
    private Boolean activo;
    
    @PodamExclude
    @ManyToOne
    private MensajeroEntity mensajero;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * 
     * @return activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * setter de activo
     * @param activo 
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * getter de mensajero
     * @return 
     */
    public MensajeroEntity getMensajero() {
        return mensajero;
    }

    /**
     * setter de mensajero
     * @param mensajero 
     */
    public void setMensajero(MensajeroEntity mensajero) {
        this.mensajero = mensajero;
    }    
    
    /**
     * @return El tipo de transporte
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * @param tipo el nuevo tipo del transporte
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * @return la capacidad del transporte
     */
    public Double getCapacidad() {
        return capacidad;
    }
    
    /**
     * @param capacidad la nueva capacidad del transporte
     */
    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * @return True si el transporte esta activo, false de lo contrario
     */
    public boolean isActivo() {
        return activo;
    }
    
    /**
     * @param activo el nuevo estado del transporte del transporte
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
