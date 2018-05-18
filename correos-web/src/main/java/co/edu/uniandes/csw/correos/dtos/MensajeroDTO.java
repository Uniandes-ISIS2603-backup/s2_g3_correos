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

import co.edu.uniandes.csw.correos.entities.MensajeroEntity;

/**
 * MensajeroDTO Objeto de transferencia de datos de Mensajeros. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "nombre: string,
 *      "celular": string,
 *      "correo": string,
 *      "calificacionPromedio": number
 *   }
 * </pre>
 * Por ejemplo un mensajero se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1234,
 *      "nombre: "Juan",
 *      "celular": "3182223652",
 *      "correo": "juanElMensajero@correo.com",
 *      "calificacionPromedio": 4.9
 *   }
 *
 * </pre>
 * @author l.mejia
 */
public class MensajeroDTO {
    
    private Long id; // id del mensajero 
    private String nombre; // nombre del mensajero 
    private String celular; // celular del mensajero 
    private String correo; // correo del mensajero 
    private Double calificacionPromedio; // calificacion promedio del mensajero 
    private Boolean ocupado; // boolean que informa si esta ocupado o no 
    
    /**
     * Constructor por defecto
     */
    public MensajeroDTO ()
    {
        //Este metodo esta vacio para permitir la construccion del JSON
    }
    /**
 * constructor con entity por param
 * @param entity 
 */
    public MensajeroDTO(MensajeroEntity entity)
    {
        this.id=entity.getId();
        this.calificacionPromedio=entity.getCalificacionPromedio();
        this.celular=entity.getCelular();
        this.correo=entity.getCorreo();
        this.nombre=entity.getNombre();
        this.ocupado=entity.isOcupado();
    } 
    
    /**
     * @return el ID del mensajero
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id el nuevo id del mensajero
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el nombre del mensajero
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @param nombre el nuevo nombre del mensajero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return el celular del mensajero
     */
    public String getCelular() {
        return celular;
    }
    
    /**
     * @param celular el nuevo celular del mensajero
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    /**
     * @return el correo del mensajero
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * @param correo el nuevo correo del mensajero
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @return la calificación promedio del mensajero del mensajero
     */
    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }
    
    /**
     * @param calificacionPromedio la nueva calificación promedio del mensajero
     */
    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    /**
     * 
     * @return estado ocupado
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * setter de ocupado
     * @param ocupado 
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * 
     * @return el mensajero en formato entity
     */
    public MensajeroEntity toEntity()
    {
        MensajeroEntity entity= new MensajeroEntity();
        entity.setCalificacionPromedio(this.calificacionPromedio);
        entity.setNombre(this.nombre);
        entity.setCelular(this.celular);
        entity.setCorreo(this.correo);
        entity.setId(this.id);
        entity.setOcupado(this.ocupado);
        return entity;
    } 
}
