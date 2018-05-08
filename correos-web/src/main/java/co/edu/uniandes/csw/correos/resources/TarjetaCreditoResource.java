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

import co.edu.uniandes.csw.correos.dtos.TarjetaCreditoDTO;
import co.edu.uniandes.csw.correos.dtos.TarjetaCreditoDetailDTO;
import co.edu.uniandes.csw.correos.ejb.ClienteLogic;
import co.edu.uniandes.csw.correos.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
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
 * <pre>Clase que implementa el recurso "tarjetasCredito".
 * URL: /api/tarjetasCredito
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "tarjetasCredito".</i>
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
@Path("clientes/{clienteId:\\d+}/tarjetasCredito")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TarjetaCreditoResource {

    private TarjetaCreditoLogic logic;
    
    private ClienteLogic logicCliente;
    
    /**
     * constructor con params
     * @param logic
     * @param logicCliente 
     */
    @Inject
    public TarjetaCreditoResource(TarjetaCreditoLogic logic, ClienteLogic logicCliente) {
        this.logic = logic;
        this.logicCliente = logicCliente;
    }
    
    /**
     * constructor
     */
    public TarjetaCreditoResource()
    {
        this.logic = null;
        this.logicCliente = null;
    }

    
    /**
     * <h1>POST /api/tarjetasCredito : Crear un tarjetaCredito.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link TrasnporteDTO}.
     * 
     * Crea un nuevo tarjetaCredito con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo tarjetaCredito .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el tarjetaCredito.
     * </code>
     * </pre>
     * @param tarjetaCredito {@link TarjetaCreditoDTO} - El tarjetaCredito que se desea guardar.
     * @return JSON {@link tarjetaCreditoDTO}  - El tarjetaCredito guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el Trasnporte.
     */
    @POST
    public TarjetaCreditoDTO createTarjetaCredito(@PathParam("clienteId") Long clienteId, TarjetaCreditoDTO tarjetaCredito) throws BusinessLogicException
    {
        if(logicCliente.getCliente(clienteId)==null) 
            throw new WebApplicationException("no existe el Cliente con id" + clienteId, 404);
         TarjetaCreditoEntity pe = tarjetaCredito.toEntity();
         ClienteEntity cbe = logicCliente.getCliente(clienteId);
         pe.setCliente(cbe);
         cbe.getTarjetasCredito().add(pe);
         return new TarjetaCreditoDetailDTO(logic.createTarjetaCredito(pe));
    }
    
    /**
     * <h1>PUT /api/tarjetasCredito/{id} : Actualizar tarjetaCredito con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDTO}.
     * 
     * Actualiza el tarjetaCredito con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el tarjetaCredito con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un tarjetaCredito con el id dado.
     * </code> 
     * </pre>
     * @param clienteId
     * @param id Identificador del cliente que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param tarjetaCredito {@link TarjetaCreditoDTO} El TarjetaCredito que se desea guardar.
     * @return JSON {@link TarjetaCreditoDTO} - El traansporte guardado.
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaCreditoDTO updateTarjetaCredito(@PathParam("clienteId") Long clienteId, @PathParam("id") Long id , TarjetaCreditoDTO tarjetaCredito) throws BusinessLogicException
    {
        if(logicCliente.getCliente(clienteId)==null)
            throw new WebApplicationException("no existe el Cliente con el id " + clienteId, 404);
        if(logic.getTarjetaCredito(id)==null)
            throw new WebApplicationException("no existe el TarjetaCredito con el id " + id, 404);
        tarjetaCredito.setId(id);
       TarjetaCreditoEntity variable = tarjetaCredito.toEntity();
       variable.setCliente(logicCliente.getCliente(clienteId));
       logic.updateTarjetaCredito(variable);
        return new TarjetaCreditoDetailDTO(tarjetaCredito.toEntity());
    }
    
    /**
     * <h1>GET /api/tarjetasCredito/{id} : Obtener tarjetaCredito por id.</h1>
     * 
     * <pre>Busca el tarjetaCredito con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el tarjetaCredito correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un tarjetaCredito con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del tarjetaCredito que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link TarjetaCreditoDTO} - el tarjetaCredito buscado
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaCreditoDTO getTarjetaCredito(@PathParam("clienteId") Long clienteId,@PathParam("id") Long id)
    {
        if(logicCliente.getCliente(clienteId)==null)
            throw new WebApplicationException("no existe el cliente con ese id " + clienteId, 404);
        if(logic.getTarjetaCredito(id)==null)
            throw new WebApplicationException("no existe el TarjetaCredito con ese id " + id, 404);
        return new TarjetaCreditoDTO(logic.getTarjetaCredito(id));
    }
    
    /**
     * <h1>GET /api/tarjetasCredito : Obtener todos los tarjetasCredito.</h1>
     * 
     * <pre>Busca y devuelve todos los tarjetasCredito que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los tarjetasCredito de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link TarjetaCreditoDTO} - Los tarjetasCredito encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<TarjetaCreditoDTO> getTarjetasCredito(@PathParam("clienteId") Long clienteId)
    {
        if(logicCliente.getCliente(clienteId)==null)
            throw new WebApplicationException("no existe el cliente " + clienteId, 404);
        return listEntity2DTO(logicCliente.getCliente(clienteId).getTarjetasCredito());
    }
    
    /**
     * <h1>DELETE /api/tarjetasCredito/{id} : Borrar tarjetaCredito por id.</h1>
     * 
     * <pre>Borra el tarjetaCredito con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el tarjetaCredito correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un tarjetaCredito con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del tarjetaCredito que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTarjetaCredito(@PathParam("clienteId") Long clienteId,@PathParam("id") Long id) throws BusinessLogicException
    {
        if(logicCliente.getCliente(clienteId)==null)
            throw new WebApplicationException("no existe ese Cliente " + clienteId, 404);
        if(logic.getTarjetaCredito(id)==null)
            throw new WebApplicationException("no existe la Tarjeta de Credito con el id " + id, 404);
        logic.deleteTarjetaCredito( id);
    }
    
    /**
     * 
     * @param tarjetasCredito
     * @return lista de tarjetas de credito en dto
     */
    public List<TarjetaCreditoDTO>  listEntity2DTO(List<TarjetaCreditoEntity> tarjetasCredito)
    {
        List<TarjetaCreditoDTO> retorno = new ArrayList<>();
        for(TarjetaCreditoEntity x: tarjetasCredito)
            retorno.add(new TarjetaCreditoDTO(x));
        return retorno;
    }
}
