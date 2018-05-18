/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.AdministradorDTO;
import co.edu.uniandes.csw.correos.dtos.ClienteDTO;
import co.edu.uniandes.csw.correos.dtos.MensajeroDTO;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author l.mejia
 */
@Path("login")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class LoginResource {
    
    @Path("/mensajero")
    @POST
    public MensajeroDTO soyMensajero(MensajeroDTO m)throws BusinessLogicException
    {
        return m;
    }
    
    @Path("/cliente")
    @POST
    public ClienteDTO soyCliente(ClienteDTO c)throws BusinessLogicException
    {
        return c;
    }
    
    @Path("/administrador")
    @POST
    public AdministradorDTO soyAdmin(AdministradorDTO a)throws BusinessLogicException
    {
        return a;
    }
}
