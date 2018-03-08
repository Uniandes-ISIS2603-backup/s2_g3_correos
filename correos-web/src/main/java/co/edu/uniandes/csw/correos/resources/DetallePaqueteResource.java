/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import java.util.ArrayList; 

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.List; 
import javax.enterprise.context.RequestScoped;
import co.edu.uniandes.csw.correos.dtos.DetallePaqueteDTO;
import co.edu.uniandes.csw.correos.ejb.DetallePaqueteLogic;
import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
     

/**
 * Clase que implementa el retorno "detallesPaquetes"
 * URL: /api/DetallePaquetes
 * </pre>
 * Path: Indica la dirección d "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestedScoped: Inicia una transacción desde el llamado de cada método (servicio)
 * </pre>
 * @author t.vargas10
 */

@Path("detalles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class DetallePaqueteResource {
    
    @Inject
    DetallePaqueteLogic detalleLogic;
 /**
     * <h1>POST /api/detalles : Crear un detalle.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link DetalePaqueteDTO}.
     * 
     * Crea un nuevo detalle con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo detalle .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el detalle.
     * </code>
     * </pre>
     * @param book {@link DetallePaqueteDTO} - EL detalle que se desea guardar.
     * @return JSON {@link DetallePaqueteDTO}  - El detalle guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el detalle.
     */
    @POST
    public DetallePaqueteDTO createReview(DetallePaqueteDTO review) throws BusinessLogicException {
        return new DetallePaqueteDTO(detalleLogic.createDetallePaquete(review.toEntity()));
    }
     /**
     * <h1>PUT /api/detalles/{id} : Actualizar detalle con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link BookDetailDTO}.
     *
     * Actualiza el detalle con el id recibido en la URL con la información que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el detalle con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un detalle con el id dado.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precondition Failes. No se puede actualizar el detalle con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del paquete que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param book {@link DetallePaqueteDTO} El detalle que se desea guardar.
     * @return JSON {@link BookDetailDTO} - El detalle guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra el detalle a actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando no se puede actualizar el detalle.
     */
    @PUT
    @Path("{id: \\d+}")
    public DetallePaqueteDTO updateReview(@PathParam("id") Long id, DetallePaqueteDTO review) throws BusinessLogicException {
        review.setId(id);
        DetallePaqueteEntity entity = detalleLogic.getDetallePaquete(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /detalles/" + id + " no existe.", 404);
        }
        return new DetallePaqueteDTO(detalleLogic.updateDetallePaquete(review.toEntity()));

    }
     /**
     * <h1>GET /api/detalles/{id} : Obtener detalle por id.</h1>
     *
     * <pre>Busca el detalle con el id asociado recibido en la URL y lo devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el detalle correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un detalle con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del detalle que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link DetallePaqueteDTO} - El detalle buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error de lógica que se genera cuando no se encuentra el detalle.
     */
   @GET
    @Path("{id: \\d+}")
    public DetallePaqueteDTO getReview(@PathParam("id") Long id) throws BusinessLogicException {
        DetallePaqueteEntity entity = detalleLogic.getDetallePaquete(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /detalle/" + id + " no existe.", 404);
        }
        return new DetallePaqueteDTO(entity);
    }
    
    /**
     * <h1>DELETE /api/paquetes/{idPaquete}/detalles/{id} : Borrar detalle por id.</h1>
     *
     * <pre>Borra el detalle con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el detalle correspondiente al id dado dentro del paquete.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un detalle con el id dado en el paquete.
     * </code>
     * </pre>
     * @param idBook El ID del paquete del cual se va a eliminar el detalle.
     * @param id El ID del detalle que se va a eliminar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando no se puede eliminar el detalle.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteDetallePaquete(@PathParam("id") Long id) throws BusinessLogicException {
        DetallePaqueteEntity entity = detalleLogic.getDetallePaquete(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /paquetes/" + id + " no existe.", 404);
        }
        detalleLogic.deleteDetallePaquete(id);
    }
    
}
