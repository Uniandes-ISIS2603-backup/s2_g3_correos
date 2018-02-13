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
    
@POST
public PagoDetailDTO createPago(PagoDetailDTO pago)throws BusinessLogicException{
    return pago;
}

    @PUT
    @Path("{id: \\d+}")
    public PagoDetailDTO updatePago(@PathParam("id") Long id , PagoDetailDTO pago) throws BusinessLogicException{
        return pago;
    }
    
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPago(@PathParam("id") Long id){
        return null;
    }
    
    @GET
    public List<PagoDTO> getPagos(){
        return new LinkedList<>();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deletePago(@PathParam("id") Long id){
        //en espera de implementacion
    }

}
