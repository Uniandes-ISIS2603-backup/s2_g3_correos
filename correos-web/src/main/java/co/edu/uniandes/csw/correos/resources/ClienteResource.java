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


import co.edu.uniandes.csw.correos.dtos.ClienteDTO;
import co.edu.uniandes.csw.correos.dtos.ClienteDetailDTO
        ;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
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
 * <pre>Clase que implementa el recurso "cliente".
 * URL: /api/clientes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "clientes".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author da.leon  
 * @version 1.0
 */
@Path("clientes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ClienteResource {

    /**
     * <h1>POST /api/clientes : Crear un cliente.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ClienteDetailDTO}.
     * 
     * Crea un nuevo  Cliente con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo cliente .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el cliente.
     * </code>
     * </pre>
     * @param cliente {@link ClienteDetailDTO} - El cliente  que se desea guardar.
     * @return JSON {@link ClienteDetailDTO}  - El cliente que se guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el cliente.
     */
     @POST
     public ClienteDetailDTO createCliente(ClienteDetailDTO nuevo) throws BusinessLogicException
     {
         return nuevo;
     }
     
/**
     * <h1>PUT /api/clientes/{id} : Actualizar cliente con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ClienteDetailDTO}.
     * 
     * Actualiza el cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el cliente con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un cliente con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del cliente que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param actualizar {@link ClienteDetailDTO} El cliente que se desea guardar.
     * @return JSON {@link ClienteDetailDTO} - El cliente guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el cliente porque ya existe.
     */
     
     @PUT
     @Path("{id: \\d+ }")
     public ClienteDetailDTO updateCliente(@PathParam("id") Long id , ClienteDetailDTO actualizar) throws BusinessLogicException
     {
         return actualizar;
     }
     
  /**
  * <h1>GET /api/clientes/{id} : Obtener clientes por id.</h1>
  * 
  * <pre>Busca el cliente con el id asociado recibido en la URL y la devuelve.
  * 
  * Codigos de respuesta:
  * <code style="color: mediumseagreen; background-color: #eaffe0;">
  * 200 OK Devuelve el cliente correspondiente al id.
  * </code> 
  * <code style="color: #c7254e; background-color: #f9f2f4;">
  * 404 Not Found No existe un cliente con el id dado.
  * </code> 
  * </pre>
  * @param id Identificador del cliente que se esta buscando. Este debe ser una cadena de dígitos.
  * @return JSON {@link ClienteDetailDTO} - El evento buscado
  */
     @GET
     @Path("{id: \\d+ }")
     public ClienteDetailDTO getCliente(@PathParam("id") Long id)
     {
         return null;
     }

        /**
     * <h1>GET /api/clientes : Obtener todos los clientes.</h1>
     * 
     * <pre>Busca y devuelve todos los clientes que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los clientes de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ClienteDetailDTO} - Los clientes encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
     
     @GET
     public List<ClienteDTO> getClientes()
     {
         return new ArrayList<>();
     }
     
     @DELETE
     @Path("{id: \\d+ }")
     public void deleteCliente(@PathParam("id") Long id)
     {
        //se hace despues  
     }
     
     
}
