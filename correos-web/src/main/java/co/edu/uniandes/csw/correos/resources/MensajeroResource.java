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

import co.edu.uniandes.csw.correos.dtos.MensajeroDTO;
import co.edu.uniandes.csw.correos.dtos.MensajeroDetailDTO;
import co.edu.uniandes.csw.correos.ejb.MensajeroLogic;
import co.edu.uniandes.csw.correos.ejb.ZonaLogic;
import co.edu.uniandes.csw.correos.ejb.ZonaMensajeroLogic;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
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
 * <pre>Clase que implementa el recurso "mensajeros".
 * URL: /api/mensajeros
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "mensajeros".</i>
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

@Path("mensajeros")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MensajeroResource {
    
    
    
    private MensajeroLogic logic;
    
    private ZonaMensajeroLogic zonaMensajeroLogic;
    
    private ZonaLogic zonaLogic;
    
    
    /**
     * constructor con params
     * @param logic
     * @param zonaMensajeroLogic
     * @param zonaLogic 
     */
    @Inject
    public MensajeroResource(MensajeroLogic logic, ZonaMensajeroLogic zonaMensajeroLogic, ZonaLogic zonaLogic)
    {
        this.logic=logic;
        this.zonaMensajeroLogic=zonaMensajeroLogic;
        this.zonaLogic=zonaLogic;
    }
    
    /**
     * constructor
     */
    public MensajeroResource()
    {
        this.logic=null;
        this.zonaMensajeroLogic=null;
        this.zonaLogic=null;
    }
    
    /**
     * <h1>POST /api/mensajeros : Crear un mensajero.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link MensajeroDetailDTO}.
     * 
     * Crea un nuevo mensajero con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo Mensajero .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el mensajero.
     * </code>
     * </pre>
     * @param mensajero {@link MensajeroDetailDTO} - El mensajero que se desea guardar.
     * @return JSON {@link MensajeroDetailDTO}  - El mensajero guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el Mensajero.
     */
    @POST
    public MensajeroDetailDTO createMensajero(MensajeroDetailDTO mensajero) throws BusinessLogicException
    {
        mensajero.setOcupado(false);
        mensajero.setCalificacionPromedio(0.0);
        return new MensajeroDetailDTO(logic.createMensajero(mensajero.toEntity()));
    }
    
    /**
     * <h1>PUT /api/cities/{id} : Actualizar mensajero con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MensajeroDetailDTO}.
     * 
     * Actualiza el mensajero con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el mensajero con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un mensajero con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del mensajero que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param mensajero {@link MensajeroDetailDTO} El Mensajero que se desea guardar.
     * @return JSON {@link MensajeroDetailDTO} - El mensajero guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el mensajero porque ya existe uno con ese correo o numero telefónico.
     */
    @PUT
    @Path("{id:\\d+}")
    public MensajeroDetailDTO updateMensajero(@PathParam("id") Long id , MensajeroDetailDTO mensajero) throws BusinessLogicException
    {
        if(logic.getMensajero(id)==null) 
            throw new WebApplicationException("El mensajero con id" + id,404);
        mensajero.setId(id);
        return new MensajeroDetailDTO(logic.putMensajero(mensajero.toEntity()));
    }
    
    /**
     * <h1>GET /api/mensajeros/{id} : Obtener mensajero por id.</h1>
     * 
     * <pre>Busca el mensajero con el id asociado recibido en la URL y lo devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el mensajero correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un mensajero con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del mensajero que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link MensajeroDetailDTO} - el mensajero buscado
     */
    @GET
    @Path("{id:\\d+}")
    public MensajeroDetailDTO getMensajero(@PathParam("id") Long id) throws BusinessLogicException
    {
        if(logic.getMensajero(id)==null) 
            throw new WebApplicationException("El Mensajero con id" + id,404);
        return new MensajeroDetailDTO(logic.getMensajero(id));
    }
    
    /**
     * le pone a un mensajero una zona
     * @param id
     * @param zonaId
     * @return 
     */
    @PUT
    @Path("zona/{id:\\ d+}/{zonaId:\\d+}")
    public MensajeroDetailDTO agregarZona(@PathParam("id") Long id, @PathParam("zonaId") Long zonaId)
    {
        ZonaEntity zona= zonaLogic.getZona(zonaId);
        MensajeroEntity mensajero= logic.getMensajero(id);
        
        zonaMensajeroLogic.agregarRelacion(mensajero, zona);
        
        return new MensajeroDetailDTO(logic.getMensajero(id));
    }
    /**
     * <h1>GET /api/mensajeros : Obtener todos los mensajeros.</h1>
     * 
     * <pre>Busca y devuelve todos los mensajeros que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los mensajeros de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link MensajeroDTO} - Los mensajeros encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<MensajeroDetailDTO> getMensajeros()
    {
        return listEntity2DTO(logic.getMensajeros());
    }
    
    /**
     * <h1>DELETE /api/mensajeros/{id} : Borrar mensajero por id.</h1>
     * 
     * <pre>Borra el mensajero con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el mensajero correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un mensajero con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del mensajero que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id:\\d+}")
    public void deleteMensajero(@PathParam("id") Long id) throws BusinessLogicException
    {
        if(logic.getMensajero(id)==null) 
            throw new WebApplicationException("El Mensajero con el id" + id ,404);
        logic.deleteMensajero(logic.getMensajero(id));
    }
    
    /**
     * 
     * @param mensajeros
     * @return lista de mensajeros en detailDto
     */
    public List<MensajeroDetailDTO>  listEntity2DTO(List<MensajeroEntity> mensajeros)
    {
        List<MensajeroDetailDTO> retorno = new ArrayList<>();
        for(MensajeroEntity x: mensajeros)
            retorno.add(new MensajeroDetailDTO(x));
        return retorno;
    }
    
}
