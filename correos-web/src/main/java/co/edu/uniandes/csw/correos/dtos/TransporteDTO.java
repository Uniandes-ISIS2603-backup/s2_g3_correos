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

import co.edu.uniandes.csw.correos.entities.TransporteEntity;

/**
 * TransporteDTO Objeto de transferencia de datos de Transportes. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "tipo: string,
 *      "capacidad": string,
 *      "activo": boolean
 *   }
 * </pre>
 * Por ejemplo un transporte se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1234,
 *      "tipo: "Moto",
 *      "capacidad": "4 kg",
 *      "activo": "false"
 *   }
 *
 * </pre>
 * @author l.mejia
 */
public class TransporteDTO {
    
    private Long id;
    private String tipo;
    private String capacidad;
    private boolean activo;
    
    public TransporteDTO()
    {
        //transporteDTO metodo vacio para construccion del JSon
    }
    
    public TransporteDTO(TransporteEntity transporte)
    {
        this.id=transporte.getId();
        this.tipo=transporte.getTipo();
        this.capacidad=transporte.getCapacidad();
        this.activo=transporte.isActivo();
    }
    
    
    /**
     * @return el ID del transporte
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id el nuevo id del transporte
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return el tipo de transporte
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
    public String getCapacidad() {
        return capacidad;
    }
    
    /**
     * @param capacidad la nueva capacidad del transporte
     */
    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * @return True si el transporte esta activo, False si no lo esta.
     */
    public boolean isActivo() {
        return activo;
    }
    
    /**
     * @param activo el nuevo estado del transporte
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public TransporteEntity toEntity()
    {
        TransporteEntity transporte=new TransporteEntity();
        transporte.setId(this.id);
        transporte.setTipo(this.tipo);
        transporte.setCapacidad(this.capacidad);
        transporte.setActivo(this.activo);
        return transporte;
    } 
    
}
