/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

/**
 *
 * @author a.silvag
 */
public class PagoDTO {
    
    private double valor;
    private String fecha;
    
public PagoDTO(){
        //Este metodo esta vacio para permitir la construccion del JSON
    }
/**
 * @return el valor del pago
 */
public double getValor(){
    return valor;
}    
/**
 * @param valor el nuevo valor que tiene el pago
 */
public void setValor(double valor)
{
    this.valor = valor;
}

/**
 * @return la fecha del pago
 */
public String getFecha(){
    return fecha;
}    
/**
 * @param fecha la nueva fecha que tiene el pago
 */
public void setFecha(String fecha){
    this.fecha = fecha;
}
}
