/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *      "nombre": string,
 *      "correo": String,
 *      "telefono": String
 *   
 *   }
 * </pre>
 * Por ejemplo una ciudad se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "name: "Pepito Perez",
 *      "correo":"correo1@uniandes.edu.co",
 *      "telefono": "3000000000" 
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
        return telefono;
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
