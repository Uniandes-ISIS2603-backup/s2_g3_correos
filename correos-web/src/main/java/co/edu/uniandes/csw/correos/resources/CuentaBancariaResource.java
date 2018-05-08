/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.CuentaBancariaDTO;
import co.edu.uniandes.csw.correos.dtos.CuentaBancariaDetailDTO;
import co.edu.uniandes.csw.correos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
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
 * @cuentaBancaria a.silvag
 */

@Path("cuentasBancarias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuentaBancariaResource {
  

    CuentaBancariaLogic cuentaBancariaLogic;
    
    /**
     * constructor con params
     * @param cBL 
     */
    @Inject
    public CuentaBancariaResource(CuentaBancariaLogic cBL)
    {
        this.cuentaBancariaLogic=cBL;       
    }

    /**
     * constructor
     */
    public CuentaBancariaResource()
    {
        this.cuentaBancariaLogic=null;       
    }
     /** <h1>POST /api/cuentasBancarias : Crear una cuentaBancaria.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CuentaBancariaDetailDTO}.
     * 
     * Crea una nueva cuanta bancaria con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva cuenta bancaria .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la cuenta bancaria.
     * </code>
     * </pre>
     * @param cuentaBancaria {@link CuentaBancariaDetailDTO} - la cuenta bancaria que se desea guardar.
     * @return JSON {@link CuentaBancariaDetailDTO}  - la cuentaBancaria guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la cuenta bancaria.
     */
    
    @POST
public CuentaBancariaDetailDTO createCuentaBancaria(CuentaBancariaDetailDTO cuentaBancaria)throws BusinessLogicException{
    return new CuentaBancariaDetailDTO(cuentaBancariaLogic.createCuentaBancaria(cuentaBancaria.toEntity()));
}
    /**
     * <h1>PUT /api/cities/{id} : Actualizar cuenta bancaria con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CuentaBancariaDetailDTO}.
     * 
     * Actualiza la cuentaBancaria con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la cuentaBancaria con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cuentaBancaria con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cuentaBancaria que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param cuentaBancaria {@link CuentaBancariaDetailDTO} La cuentaBancaria que se desea guardar.
     * @return JSON {@link CuentaBancariaDetailDTO} - La cuenta bancaria guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la cuenta bancaria porque ya existe uno con ese correo o numero telefónico.
     */
    @PUT
    @Path("{id: \\d+}")
    public CuentaBancariaDetailDTO updateCuentaBancaria(@PathParam("id") Long id , CuentaBancariaDetailDTO cuentaBancaria)throws BusinessLogicException{
        CuentaBancariaEntity entity = cuentaBancaria.toEntity();
        entity.setId(id);
        CuentaBancariaEntity oldEntity = cuentaBancariaLogic.getCuentaBancaria(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La cuentaBancaria no existe", 404);
        }
        entity.setPagos(oldEntity.getPagos());
        return new CuentaBancariaDetailDTO(cuentaBancariaLogic.updateCuentaBancaria(entity));
    }
    
    
        /**
     * <h1>GET /api/cuentasBancarias/{id} : Obtener cuentas bancarias por id.</h1>
     * 
     * <pre>Busca la cuenta bancaria con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la cuenta bancaria correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una cuenta bancaria con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cuenta bancaria que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CuentaBancariaDetailDTO} - la cuenta bancaria buscada
     */
    
    @GET
    @Path("{id: \\d+}")
    public CuentaBancariaDetailDTO getCuentaBancaria(@PathParam("id") Long id){
       CuentaBancariaEntity entity = cuentaBancariaLogic.getCuentaBancaria(id);
        if (entity == null) {
            throw new WebApplicationException("La cuentaBancaria no existe", 404);
        }
        return new CuentaBancariaDetailDTO(entity);
    }
    /**
     * <h1>GET /api/cuentasBancarias : Obtener todas las cuentas bancarias.</h1>
     * 
     * <pre>Busca y devuelve todos las cuentas bancarias que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las cuentas bancarias de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CuentaBancariaDTO} - as ceuntas bancarias encontradas en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    private List<CuentaBancariaDetailDTO> listEntity2DTO(List<CuentaBancariaEntity> entityList) {
        List<CuentaBancariaDetailDTO> list = new ArrayList<>();
        for (CuentaBancariaEntity entity : entityList) {
            list.add(new CuentaBancariaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * 
     * @return todas las cuentas bancarias
     */
    @GET
    public List<CuentaBancariaDetailDTO> getCuentaBancaria(){
        return listEntity2DTO(cuentaBancariaLogic.getCuentasBancarias());
    }
    
    /**
     * <h1>DELETE /api/cuentasBancarias/{id} : Borrar cuenta bancaria por id.</h1>
     * 
     * <pre>Borra la cuenta bancaria con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la cuenta bancaria correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cuenta bancaria con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la cuenta bancaria que se desea borrar. Este debe ser una cadena de dígitos.
     */    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCuentaBancaria(@PathParam("id") Long id){
        //en espera de implementacion
        CuentaBancariaEntity entity = cuentaBancariaLogic.getCuentaBancaria(id);
        if (entity == null) {
            throw new WebApplicationException("La cuentaBancaria no existe", 404);
        }
        cuentaBancariaLogic.deleteCuentaBancaria(id);
    }
    
}
