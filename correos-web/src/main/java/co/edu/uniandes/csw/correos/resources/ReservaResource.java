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

import co.edu.uniandes.csw.correos.dtos.ReservaDTO;
import co.edu.uniandes.csw.correos.dtos.ReservaDetailDTO;
import co.edu.uniandes.csw.correos.ejb.ClienteLogic;
import co.edu.uniandes.csw.correos.ejb.ReservaLogic;
import co.edu.uniandes.csw.correos.entities.ReservaEntity;
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
 * <pre>Clase que implementa el recurso "reservas".
 * URL: /api/reservas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "reservas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author l.mejia  
 * @version 1.0
 */
@Path("reservas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ReservaResource {
 
    ReservaLogic logic;
    

    ClienteLogic logicCliente;
    
    /**
     * constructor con params
     * @param rL
     * @param cL 
     */
    @Inject
    public ReservaResource(ReservaLogic rL, ClienteLogic cL)
    {
        logic=rL;
        logicCliente=cL;
    }
    
    /**
     * constructor
     */
    public ReservaResource()
    {
        logic=null;
        logicCliente=null;
    }
    /**
     * <h1>POST /api/reservas : Crear una reserva.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ReservaDetailDTO}.
     * 
     * Crea un nuevo reserva con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva reserva .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la reserva.
     * </code>
     * </pre>
     * @param reserva {@link ReservaDetailDTO} - La reserva que se desea guardar.
     * @return JSON {@link ReservaDetailDTO}  - La reserva guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la Reserva.
     */
    @POST
    
    public ReservaDetailDTO createReserva(ReservaDetailDTO reserva) throws BusinessLogicException
    {
        
       return new ReservaDetailDTO (logic.createReserva(reserva.toEntity()));

    }
    
    /**
     * <h1>PUT /api/reservas/{id} : Actualizar la reserva con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ReservaDetailDTO}.
     * 
     * Actualiza la reserva con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la reserva con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una reserva con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del mensajero que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param reserva {@link ReservaDetailDTO} La reserva que se desea guardar.
     * @return JSON {@link MensajeroDetailDTO} - La Reserva guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public ReservaDetailDTO updateReserva(@PathParam("clienteId") Long idCliente, @PathParam("id") Long id , ReservaDetailDTO reserva) throws BusinessLogicException
    {
        if(logic.getReserva(id)==null) 
            throw new WebApplicationException("La Reserva con id " + id,404);
        reserva.setId(id);
        return new ReservaDetailDTO(logic.putReserva(reserva.toEntity()));
    }
    

    /**
     * <h1>GET /api/reservas/{id} : Obtener reserva por id.</h1>
     * 
     * <pre>Busca la reserva con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la reserva correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una reserva con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la reserva que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ReservaDetailDTO} - la reserva buscada
     */
    @GET
    @Path("{id: \\d+}")
    public ReservaDetailDTO getReserva(@PathParam("id") Long id) throws BusinessLogicException
    {
      
        if(logic.getReserva(id)==null) 
            throw new WebApplicationException("La Reserva con id " + id,404);
        return new ReservaDetailDTO(logic.getReserva(id));
    }
    
    /**
     * <h1>GET /api/reservas : Obtener todas las reservas.</h1>
     * 
     * <pre>Busca y devuelve todas las reservas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las reservas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ReservaDTO} - Las reservas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ReservaDetailDTO> getReservas()
    {
        
        return listEntity2DTO(logic.getReservas());
        
    }
    
    /**
     * <h1>DELETE /api/reservas/{id} : Borrar reserva por id.</h1>
     * 
     * <pre>Borra la reserva con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la reserva correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una reserva con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la  reserva que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva( @PathParam("id") Long id) throws BusinessLogicException
    {
        if(logic.getReserva(id)==null) 
            throw new WebApplicationException("La Reserva con id " + id,404);
        logic.deleteReserva(logic.getReserva(id));
       
    }
    
    
    /**
     * 
     * @param reservas
     * @return lista de las reservas en dto
     */
    public List<ReservaDetailDTO>  listEntity2DTO(List<ReservaEntity> reservas)
    {
        List<ReservaDetailDTO> retorno = new ArrayList<>();
        for(ReservaEntity x: reservas)
            retorno.add(new ReservaDetailDTO(x));
        return retorno;
    }
}
