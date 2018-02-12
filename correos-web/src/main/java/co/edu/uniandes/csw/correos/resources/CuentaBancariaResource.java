/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.CuentaBancariaDTO;
import co.edu.uniandes.csw.correos.dtos.CuentaBancariaDetailDTO;
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

@Path("cuentasBancarias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuentaBancariaResource {
    @POST
public CuentaBancariaDetailDTO createCuentaBancaria(CuentaBancariaDetailDTO cuentaBancaria)throws BusinessLogicException{
    return cuentaBancaria;
}

    @PUT
    @Path("{id: \\d+}")
    public CuentaBancariaDetailDTO updateCuentaBancaria(@PathParam("id") Long id , CuentaBancariaDetailDTO cuentaBancaria) throws BusinessLogicException{
        return cuentaBancaria;
    }
    
    @GET
    @Path("{id: \\d+}")
    public CuentaBancariaDetailDTO getCuentaBancaria(@PathParam("id") Long id){
        return null;
    }
    
    @GET
    public List<CuentaBancariaDTO> getCuentaBancaria(){
        return new LinkedList<>();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCuentaBancaria(@PathParam("id") Long id){
        //en espera de implementacion
    }
    
}
