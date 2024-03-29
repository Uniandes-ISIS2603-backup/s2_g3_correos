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
CITYS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.CalificacionDTO;
import co.edu.uniandes.csw.correos.ejb.CalificacionLogic;
import co.edu.uniandes.csw.correos.ejb.MensajeroLogic;
import co.edu.uniandes.csw.correos.entities.CalificacionEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.mappers.BusinessLogicExceptionMapper;
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
 * <pre>Clase que implementa el recurso "calificacion".
 * URL: /api/cities
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "cities".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author ed.diaz11
 * @version 1.0
 */
@Path("mensajeros/{mensajeroId:\\d+}/calificaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
 
    private CalificacionLogic logica;
    
    private MensajeroLogic logicMensajero;
    
    /**
     * constructor con params
     * @param cL
     * @param mL 
     */
    @Inject
    public CalificacionResource(CalificacionLogic cL, MensajeroLogic mL)
    {
        this.logica=cL;
        this.logicMensajero=mL;
    }
    
    /**
     * constructor
     */
    public  CalificacionResource()
    {
        this.logicMensajero=null;
        this.logica=null;
    }
    
    /**
     * <h1>POST /api/cities : Crear un comentairo.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CalificacionDTO}.
     * 
     * Crea un nuevo  comentario con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo comentario .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el comentario.
     * </code>
     * </pre>
     * @param calificacion {@link CalificacionDTO} - El comentairo  que se desea guardar.
     * @return JSON {@link CalidicacionDetailDTO}  - El comentario que se guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el comentario.
     */
    @POST
    public CalificacionDTO createCalificacion(@PathParam("mensajeroId") Long mensajeroId, CalificacionDTO calificacion) throws BusinessLogicException {
        if(logicMensajero.getMensajero(mensajeroId)==null) 
            throw new WebApplicationException("no existe el Mensajero con el id" + mensajeroId, 404);
        logicMensajero.agregarCalificacion(mensajeroId, calificacion.toEntity());
        return new CalificacionDTO(logica.createCalificacion(calificacion.toEntity()));
    }

    /**
     * <h1>GET /api/comentarios : Obtener todas los comentairos.</h1>
     * 
     * <pre>Busca y devuelve todos los comentarios que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas los comentarios de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CalidicacionDetailDTO} - Los comentarios encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<CalificacionDTO> getCalificaciones(@PathParam("mensajeroId") Long mensajeroId) {
        if(logicMensajero.getMensajero(mensajeroId)==null) 
            throw new WebApplicationException("no existe el Mensajero con el id" + mensajeroId, 404);
         return listEntityToDTO(logicMensajero.getMensajero(mensajeroId).getCalificaciones());
    }

    /**
     * <h1>GET /api/comentarios/{id} : Obtener comentairo por id.</h1>
     * 
     * <pre>Busca el cometario con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el comentario correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un comentario con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del comentario que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CalidicacionDetailDTO} - El comentario buscado
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("id") Long id) {
        if(logica.getCalificacion(id)== null)
            throw new WebApplicationException("no existe la calidicacion con el id " + id, 404);
        return new CalificacionDTO(logica.getCalificacion(id));
    }
    
    /**
     * <h1>PUT /api/comentarioss/{id} : Actualizar ciudad con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CalificacionDTO}.
     * 
     * Actualiza el comentario con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el comentario con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un comentario con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del comentario que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param calificacion {@link CalificacionDTO} El comentario que se desea guardar.
     * @return JSON {@link CalificacionDTO} - El comentario guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el comentario porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("mensajeroId") Long mensajeroId, @PathParam("id") Long id, CalificacionDTO comentario) throws BusinessLogicException {
        if(logicMensajero.getMensajero(mensajeroId)==null)
            throw new WebApplicationException("no existe el Mensajero con el id " + mensajeroId, 404);
        if(logica.getCalificacion(id)==null){
            throw new WebApplicationException("La calificacion  con id" + id + "no existe",404);
        }

        return new CalificacionDTO(logica.updateCalificacion(comentario.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/comentarioss/{id} : Borrar comentario por id.</h1>
     * 
     * <pre>Borra el comentario con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el comentario correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un comentario con el id dado.
     * </code>
     * </pre>
     * @param id Identificador decomentario que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCalificacion(@PathParam("mensajeroId") Long mensajeroId,@PathParam("id") Long id) throws BusinessLogicException {
        if(logicMensajero.getMensajero(mensajeroId)==null)
            throw new WebApplicationException("no existe el Mensajero con el id " + mensajeroId, 404);
        
         if(logica.getCalificacion(id)==null){
            throw new WebApplicationException("La calificacion  con id" + id + "no existe",404);
        }
       else{
           logica.deleteCalificacion(logica.getCalificacion(id));
       }
     }
     
     /**
      * Convierte una lista de Entity en una lista de DTOs
      * @param califiaciones 
      * @return Una lista de CalifiacionDetailDTO
      */
     public List<CalificacionDTO>  listEntityToDTO(List<CalificacionEntity> calificaciones)
    {
        List<CalificacionDTO> retorno = new ArrayList<>();
        for(CalificacionEntity x: calificaciones)
            retorno.add(new CalificacionDTO(x));
        return retorno;
    }
}
