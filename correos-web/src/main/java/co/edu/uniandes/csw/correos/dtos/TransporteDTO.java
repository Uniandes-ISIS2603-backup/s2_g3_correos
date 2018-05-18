/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private Double capacidad;
    private boolean activo;
    
    /**
     * constructor por defecto
     */
    public TransporteDTO()
    {
        //transporteDTO metodo vacio para construccion del JSon
    }
    
    /**
 * constructor con entity por param
 * @param entity 
 */
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
    
    /**
     * 
     * @return el transporte como un entity
     */
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
