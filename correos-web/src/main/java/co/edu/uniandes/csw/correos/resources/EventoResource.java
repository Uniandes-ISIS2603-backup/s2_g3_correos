/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.EventoDTO;
import co.edu.uniandes.csw.correos.dtos.EventoDetailDTO;
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
@Path("eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class EventoResource {
    
    @POST
public EventoDetailDTO createEvento(EventoDetailDTO evento)throws BusinessLogicException{
    return evento;
}

    @PUT
    @Path("{id: \\d+}")
    public EventoDetailDTO updateEvento(@PathParam("id") Long id , EventoDetailDTO evento) throws BusinessLogicException{
        return evento;
    }
    
    @GET
    @Path("{id: \\d+}")
    public EventoDetailDTO getEvento(@PathParam("id") Long id){
        return null;
    }
    
    @GET
    public List<EventoDTO> getEvento(){
        return new LinkedList<>();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEvento(@PathParam("id") Long id){
        //en espera de implementacion
    }
    
}
