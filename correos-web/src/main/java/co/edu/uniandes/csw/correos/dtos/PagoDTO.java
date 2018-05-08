/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.PagoEntity;
import java.util.Date;

/**
 *
 * * PagoDTO Objeto de transferencia de datos de Pago. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id":long,
 *      "valor": double,
 *      "fecha": String
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id":6900420,
 *      "valor": 420.69,
 *      "fecha": "5/4/2016"
 *   }
 *
 * </pre>
 * @author a.silvag
 */
public class PagoDTO {
    
    private long id;
    private double valor;
    private Date fecha;
    
    /**
     * constructor por defecto
     */
public PagoDTO(){
        //Este metodo esta vacio para permitir la construccion del JSON
    }

/**
 * constructor con entity por param
 * @param entity 
 */
public PagoDTO(PagoEntity entity){
    if(entity!=null){
        this.id = entity.getId();
        this.valor = entity.getValor();
        this.fecha = entity.getFecha();
    }
}
/**
 * 
 * @return el pago en formato entity
 */
public PagoEntity toEntity(){
    PagoEntity entity = new PagoEntity();
    entity.setFecha(fecha);
    entity.setValor(valor);
    entity.setId(id);
    return entity;
}

/**
 * @return el id del pago
 */

public long getId()
{
        return id;
}

/**
     * @param id el nuevo id dl pago
     */
public void setId(long id){
        this.id = id;
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
public Date getFecha(){
    return fecha;
}    
/**
 * @param fecha la nueva fecha que tiene el pago
 */
public void setFecha(Date fecha){
    this.fecha = fecha;
}
}
