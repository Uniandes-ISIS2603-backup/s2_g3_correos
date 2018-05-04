/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.PagoDTO;
import co.edu.uniandes.csw.correos.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.correos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.correos.ejb.PagoLogic;
import co.edu.uniandes.csw.correos.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.entities.PagoEntity;
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
 *
 * @pago a.silvag
 */

@Path("cuentasBancarias/{cuentaBancariaId:\\d+}/pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
    
    
    private PagoLogic pagoLogic;
    
    private CuentaBancariaLogic logicCuentas;
    
    private TarjetaCreditoLogic logicTarjetas;
    
    @Inject
    public PagoResource(PagoLogic pL, CuentaBancariaLogic cBL, TarjetaCreditoLogic lT)
    {
        pagoLogic=pL;
        logicCuentas=cBL;
        logicTarjetas=lT;
    }
    
    public PagoResource()
    {
        pagoLogic=null;
        logicCuentas=null;
        logicTarjetas=null;
    }
    
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
public PagoDetailDTO createPago(@PathParam("cuentaBancariaId") Long cuentaBancariaId, PagoDetailDTO pago)throws BusinessLogicException{
    
    if(logicCuentas.getCuentaBancaria(cuentaBancariaId)==null){
        throw new WebApplicationException("no existe la cuenta bancaria");
    }
    PagoEntity pe = pago.toEntity();
    CuentaBancariaEntity cbe = logicCuentas.getCuentaBancaria(cuentaBancariaId);
    pe.setCuentaBancaria(cbe);
    cbe.getPagos().add(pe);
    return new PagoDetailDTO(pagoLogic.createPago(pe));
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
    public PagoDetailDTO updatePago(@PathParam("cuentaBancariaId")Long idCuentaBancaria, @PathParam("id") Long id , PagoDetailDTO pago) throws BusinessLogicException{
        
        
        if(logicCuentas.getCuentaBancaria(idCuentaBancaria)==null){
            throw new WebApplicationException("No existe esa cuenta bancaria");
        }
        if(pagoLogic.getPago(id) == null){
            throw new WebApplicationException("El recurso /cuentasBancarias/" + idCuentaBancaria + "/reviews/" + id + " no existe.", 404);
        }
               pago.setId(id);
       PagoEntity evento2=pago.toEntity();
       evento2.setCuentaBancaria(logicCuentas.getCuentaBancaria(idCuentaBancaria));
       pagoLogic.updatePago(evento2);
        return new PagoDetailDTO(pago.toEntity());
        
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
    public PagoDetailDTO getPago(@PathParam("cuentaBancariaId") Long cuentaBancariaId, @PathParam("id") Long id){
        if(logicCuentas.getCuentaBancaria(cuentaBancariaId)==null){
            throw new WebApplicationException("No existe esta cuenta bancaria");
        }
        if (pagoLogic.getPago(id) == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        return new PagoDetailDTO(pagoLogic.getPago(id));
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
    private List<PagoDetailDTO> listEntity2DTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDetailDTO(entity));
        }
        return list;
    }
    @GET
    public List<PagoDetailDTO> getPagos(@PathParam("cuentaBancariaId") Long cuentaBancariaId) throws BusinessLogicException{
       if(logicCuentas.getCuentaBancaria(cuentaBancariaId)==null){
           throw new WebApplicationException("no existe la cuenta ");
       }
        
        return listEntity2DTO(logicCuentas.getCuentaBancaria(cuentaBancariaId).getPagos());
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
    public void deletePago(@PathParam("cuentaBancariaId") Long cuentaBancariaId,@PathParam("id") Long id) throws BusinessLogicException{
        //en espera de implementacion
        if(logicCuentas.getCuentaBancaria(cuentaBancariaId)==null){
            throw new WebApplicationException("Ese id no corresponde a una cuenta bancaria");
        }
        PagoEntity entity = pagoLogic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        logicCuentas.deletePago(cuentaBancariaId,id);
    }

}
