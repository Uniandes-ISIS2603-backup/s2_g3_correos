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
import co.edu.uniandes.csw.correos.dtos.TarjetaCreditoDetailDTO
        ;
import co.edu.uniandes.csw.correos.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
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
 * <pre>Clase que implementa el recurso "tarjetaCredito".
 * URL: /api/tarjetasCredito
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "tarjetaCredito".</i>
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
@Path("tarjetasCredito")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TarjetaCreditoResource {

     @Inject
    private TarjetaCreditoLogic logic;
    
    /**
     * <h1>POST /api/tarjetasCredito : Crear una tarjeta de credito.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDetailDTO}.
     * 
     * Crea un nueva nueva tarjeta con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva tarjeta .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la tarjeta.
     * </code>
     * </pre>
     * @param nuevo {@link TarjetaCreditoDetailDTO} - La tarjeta que se desea guardar.
     * @return JSON {@link TarjetaCreditoDetailDTO}  - La tarjeta que se guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la tarjeta credito.
     */
     @POST
     public TarjetaCreditoDetailDTO createTarjeteaCredito(TarjetaCreditoDetailDTO nuevo) throws BusinessLogicException
     {
         return new TarjetaCreditoDetailDTO(logic.createTarjetaCredito(nuevo.toEntity()));
     }
     /**
     * <h1>PUT /api/tarjetasCredito/{id} : Actualizar tarjeta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDetailDTO}.
     * 
     * Actualiza la tarjeta con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la tarjeta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una tarjeta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la tarjeta que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param actualizar {@link TarjetaCreditoDetailDTO} La tarjeta que se desea guardar.
     * @return JSON {@link TarjetaCreditoDetailDTO} - La tarjeta guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la tarjeta porque ya existe.
     */
     @PUT
     @Path("{id: \\d+ }")
     public TarjetaCreditoDetailDTO updateTarjeteCredito(@PathParam("id") Long id , TarjetaCreditoDetailDTO actualizar) throws BusinessLogicException
     {
         if(logic.getTarjetaCredito(id)==null) 
            throw new WebApplicationException("La tarjeta con id" + id,404);
        actualizar.setId(id);
        return new TarjetaCreditoDetailDTO(logic.updateTarjetaCredito(actualizar.toEntity()));
     }
   /**
  * <h1>GET /api/tarjetasCredito/{id} : Obtener tarjetas por id.</h1>
  * 
  * <pre>Busca la tarjeta con el id asociado recibido en la URL y la devuelve.
  * 
  * Codigos de respuesta:
  * <code style="color: mediumseagreen; background-color: #eaffe0;">
  * 200 OK Devuelve la tarjeta correspondiente al id.
  * </code> 
  * <code style="color: #c7254e; background-color: #f9f2f4;">
  * 404 Not Found No existe una tarjeta con el id dado.
  * </code> 
  * </pre>
  * @param id Identificador de la tarjeta que se esta buscando. Este debe ser una cadena de dígitos.
  * @return JSON {@link TarjetaCreditoDetailDTO} - La tarjeta buscada
  */
     @GET
     @Path("{id: \\d+ }")
     public TarjetaCreditoDetailDTO getTarjeta(@PathParam("id") Long id)
     {
        if(logic.getTarjetaCredito(id)==null) 
            throw new WebApplicationException("La tarjeta con id" + id,404);
        return new TarjetaCreditoDetailDTO(logic.getTarjetaCredito(id));
     }
     /**
     * <h1>GET /api/tarjetasCredito : Obtener todas las tarjetas.</h1>
     * 
     * <pre>Busca y devuelve todas las tarjetas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las tarjetas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link TarjetaCreditoDetailDTO} - Las tarjetas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
     
     
     @GET
     public List<TarjetaCreditoDTO> getTarjetaCredito()
     {
         return listEntity2DTO(logic.getTarjetasCredito());
     }
     
     @DELETE
     @Path("{id: \\d+ }")
     public void deleteTarjetaCredito(@PathParam("id") Long id) throws BusinessLogicException
     {
         if(logic.getTarjetaCredito(id)==null) 
            throw new WebApplicationException("El Mensajero con id" + id ,404);
        logic.deleteTarjetaCredito(id);
    }
    
    public List<TarjetaCreditoDTO>  listEntity2DTO(List<TarjetaCreditoEntity> tarjetasCredito)
    {
        List<TarjetaCreditoDTO> retorno = new ArrayList<>();
        for(TarjetaCreditoEntity x: tarjetasCredito)
            retorno.add(new TarjetaCreditoDTO(x));
        return retorno;
    }
     
}
