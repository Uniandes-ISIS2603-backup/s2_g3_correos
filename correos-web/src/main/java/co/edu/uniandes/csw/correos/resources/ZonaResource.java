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


import co.edu.uniandes.csw.correos.dtos.ZonaDetailDTO;
import co.edu.uniandes.csw.correos.ejb.ZonaLogic;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
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

/**
 * <pre>Clase que implementa el recurso "zonas".
 * URL: /api/zonas
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
 * @author ISIS2603  
 * @version 1.0
 */
@Path("zonas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ZonaResource {
    
    
    private ZonaLogic logica;

    @Inject
    public ZonaResource(ZonaLogic logica) {
        this.logica = logica;
    }

    public ZonaResource() {
        this.logica = null;
    }
    
    /**
     * <h1>POST /api/cities : Crear una zona.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ZonaDetailDTO}.
     * 
     * Crea una nueva zona con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva zona .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la zona.
     * </code>
     * </pre>
     * @param zona {@link ZonaDetailDTO} - La zona que se desea guardar.
     * @return JSON {@link ZonaDetailDTO}  - La zona guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la zona.
     */
    @POST
    public ZonaDetailDTO createZona(ZonaDetailDTO zona) throws BusinessLogicException {
        return new ZonaDetailDTO(logica.createZona(zona.toEntity()));
    }

    /**
     * <h1>GET /api/zonas : Obtener todas las zonas.</h1>
     * 
     * <pre>Busca y devuelve todas las zonas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las zonas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ZonaDetailDTO} - Las zonas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ZonaDetailDTO> getZonas() {
        return listEntityToDTO(logica.getZonas());
    }

    /**
     * <h1>GET /api/cities/{id} : Obtener zona por id.</h1>
     * 
     * <pre>Busca la zona con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la zona correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una zona con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la ciudad que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ZonaDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public ZonaDetailDTO getZona(@PathParam("id") Long id) {
        return new ZonaDetailDTO(logica.getZona(id));
    }
    
    /**
     * <h1>PUT /api/zonas/{id} : Actualizar zona con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ZonaDetailDTO}.
     * 
     * Actualiza la zona con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la zona con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una zona con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la zona que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param zona {@link ZonaDetailDTO} La zona que se desea guardar.
     * @return JSON {@link ZonaDetailDTO} - La zona guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la zona porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public ZonaDetailDTO updateZona(@PathParam("id") Long id, ZonaDetailDTO zona) throws BusinessLogicException {
        return new ZonaDetailDTO(logica.updateZona(zona.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/zonas/{id} : Borrar ciudad por id.</h1>
     * 
     * <pre>Borra la zona con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la zona correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una zona con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la zona que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteZona(@PathParam("id") Long id) throws BusinessLogicException {
        logica.deleteZona(logica.getZona(id));
    }
      /**
      * Convierte una lista de Entity en una lista de DTOs
      * @param zona 
      * @return Una lista de ZonaDetailDTO
      */
     public List<ZonaDetailDTO>  listEntityToDTO(List<ZonaEntity> zonas)
    {
        List<ZonaDetailDTO> retorno = new ArrayList<>();
        for(ZonaEntity x: zonas)
            retorno.add(new ZonaDetailDTO(x));
        return retorno;
    }
}
