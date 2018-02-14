/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.PagoDTO;
import co.edu.uniandes.csw.correos.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import java.util.LinkedList;
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
 *
 * @author a.silvag
 */

@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
    
    /** <h1>POST /api/pago : Crear un pago.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Crea un nuevo pago con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo pago .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el pago
     * </pre>
     * @param pago {@link PagoDetailDTO} - el pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO}  - el pago guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el pago.
     */
@POST
public PagoDetailDTO createPago(PagoDetailDTO pago)throws BusinessLogicException{
    return pago;
}
/**
     * <h1>PUT /api/cities/{id} : Actualizar pago con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Actualiza el pago con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el pago con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pagoevento que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pago {@link PagoDetailDTO} El pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO} - El pago guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el pago porque ya existe uno con ese correo o numero telefónico.
     */
    @PUT
    @Path("{id: \\d+}")
    public PagoDetailDTO updatePago(@PathParam("id") Long id , PagoDetailDTO pago) throws BusinessLogicException{
        return pago;
    }
    /**
     * <h1>GET /api/pagos/{id} : Obtener pagos por id.</h1>
     * 
     * <pre>Busca elpago con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el pago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un pago con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PagoDetailDTO} - El evento buscado
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPago(@PathParam("id") Long id){
        return null;
    }
    /**
     * <h1>GET /api/pagos : Obtener todos los pagos.</h1>
     * 
     * <pre>Busca y devuelve todos los pagos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los pagos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PagoDTO} - Los pagos encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<PagoDTO> getPagos(){
        return new LinkedList<>();
    }
    /**
     * <h1>DELETE /api/pagos/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra elpago con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePago(@PathParam("id") Long id){
        //en espera de implementacion
    }

}
