/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 package co.edu.uniandes.csw.correos.resources;
 
 import co.edu.uniandes.csw.correos.dtos.EnvioDTO;
 import co.edu.uniandes.csw.correos.dtos.EnvioDetailDTO;
 import co.edu.uniandes.csw.correos.ejb.EnvioLogic;
 import co.edu.uniandes.csw.correos.entities.EnvioEntity;
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
  * <pre>Clase que implementa el resource "envios".
  * URL: /api/envios
  * </pre>
  * <i>Note que la aplicacion (definida en {@link RestConfig}) define la ruta "/api" y
  * este recurso tiene la ruta "envios".</i>
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
 @Path("envios")
 @Produces("application/json")
 @Consumes("application/json")
 @RequestScoped
 public class EnvioResource {
    
    private static final String ENVIO="El envio con el id ";
     
    private static final String NOEXISTE=" no existe.";
    
    @Inject
    EnvioLogic envioLogic;
    
    /**
     * sontructor con params
     * @param eL 
     */
    @Inject
    public EnvioResource(EnvioLogic eL)
    {
        this.envioLogic=eL;
    }
    
    /**
     * constructor
     */
    public EnvioResource()
    {
        this.envioLogic=null;
    }
    
    /**
     * <h1>POST /api/envios : Crear un envio.</h1>
     * 
     * <pre>Cuerpo de peticion: JSON {@link EnvioDetailDTO}.
     * 
     * Crea un nuevo envio con la informacion que se recibe en el cuerpo 
     * de la peticion y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo el nuevo envio.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el envio.
     * </code>
     * </pre>
     * @param envio {@link EnvioDetailDTO} - El envio que se desea guardar.
     * @return JSON {@link EnvioDetailDTO}  - El envio guardado con el atributo 
     * ID autogenerado. 
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
     * de lógica que se genera cuando ya existe el envio.
     */
     @POST
     public EnvioDetailDTO createEnvio(EnvioDetailDTO envio) throws BusinessLogicException{
         return new EnvioDetailDTO(envioLogic.createEnvio(envio.toEntity()));          
     }
     /**
      * <h1>PUT /api/envios/{id} : Actualizar envio con el id dado.</h1>
      * <pre>Cuerpo de peticion: JSON {@link EnvioDetailDTO}.
      * 
      * Actualiza el envio con el ID recibido, con la informacion que se recibe.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Actualiza el envio con el ID dado con la informacion enviada 
      * como parametro. Retorna un objeto identico.</code> 
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found. No existe un envio con el ID dado.
      * </code> 
      * </pre>
      * @param id ID del envio que se desea actualizar.
      * Debe ser un Long.
      * @param envio {@link EnvioDetailDTO} El Envio que se desea guardar.
      * @return JSON {@link EnvioDetailDTO} - El Envio guardado.  
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no existe el envio a actualizar.
      */
     @PUT
     @Path("{id: \\d+}")
     public EnvioDetailDTO updateEnvio(@PathParam("id") Long id, EnvioDetailDTO envio) throws BusinessLogicException{
        if(envioLogic.getEnvio(id)==null) 
            throw new WebApplicationException(ENVIO+ id + NOEXISTE,404);
        envio.setId(id);
        return new EnvioDetailDTO(envioLogic.updateEnvio(envio.toEntity()));
     } 
     /**
      * <h1>GET /api/envios/{id} : Obtener envio por ID.</h1>
      * 
      * <pre>Busca el envio con el ID asociado recibido en la URL y lo devuelve.
      * 
      * Codigos de respuesta:
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Devuelve el envio correspondiente al ID.
      * </code> 
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found No existe un envio con el ID dado.
      * </code> 
      * </pre>
      * @param id ID del envio. 
      * Debe ser un Long.
      * @return JSON {@link EnvioDetailDTO} - el envio buscado.
      * @throws WebApplicationException {@link WebApplicationException} - Error 
      * de lógica que se genera cuando no se puede encontrar el envio.
      */
     @GET
     @Path("{id: \\d+}")
     public EnvioDetailDTO getEnvio(@PathParam("id") Long id) throws BusinessLogicException {
        if(envioLogic.getEnvio(id)==null) 
            throw new WebApplicationException(ENVIO + id+NOEXISTE,404);
        return new EnvioDetailDTO(envioLogic.getEnvio(id));
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
      */
     @GET     

     public List<EnvioDetailDTO> getEnvios() throws BusinessLogicException{
         return entityADTO(envioLogic.getEnvios());   
     }     
     /**
      * <h1>DELETE /api/envios/{id} : Borrar envio por id.</h1>
      * 
      * <pre>Elimina el envio con el id asociado.
      * 
      * Codigos de respuesta:<br>
      * <code style="color: mediumseagreen; background-color: #eaffe0;">
      * 200 OK Elimina el envio indicado.</code>
      * <code style="color: #c7254e; background-color: #f9f2f4;">
      * 404 Not Found. El envio indicado no existe.
      * </code>
      * </pre>**
      * @param id ID del envio 
      * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error 
      * de lógica que se genera cuando no se puede eliminar el envio.
      */
     @DELETE
     @Path("{id: \\d+}")
     public void deleteEnvio(@PathParam("id") Long id) throws BusinessLogicException {
       if(envioLogic.getEnvio(id)==null) 
            throw new WebApplicationException(ENVIO+ id +NOEXISTE,404);
        envioLogic.deleteEnvio(id);
    } 
     
     /**
      * 
      * @param envios
      * @return lista de todos los envios en DetailDto
      */
     public List<EnvioDetailDTO> entityADTO(List<EnvioEntity> envios)
    {
        List<EnvioDetailDTO> resp = new ArrayList<>();
        for(EnvioEntity x: envios)
            resp.add(new EnvioDetailDTO(x));
        return resp;
    }
}