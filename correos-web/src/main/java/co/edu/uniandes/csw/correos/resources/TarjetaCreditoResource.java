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
 * <pre>Clase que implementa el recurso "tarjetaCredito".
 * URL: /api/tarjetaCredito
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

     @POST
     public TarjetaCreditoDetailDTO createCliente(TarjetaCreditoDetailDTO nuevo) throws BusinessLogicException
     {
         return nuevo;
     }
     
     @PUT
     @Path("{id: \\d+ }")
     public TarjetaCreditoDetailDTO updateCliente(@PathParam("id") Long id , TarjetaCreditoDetailDTO actualizar) throws BusinessLogicException
     {
         return actualizar;
     }
     
     @GET
     @Path("{id: \\d+ }")
     public TarjetaCreditoDetailDTO getCliente(@PathParam("id") Long id)
     {
         return null;
     }
     
     @GET
     public List<TarjetaCreditoDTO> getTarjetaCredito()
     {
         return new ArrayList<>();
     }
     
     @DELETE
     @Path("{id: \\d+ }")
     public void deleteTarjetaCredito(@PathParam("id") Long id)
     {
         //lo hago despues :'v 
     }
     
     
}
