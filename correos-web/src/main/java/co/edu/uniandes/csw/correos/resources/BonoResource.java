/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.List; 
import java.util.ArrayList; 
import javax.enterprise.context.RequestScoped;
import co.edu.uniandes.csw.correos.dtos.BonoDTO;


/**
 * Clase que implementa el retorno "Bonos"
 * URL: /api/Bonos
 * </pre>
 * Path: Indica la dirección d "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestedScoped: Inicia una transacción desde el llamado de cada método (servicio)
 * </pre>
 * @author t.vargas10
 */

@Path("bonos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class BonoResource 
{    
    /**
     * <h1>POST /api/Bonos: Crear un bono.<h1>
     * 
     * <pre> Cuerpo de la petición: JSON {@link BonoDTO}
     * 
     * Crea un nueo bono con la información que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 412 Preconditition Failed: Ya existe el bono
     * </code>
     * </pre>
     * @param nuevo {@link BonoDTO} - El bono que se desea guardar
     * @return JSON {@link BonoDTO} - El Bono generado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existeel bono
     */
    @POST
    public BonoDTO createBono(BonoDTO nuevo)
    {
        return nuevo;
    }
     /**
     * <h1>PUT /api/Bonos: Actualizar el bonocon el id dado.<h1>
     * 
     * <pre> Cuerpo de la petición: JSON {@link BonoDTO}
     * 
     * Actualiza el bono con el id dado por la URL con la información que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 404 Not found. No existe el bono con el id dado.
     * </code>
     * </pre>
     * @param nuevo {@link BonoDTO} - El bono que se desea guardar
     * @return JSON {@link BonoDTO} - El Bono guardado
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que no permite actualizar el bono.
     */
    @PUT
    @Path("{id: \\d+}")
    public BonoDTO updateBono (@PathParam("id") Long id, BonoDTO actualizar)
    {
        return actualizar;
    }
     /**
     * <h1>GET /api/Bonos: Retornar el bono con el id dado..<h1>
     * 
     * <pre> Busca el id con el bono asociado recibido en la URL y lo devuelve
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
     * @param nuevo id identificador del bono que se esta buscando.
     * @return JSON {@link BonoDTO} - El Bono buscado
     */
    @GET
    @Path("{id: \\d+}")
    public BonoDTO getBono (@PathParam("id")Long id)
    {
        return null;
    }
    
    @GET
    public List<BonoDTO> getBonos()
    {
        return new ArrayList<>();
    }
     /**
     * <h1>DELETE /api/Bonos: Borrar el bono con el id dado.<h1>
     * 
     * <pre> Borra el bono con el id asociado recibido en la URL.
     * 
     * Codigos de respuesta:
     * <code style = "color": mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo bono
     * </code>
     * <code style = "color: #c7254e; background-color: #f9f2f4;">
     * 404 Not found. No existe el bono con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del bono que se desea borrar.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBono (@PathParam("id") Long id)
    {
        //Implementacion pendiente
    }
}























