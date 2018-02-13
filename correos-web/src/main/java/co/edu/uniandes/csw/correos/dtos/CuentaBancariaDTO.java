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
public class CuentaBancariaDTO {
private long id;
private String numero;
private String banco;
private String tipoTarjeta;

public CuentaBancariaDTO(){
        //Este metodo esta vacio para permitir la construccion del JSON
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
 * @param banco el nuevo nombre del banco
 */
public void setBanco(String numero){
    this.numero = numero;
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
