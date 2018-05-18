/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;

/**
 * * * CuentaBancariaDTO Objeto de transferencia de datos de CuentaBancaria. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id":long,
 *      "numero": String,
 *      "banco": String,
 *      "tipoTarjeta":String
 *   }
 * </pre>
 * Por ejemplo un evento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id":646464,
 *      "numero": "827338",
 *      "banco": "Banco Pichincha",
 *      "tipoTarjeta":"De hotel"
 *   }
 *
 * </pre>
 * @author a.silvag
 */
public class CuentaBancariaDTO {
    
    /**
     * id de la cuenta
     */
private long id;

/**
 * numero de la cuenta 
 */
private String numero;

/**
 * banco de la cuenta 
 */
private String banco;

/**
 * tipo de tarjeta 
 */
private String tipoTarjeta;

/**
 * constructor
 */
public CuentaBancariaDTO(){
        //Este metodo esta vacio para permitir la construccion del JSON
    }

/**
 * constructor con entity por param
 * @param entity 
 */
public CuentaBancariaDTO(CuentaBancariaEntity entity){
    this.id = entity.getId();
    this.numero = entity.getNumero();
    this.banco = entity.getBanco();
    this.tipoTarjeta = entity.getTipoTarjeta();
}

/**
 * 
 * @return la cuenta bancaria como un entity
 */
public CuentaBancariaEntity toEntity(){
    CuentaBancariaEntity entity = new CuentaBancariaEntity();
    entity.setBanco(this.banco);
    entity.setId(this.id);
    entity.setTipoTarjeta(this.tipoTarjeta);
    entity.setNumero(this.numero);
    return entity;
}

/**
 * @return el id de la cuenta bancaria
 */

public long getId()
{
        return id;
}

/**
     * @param id el nuevo id de la cuenta bancaria
     */
public void setId(long id){
        this.id = id;
} 

/**
 * @return el numero de la cuenta bancaria
 */
public String getNumero(){
    return numero;
}    
/**
 * @param numero el nuevo numero que tiene la cuenta bancaria
 */
public void setNumero(String numero){
    this.numero = numero;
}
/**
 * @return el nombre del banco
 */
public String getBanco(){
    return banco;
}    
/**
 * @param numero el nuevo nombre del banco
 */
public void setBanco(String banco){
    this.banco = banco;
}
/**
 * @return el tipo de la tarjeta
 */
public String getTipoTarjeta(){
    return tipoTarjeta;
}    
/**
 * @param tipoTarjeta el nuevo tipo de la tarjeta
 */
public void setTipoTarjeta(String tipoTarjeta){
    this.tipoTarjeta = tipoTarjeta;
}

}
