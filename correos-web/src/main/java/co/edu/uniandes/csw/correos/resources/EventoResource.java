/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.EventoDTO;
import co.edu.uniandes.csw.correos.ejb.EnvioLogic;
import co.edu.uniandes.csw.correos.ejb.EventoLogic;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @evento a.silvag
 */
@Path("envios/{envioId:\\d+}/eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class EventoResource {

    private static final String NOEXISTE="El envio no existe";
    
    private EventoLogic eventoLogic;
    
    private EnvioLogic envioLogic;
    
    /**
     * constructor con params
     * @param eventoLogic
     * @param envioLogic 
     */
    @Inject
   public EventoResource(EventoLogic eventoLogic, EnvioLogic envioLogic)
   {
       this.envioLogic=this.envioLogic;
       this.eventoLogic=this.eventoLogic;
   }
   
   /**
    * constructor
    */
   public EventoResource()
   {
       this.envioLogic=null;
       this.eventoLogic=null;
   }
    
    /** <h1>POST /api/evento : Crear un evento.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link EventoDTO}.
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
     * @param evento {@link EventoDTO} - el evento que se desea guardar.
     * @return JSON {@link EventoDTO}  - el evento guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el evento.
     */

    
    @POST
public EventoDTO createEvento(@PathParam("envioId") Long envioId, EventoDTO evento)throws BusinessLogicException{
    if(envioLogic.getEnvio(envioId)==null){
        throw new WebApplicationException(NOEXISTE);
    }
    envioLogic.agregarEvento(envioId, evento.toEntity());
    return new EventoDTO(eventoLogic.createEvento(evento.toEntity()));
}


/**
     * <h1>PUT /api/cities/{id} : Actualizar evento con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EventoDTO}.
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
     * @param evento {@link EventoDTO} El evento que se desea guardar.
     * @return JSON {@link EventoDTO} - El evento guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el evento porque ya existe uno con ese correo o numero telefónico.
     */
    @PUT
    @Path("{id: \\d+}")
    public EventoDTO updateEvento(@PathParam("envioId")Long envioId,@PathParam("id") Long id , EventoDTO evento) throws BusinessLogicException{
         
        if(envioLogic.getEnvio(envioId)==null){
        throw new WebApplicationException(NOEXISTE);
    }
       if(eventoLogic.getEvento(id)==null){
           throw new WebApplicationException(NOEXISTE);
       }
       evento.setId(id);
       EventoEntity evento2=evento.toEntity();
       evento2.setEnvio(envioLogic.getEnvio(envioId));
       eventoLogic.updateEvento(evento2);
        return new EventoDTO(evento.toEntity());
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
     * @return JSON {@link EventoDTO} - El evento buscado
     */
    @GET
    @Path("{id: \\d+}")
    public EventoDTO getEvento(@PathParam("envioId")Long envioId,@PathParam("id") Long id){
        if(envioLogic.getEnvio(envioId)==null){
        throw new WebApplicationException(NOEXISTE);
    }   
        
        EventoEntity entity = eventoLogic.getEvento(id);
        if (entity == null) {
            throw new WebApplicationException(NOEXISTE, 404);
        }
        return new EventoDTO(entity);
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
    private List<EventoDTO> listEntity2DTO(List<EventoEntity> entityList) {
        List<EventoDTO> list = new ArrayList<>();
        for (EventoEntity entity : entityList) {
            list.add(new EventoDTO(entity));
        }
        return list;
    }
    
    /**
     * 
     * @param envioId
     * @return todos los eventos
     */
    @GET
    public List<EventoDTO> getEventos(@PathParam("envioId")Long envioId){
        if(envioLogic.getEnvio(envioId)==null){
        throw new WebApplicationException(NOEXISTE);
    }
        return listEntity2DTO(envioLogic.getEnvio(envioId).getEventos());
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
    
    //FALTA EL DELETE
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("envioId")Long envioId,@PathParam("id") Long id)throws BusinessLogicException{
        //en espera de implementacion
        if(envioLogic.getEnvio(envioId)==null){
        throw new WebApplicationException(NOEXISTE);
    }       
        EventoEntity entity = eventoLogic.getEvento(id);
        if (entity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        envioLogic.borrarEvento(envioId, id);
        eventoLogic.deleteEvento(id);
    }
    
}
