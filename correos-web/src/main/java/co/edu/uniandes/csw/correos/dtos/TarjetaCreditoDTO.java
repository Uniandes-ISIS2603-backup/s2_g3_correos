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

import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;

/**
 * TarjetaCreditoDTO Objeto de transferencia de datos de TarjetaCredito. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el TarjetaCredito y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "numero": number,
 *      "fechaDeVencimiento: string,
 *      "securityCode": number
 *   
 *   }
 * </pre>
 * Por ejemplo una tarjeta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 34536789,
 *      "numero": 1234123412341234,
 *      "fechaDeVencimiento: " cinco de marzo del 2018"
 *      "securityCode": 3234
 *     
 *   }
 *
 * </pre>
 * @author da.leon
 */
public class TarjetaCreditoDTO
{

    private long id;
    private String numero;
    private String fecha;
    private short securityCode;

    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDTO() {
        // se deja vacio
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param entity
     * @param TarjetaCredito: Es la entidad que se va a convertir a DTO
     */
   public TarjetaCreditoDTO(TarjetaCreditoEntity entity){
    this.id = entity.getId();
    this.fecha = entity.getFechaDeVencimiento();
    this.securityCode = entity.getSecurityCode();
    this.numero = entity.getNumero();
   }
   
   /**
    * metodo que transforma a entidad
    * @return la entidad
    */
   public TarjetaCreditoEntity toEntity(){
    TarjetaCreditoEntity tarjeta = new TarjetaCreditoEntity();
    tarjeta.setId(this.id);
    tarjeta.setNumero(this.numero);
    tarjeta.setFechaDeVencimiento(this.fecha);
    tarjeta.setSecurityCode(this.securityCode);
    return tarjeta;
}
   
      /**
     * @return El ID de la tarjeta 
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El numero de la tarjeta de credito
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero El nuevo de la tarjeta de credito
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return la fecha de vemcimiento de la tarjeta 
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha la nueva fecha de vencimiento de la tarjeta 
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
      /**
     * @return el securityCode de la tarjeta
     */
    public int getSecurityCode() {
        return securityCode;
    }

    /**
     * @param securityCode el nuevo security code de la tarjeta 
     */
    public void setSecurityCode(short securityCode) {
        this.securityCode = securityCode;
    }

   
 
}
