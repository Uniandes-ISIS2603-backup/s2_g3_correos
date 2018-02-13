/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 *
 * @author t.vargas10
 */
public class BonoDTO 
{
    private String descripcion;
    private double descuento;
    private String condicion;
    private String fechaDeVencimiento;
    
    public BonoDTO()
    {
         //Este metodo esta vacio para permitir la construccion del JSON 
    }
    
     //public BonoDTO(MBonoEntity entity){} este constructor sera realizado una vez se realice la capa de persistencia  
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setDescripcion(String descrip)
    {
        this.descripcion = descrip;
    }
    
    public double getDescuento()
    {
        return descuento;
    }
    
    public void setDescuento(double descuent)
    {
        this.descuento = descuent;
    }
    
    public String getCondicion()
    {
        return condicion;
    }
    
    public void setCondicion(String conditition)
    {
        this.condicion = conditition;
    }
    
    public String fechaDeVencimiento()
    {
        return fechaDeVencimiento;
    }
    
    public void setFechaDeVencimiento (String fechaDeVenc)
    {
        this.fechaDeVencimiento = fechaDeVenc;
    }
    
    // public BonoEntity toEntity(){} este metododo se realizara una vez se haya realizado la capa de persistencia 
}



















