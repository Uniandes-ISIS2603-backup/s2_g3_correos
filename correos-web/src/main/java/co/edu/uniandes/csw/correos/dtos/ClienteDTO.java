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

 import co.edu.uniandes.csw.correos.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de cliente. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "idCliente": number,
 *      "nombre: string
 *   
 *   }
 * </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "name: "Pepito Perez"
 *     
 *   }
 *
 * </pre>
 * @author da.leon
 */
public class ClienteDTO
{

    private Long idCliente; // id del cliente
    private String nombre; // nombre del cliente
    private String correo; // correo del cliente
    private String telefono; //telefono del cliente

    /**
     * Constructor por defecto
     */
    public ClienteDTO() 
    {
        // este metodo se deja vacio
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param ClienteEntity: Es la entidad que se va a convertir a DTO
     */
   public ClienteDTO(ClienteEntity entity){
    this.idCliente = entity.getId();
    this.nombre = entity.getNombre();
    this.correo = entity.getCorreo();
    this.telefono = entity.getTelefono();

}
    /**
     * metodo que transforma a entidad 
     * @return la entidad 
     */
public ClienteEntity toEntity(){
    ClienteEntity entity = new ClienteEntity();
    entity.setId(this.idCliente);
    entity.setNombre(this.nombre);
    entity.setCorreo(this.correo);
    entity.setTelefono(this.telefono);
    return entity;
}


    /**
     * @return El ID del usuario 
     */
    public Long getId() {
        return idCliente;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.idCliente = id;
    }

    /**
     * @return El nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre del cliente 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * retorna el correo del cliente
     * @return el correo del cliente
     */
    public String getCorreo()
    {
        return correo;
    }
    
    /**
     * cambia el correo del cliente
     * 
     * @param correo que se va a cambiar
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
    /**
     * retorna el telefono del cliente
     * @return el telefono del cliente
     */
    public String getTelefono()
    {
        return correo;
    }
    
    /**
     * cambia el telefono del cliente
     * @param telefono del cliente que se va a cambiar 
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

 }
