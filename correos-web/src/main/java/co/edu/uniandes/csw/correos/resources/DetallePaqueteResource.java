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
 /**
     * <h1>POST /api/DetallePaquetes: Crear un detalle.<h1>
     * 
     * <pre> Cuerpo de la petición: JSON {@link BonoDTO}
     * 
     * Crea un nueo detalle con la información que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con id generado
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 412 Preconditition Failed: Ya existe el bono
     * </code>
     * </pre>
     * @param nuevo {@link BonoDTO} - El detalle que se desea guardar
     * @return JSON {@link BonoDTO} - El detalle generado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el detalle
     */
    @POST
    public DetallePaqueteDTO crearPaquete(DetallePaqueteDTO nuevo)
    {
        return nuevo;
    }
     /**
     * <h1>PUT /api/DetallePquete: Actualizar el detalle con el id dado.<h1>
     * 
     * <pre> Cuerpo de la petición: JSON {@link BonoDTO}
     * 
     * Actualiza el detalle con el id dado por la URL con la información que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 404 Not found. No existe el bono con el id dado.
     * </code>
     * </pre>
     * @param nuevo {@link BonoDTO} - El detalle que se desea guardar
     * @return JSON {@link BonoDTO} - El detalle guardado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que no permite actualizar el detalle.
     */
    @PUT
    @Path("{id: \\d+}")
    public DetallePaqueteDTO updatePaquete (@PathParam("id")Long id, DetallePaqueteDTO actualizar)
    {
        return actualizar;
    }
     /**
     * <h1>GET /api/DetallePaquete: Retornar el detalle con el id dado..<h1>
     * 
     * <pre> Busca el id con el detalle asociado recibido en la URL y lo devuelve
     * 
     * 
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 404 Not found. No existe el bono con el id dado.
     * </code>
     * </pre>
     * @param nuevo id identificador del detalle que se esta buscando.
     * @return JSON {@link BonoDTO} - El detalle buscado
     */
    @GET
    @Path("{id: \\d+}") 
    public DetallePaqueteDTO getDetallePaquete(@PathParam("id") Long id) 
    {
        return null;
    }
    
    
}
