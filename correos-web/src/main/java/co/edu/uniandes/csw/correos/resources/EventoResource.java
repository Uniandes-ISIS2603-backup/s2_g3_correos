/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.EventoDTO;
import co.edu.uniandes.csw.correos.dtos.EventoDetailDTO;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author a.silvag
 */
@Path("eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class EventoResource {
    
    /** <h1>POST /api/evento : Crear un evento.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link EventoDetailDTO}.
     * 
     * Crea un nuevo evento con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo evento .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el evento.
     * </code>
     * </pre>
     * @param evento {@link EventoDetailDTO} - el evento que se desea guardar.
     * @return JSON {@link EventoDetailDTO}  - el evento guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el evento.
     */
    
    @POST
public EventoDetailDTO createEvento(EventoDetailDTO evento)throws BusinessLogicException{
    return evento;
}


/**
     * <h1>PUT /api/cities/{id} : Actualizar evento con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EventoDetailDTO}.
     * 
     * Actualiza el evento con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el evento con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un evento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del evento que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param evento {@link EventoDetailDTO} El evento que se desea guardar.
     * @return JSON {@link EventoDetailDTO} - El evento guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el evento porque ya existe uno con ese correo o numero telefónico.
     */
    @PUT
    @Path("{id: \\d+}")
    public EventoDetailDTO updateEvento(@PathParam("id") Long id , EventoDetailDTO evento) throws BusinessLogicException{
        return evento;
    }
        /**
     * <h1>GET /api/eventos/{id} : Obtener eventos por id.</h1>
     * 
     * <pre>Busca el evento con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el evento correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un evento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador dl evento que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link EventoDetailDTO} - El evento buscado
     */
    @GET
    @Path("{id: \\d+}")
    public EventoDetailDTO getEvento(@PathParam("id") Long id){
        return null;
    }
    /**
     * <h1>GET /api/eventos : Obtener todos los eventos.</h1>
     * 
     * <pre>Busca y devuelve todos las cuentas bancarias que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los eventos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EventoDTO} - Los eventos encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<EventoDTO> getEvento(){
        return new LinkedList<>();
    }
        /**
     * <h1>DELETE /api/eventos/{id} : Borrar evento por id.</h1>
     * 
     * <pre>Borra el evento con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el evento correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un evento con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del evento que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id){
        //en espera de implementacion
    }
    
}
