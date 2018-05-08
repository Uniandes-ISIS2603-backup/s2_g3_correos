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
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.ReservaEntity;
import java.sql.Timestamp;

/**
 * ResrvaDTO Objeto de transferencia de datos de Reservas. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "fecha: string,
 *      "hora": string
 *   }
 * </pre>
 * Por ejemplo una reserva se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1234,
 *      "fecha: "27/02/2018",
 *      "hora": "9:45 PM"
 *   }
 *
 * </pre>
 * @author l.mejia
 */
public class ReservaDTO {
    
    Long id;
  
    private String fecha;
    private String hora;
    
    /**
     * constructor por defecto
     */
    public ReservaDTO()
    {
        //Constructor vacio para construir el objeto del JSon
    }
    
    /**
 * constructor con entity por param
 * @param entity 
 */
    public ReservaDTO(ReservaEntity reserva)
    {
        this.id=reserva.getId();
        this.fecha=reserva.getFecha().toString();
        this.hora=reserva.getHora();
    }
    
    //public ReservaDTO(ReservaEntity reserva){} este se realizara cuando se implemente la capa de persistencia
    
    /**
     * @return el ID de la reserva
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el nuevo id de la reserva
     */
    public void setId(Long id) {    
        this.id = id;
    }
    
    /**
     * @return la fecha de la reserva
     */
    public String getFecha() {
        return fecha;
    }
    
    /**
     * @param fecha la nueva fecha de la reserva
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * @return la hora de la reserva
     */
    public String getHora() {
        return hora;
    }
    
    /**
     * @param hora la nueva hora de la reserva
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    /**
     * 
     * @return la reserva como un entity
     */
    public ReservaEntity toEntity()
    {
        ReservaEntity reserva=new ReservaEntity();
        reserva.setFecha(Timestamp.valueOf(this.fecha));
        reserva.setHora(this.hora);
        reserva.setId(this.id);
        return reserva;
    } 
    
}
