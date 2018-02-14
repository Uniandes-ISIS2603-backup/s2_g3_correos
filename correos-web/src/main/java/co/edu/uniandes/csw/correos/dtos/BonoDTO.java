/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

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
    private long id;
    private String descripcion;
    private double descuento;
    private String condicion;
    private String fechaDeVencimiento;
    
    /**
     * Conductor por defecto 
     */
    public BonoDTO()
    {
         //Este metodo esta vacio para permitir la construccion del JSON 
    }
    
     //public BonoDTO(MBonoEntity entity){} este constructor sera realizado una vez se realice la capa de persistencia  
    /**
     * @return id del bono
     */
    public long getId()
    {
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
    public String fechaDeVencimiento()
    {
        return fechaDeVencimiento;
    }
    /**
     * @param fechaDeVenc nueva fecha de vencimiento del bono 
     */
    public void setFechaDeVencimiento (String fechaDeVenc)
    {
        this.fechaDeVencimiento = fechaDeVenc;
    }
    
    // public BonoEntity toEntity(){} este metododo se realizara una vez se haya realizado la capa de persistencia 
}



















