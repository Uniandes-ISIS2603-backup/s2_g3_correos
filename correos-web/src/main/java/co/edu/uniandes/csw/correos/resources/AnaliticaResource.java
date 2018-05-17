/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.analitica.Analitica;
import co.edu.uniandes.csw.correos.dtos.AnaliticaDTO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author a.silvag
 */
@Path("analitica")
@Produces("application/json")
@RequestScoped
public class AnaliticaResource {
    
    
    private Analitica anal;
    
    @Inject
    public AnaliticaResource(Analitica anal2){
        anal = anal2;
    }
    
    public AnaliticaResource(){
        anal = null;
    }
    
    
    @GET
    public AnaliticaDTO getAnal(){
            return new AnaliticaDTO(anal.darPrecioPromedioTodosLosEnvios(), anal.darClientesMasFieles(), anal.darClientesQuePerdieronActividadHaceUnMes(), anal.darPromedioTarjetasDeCreditoPorCliente(), anal.darMensajerosMasProductivos(), anal.darEnviosPorHora(), anal.darVolumenPromedioPaquetes(), anal.darPromedioEventosPorEnvio(), anal.darMejoresCalificaciones());
    }
    
    
}
