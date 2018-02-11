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

import co.edu.uniandes.csw.correos.dtos.TransporteDTO;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
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
 * <pre>Clase que implementa el recurso "transportes".
 * URL: /api/transportes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "transportes".</i>
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
@Path("transportes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TransporteResource {
    
    /**
     * <h1>POST /api/transportes : Crear un transporte.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link TrasnporteDTO}.
     * 
     * Crea un nuevo transporte con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo transporte .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el transporte.
     * </code>
     * </pre>
     * @param trasnporte {@link TrasporteDTO} - El transporte que se desea guardar.
     * @return JSON {@link transporteDTO}  - El transporte guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el Trasnporte.
     */
    @POST
    public TransporteDTO createTransporte(TransporteDTO trasnporte) throws BusinessLogicException
    {
        return trasnporte;
    }
    
    /**
     * <h1>PUT /api/transportes/{id} : Actualizar transporte con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link TransporteDTO}.
     * 
     * Actualiza el transporte con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el transporte con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un transporte con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del mensajero que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param transporte {@link TransporteDTO} El Transporte que se desea guardar.
     * @return JSON {@link TransporteDTO} - El traansporte guardado.
     */
    @PUT
    @Path("{id: \\d+}")
    public TransporteDTO updateTransporte(@PathParam("id") Long id , TransporteDTO transporte)
    {
        return transporte;
    }
    
    /**
     * <h1>GET /api/transportes/{id} : Obtener transporte por id.</h1>
     * 
     * <pre>Busca el transporte con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el transporte correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un transporte con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del transporte que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link TransporteDTO} - el transporte buscado
     */
    @GET
    @Path("{id: \\d+}")
    public TransporteDTO getTransporte(@PathParam("id") Long id)
    {
        return null;
    }
    
    /**
     * <h1>GET /api/transportes : Obtener todos los transportes.</h1>
     * 
     * <pre>Busca y devuelve todos los transportes que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los transportes de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link TransporteDTO} - Los transportes encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<TransporteDTO> getTransportes()
    {
        return new ArrayList<>();
    }
    
    /**
     * <h1>DELETE /api/transportes/{id} : Borrar transporte por id.</h1>
     * 
     * <pre>Borra el transporte con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el transporte correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un transporte con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del transporte que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransporte(@PathParam("id") Long id)
    {
        //en espera de implementacion
    }
    
    
    
}
