/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.BonoEntity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BonoDTO Objeto de transferencia de datos Bono. Los DTO continen las representacones de los JSON entre el cliente y el servidor
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo:
 * <pre>
 * {
 *  "descripción": String
 *  "dexuentos": Double
 *  "condición": String
 *  "fechaDeVencimiento": String
 * }
 * <\pre>
 * @author t.vargas10
 */
public class BonoDTO 
{
    /**
     * id del bono 
     */
    private Long id;
    private String name;
    /**
     * descripcion del bono 
     */
    private String descripcion;
    
    /**
     * descuento 
     */
    private double descuento;
    /**
     * condicion del bono 
     */
    private String condicion;
    /**
     * fecha del bono 
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeVencimiento;
    
    /**
     * Conductor por defecto 
     */
    public BonoDTO()
    {
         //Este metodo esta vacio para permitir la construccion del JSON 
    }
    
    /**
     * constructor con entity por param
     * @param entity 
     */
    public BonoDTO(BonoEntity entity) {

        this.id = entity.getId();
        this.condicion = entity.getCondicion();
        this.descripcion = entity.getDescripcion();
        this.fechaDeVencimiento = entity.getFechaDeVencimiento();
        this.descuento=entity.getDescuento();
    }

    /**
     * 
     * @return el bono en formato entity
     */
    public BonoEntity toEntity() {
        BonoEntity entity = new BonoEntity();
        entity.setId(this.id);
        entity.setCondicion(this.condicion);
        entity.setDescripcion(this.descripcion);
        entity.setFechaDeVencimiento(this.fechaDeVencimiento);
        entity.setDescuento(this.descuento);
        return entity;
    }

    //public BonoDTO(MBonoEntity entity){} este constructor sera realizado una vez se realice la capa de persistencia


    /**
     * @return id del bono
     */
    public long getId() {
        return id;
    }
    /**
     * @param id nuevo id del bono
     */
    public void setId (Long id)
    {
        this.id = id;
    }
    /**
 * DEvuelve la descripción del bono
 * @return descripción del bono
 */    
    public String getDescripcion()
    {
        return descripcion;
    }
    /**
     * @param descrip la nueva descripción del bono 
     */
    public void setDescripcion(String descrip)
    {
        this.descripcion = descrip;
    }
    /**
     * @return descuento del bono
     */
    public double getDescuento()
    {
        return descuento;
    }
    /**
     * @param descuent el nuevo descuento del bono 
     */
    public void setDescuento(double descuent)
    {
        this.descuento = descuent;
    }
    /**
     * @return condición del bono 
     */
    public String getCondicion()
    {
        return condicion;
    }
    /**
     * @param conditition la nueva condición del bono 
     */
    public void setCondicion(String conditition)
    {
        this.condicion = conditition;
    }
    /**
     * @return fecha de vencimiento del bono 
     */
    public Date fechaDeVencimiento()
    {
        return fechaDeVencimiento;
    }
    /**
     * @param fechaDeVenc nueva fecha de vencimiento del bono 
     */
    public void setFechaDeVencimiento (Date fechaDeVenc)
    {
        this.fechaDeVencimiento = fechaDeVenc;
    }
    
}



















