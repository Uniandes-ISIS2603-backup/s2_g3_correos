/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import java.util.List; 
import java.util.ArrayList; 
import javax.enterprise.context.RequestScoped;
import co.edu.uniandes.csw.correos.dtos.BonoDTO;
import co.edu.uniandes.csw.correos.dtos.BonoDetailDTO;

/**
 *
 * @author t.vargas10
 */

@Path("bonos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class BonoResource 
{    
    @POST
    public BonoDetailDTO createBono(BonoDetailDTO nuevo)
    {
        return nuevo;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public BonoDetailDTO updateBono (@PathParam("id") Long id, BonoDetailDTO actualizar)
    {
        return actualizar;
    }
    
    @GET
    @Path("{id: \\d+}")
    public BonoDetailDTO getBono (@PathParam("id")Long id)
    {
        return null;
    }
    
    @GET
    public List<BonoDTO> getBonos()
    {
        return new ArrayList<>();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteBono (@PathParam("id") Long id)
    {
        //Implementacion pendiente
    }
}























