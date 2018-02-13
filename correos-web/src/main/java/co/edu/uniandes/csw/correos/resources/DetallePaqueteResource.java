/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import java.util.ArrayList; 

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.List; 
import javax.enterprise.context.RequestScoped;
import co.edu.uniandes.csw.correos.dtos.detallePaqueteDTO;
import co.edu.uniandes.csw.correos.dtos.detallePaqueteDetailDTO;
     

/**
 *
 * @author t.vargas10
 */

@Path("detalles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class DetallePaqueteResource {
 
    @POST
    public detallePaqueteDetailDTO crearPaquete(detallePaqueteDetailDTO nuevo)
    {
        return nuevo;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public detallePaqueteDetailDTO updatePaquete (@PathParam("id")Long id, detallePaqueteDetailDTO actualizar)
    {
        return actualizar;
    }
    
    @GET
    @Path("{id: \\d+}") 
    public detallePaqueteDetailDTO getDetallePaquete(@PathParam("id") Long id) 
    {
        return null;
    }
    
    
}
