/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package co.edu.uniandes.csw.correos.resources;
 
 import co.edu.uniandes.csw.correos.dtos.PaqueteDTO;
 import co.edu.uniandes.csw.correos.dtos.PaqueteDetailDTO;
import co.edu.uniandes.csw.correos.ejb.EnvioLogic;
 import co.edu.uniandes.csw.correos.ejb.PaqueteLogic;
 import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
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
  * <pre>Clase que implementa el resource "paquetes".
  * URL: /api/paquetes
  * </pre>
  * <i>Note que la aplicacion (definida en {@link RestConfig}) define la ruta "/api" y
  * este recurso tiene la ruta "paquetes".</i>
  *
  * <h2>Anotaciones </h2>
  * <pre>
  * Path: indica la direccin despues de "api" para acceder al recurso
  * Produces/Consumes: indica que los servicios definidos en este recurso reciben y 
  * devuelven objetos en formato JSON
  * RequestScoped: Inicia una transaccion desde el llamado de cada metodo (servicio). 
  * </pre>
  * @author df.rengifo
  */
 @Path("envios/{envioId:\\d+}/paquetes")
 @Produces("application/json")
 @Consumes("application/json")
 @RequestScoped
 public class PaqueteResource { 
    
    @Inject
    PaqueteLogic paqueteLogic;
    @Inject
    EnvioLogic envioLogic;
	/**
     * <h1>POST /api/paquetes : Crear un paquete.</h1>
     * 
     * <pre>Cuerpo de peticion: JSON {@link PaqueteDetailDTO}.
     * 
     * Crea un nuevo paquete con la informacion que se recibe en el cuerpo 
     * de la peticion y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo el nuevo paquete.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el paquete.
     * </code>
     * </pre>
     * @param envioId
     * @param paquete {@link PaqueteDetailDTO} - El paquete que se desea guardar.
     * @return JSON {@link PaqueteDetailDTO}  - El paquete guardado con el atributo 
     * ID autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
     * de lógica que se genera cuando ya existe el envio.
     */
     @POST
     public PaqueteDetailDTO createPaquete(@PathParam("envioId") Long envioId, PaqueteDetailDTO paquete) throws BusinessLogicException
    {
        if(envioLogic.getEnvio(envioId)==null) 
            throw new WebApplicationException("no existe el Envio con el id" + envioId, 404);
        PaqueteDetailDTO paqueteNew = new PaqueteDetailDTO(paqueteLogic.createPaquete(paquete.toEntity()));
        System.out.println("Llegué acá");
        envioLogic.agregarPaquete(envioId, paqueteNew.toEntity());
        return paqueteNew;        
    }
     /**
      * <h1>PUT /api/paquetes/{id} : Actualizar paquete con el id dado.</h1>
      * <pre>Cuerpo de peticion: JSON {@link PaqueteDetailDTO}.
      * 
      * Actualiza el paquete con el ID recibido, con la informacion que se recibe.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Actualiza el paquete con el ID dado con la informacion enviada 
      * como parametro. Retorna un objeto identico.</code> 
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found. No existe un paquete con el ID dado.
      * </code> 
      * </pre>
      * @param id ID del paquete que se desea actualizar.
      * Debe ser un Long.
      * @param paquete {@link PaqueteDetailDTO} El paquete que se desea guardar.
      * @return JSON {@link PaqueteDetailDTO} - El paquete guardado.  
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no se encuentra el paquete a actualizar.
      */
     @PUT
    @Path("{id: \\d+}")
    public PaqueteDetailDTO updatePaquete(@PathParam("envioId") Long envioId, @PathParam("id") Long id , PaqueteDetailDTO paquete) throws BusinessLogicException
    {
        if(envioLogic.getEnvio(envioId)==null)
            throw new WebApplicationException("no existe el Envio con el id " + envioId, 404);
        if(paqueteLogic.getPaquete(id, envioId)==null)
            throw new WebApplicationException("no existe el Paquete con el id " + id, 404);
        paquete.setId(id);        
        envioLogic.agregarPaquete(envioId, paquete.toEntity());
        return new PaqueteDetailDTO(paqueteLogic.updatePaquete(paquete.toEntity()));
    }
     /**
      * <h1>GET /api/paquetes/{id} : Obtener paquete por ID.</h1>
      * 
      * <pre>Busca el paquete con el ID asociado recibido en la URL y lo devuelve.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Devuelve el paquete correspondiente al ID.
      * </code> 
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found No existe un paquete con el ID dado.
      * </code> 
      * </pre>
      * @param id ID del paquete. 
      * Debe ser un Long.
      * @return JSON {@link PaqueteDetailDTO} - el paquete buscado.
      * @throws WebApplicationException {@link WebApplicationExceptionMapper} - Error 
      * de lógica que se genera cuando no se encuentra el paquete.
      */
     @GET
     @Path("{id: \\d+}")
    public PaqueteDetailDTO getPaquete(@PathParam("envioId") Long envioId,@PathParam("id") Long id) throws BusinessLogicException
    {
        if(envioLogic.getEnvio(envioId)==null)
            throw new WebApplicationException("no existe el envio con el id " + envioId, 404);
        if(paqueteLogic.getPaquete(id, envioId)==null)
            throw new WebApplicationException("no existe el paquete con el id " + id, 404);
        return new PaqueteDetailDTO(paqueteLogic.getPaquete(id, envioId));
    }
     /**
      * <h1>GET /api/paquetes : Obtener todos los paquetes.</h1>
      * 
      * <pre>Busca y devuelve todos los paquetes que existen en la aplicacion.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Devuelve todos los paquetes de la aplicacion.</code> 
      * </pre>**
      * @return JSONArray {@link PaqueteDTO} - Los paquetes encontrados 
      * en la aplicacion. Si no hay ninguno retorna una lista vacia.
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no hay paquetes en el sistema.
      */
     @GET     
     public List<PaqueteDetailDTO> getPaquetes(@PathParam("envioId") Long envioId)
    {
        if(envioLogic.getEnvio(envioId)==null)
            throw new WebApplicationException("no existe el envio con el id " + envioId, 404);
        return EntityADTO(envioLogic.getEnvio(envioId).getPaquetes());
    }     
     /**
      * <h1>GET /api/envios : Obtener todos los envios.</h1>
      * 
      * <pre>Busca y devuelve todos los envios que existen en la aplicacion.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Devuelve todos los envios de la aplicacion.</code> 
      * </pre>**
      * @return JSONArray {@link EnvioDTO} - Los envios encontrados 
      * en la aplicacion. Si no hay ninguno retorna una lista vacia.
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no hay envios en el sistema.
      
     @GET     
     public List<PaqueteDetailDTO> getAllPaquetes(@PathParam("envioId") Long envioId) throws BusinessLogicException
    {
        if(envioLogic.getEnvio(envioId)==null)
            throw new WebApplicationException("no existe el envio con el id " + envioId, 404);
        return EntityADTO(paqueteLogic.getPaquetes());
    }*/  
     /**
      * <h1>DELETE /api/paquetes/{id} : Borrar paquete por id.</h1>
      * 
      * <pre>Elimina el paquete con el id asociado.
      * 
      * Codigos de respuesta:<br>
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Elimina el paquete indicado.</code>
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found. El paquete indicado no existe.
      * </code>
      * </pre>**
      * @param id ID del paquete      
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no se encuentra el paquete a eliminar.
      */
     @DELETE
     @Path("{id: \\d+}")
     public void deletePaquete(@PathParam("envioId") Long envioId,@PathParam("id") Long id) throws BusinessLogicException
    {
        if(envioLogic.getEnvio(envioId)==null)
            throw new WebApplicationException("no existe el envio con el id " + envioId, 404);
        if(paqueteLogic.getPaquete(id, envioId)==null)
            throw new WebApplicationException("no existe el paquete con el id " + id, 404);
        paqueteLogic.deletePaquete(id);
    } 
     public List<PaqueteDetailDTO> EntityADTO(List<PaqueteEntity> envios)
    {
        List<PaqueteDetailDTO> resp = new ArrayList<>();
        for(PaqueteEntity x: envios)
            resp.add(new PaqueteDetailDTO(x));
        return resp;
    }
}