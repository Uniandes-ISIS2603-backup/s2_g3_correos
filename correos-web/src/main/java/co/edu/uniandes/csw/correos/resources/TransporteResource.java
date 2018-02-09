/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
CITYS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.correos.resources;

import co.edu.uniandes.csw.correos.dtos.TransporteDTO;
import java.util.ArrayList;
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
 * @author l.mejia
 */
@Path("reservas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TransporteResource {
    
    @POST
    public TransporteDTO createTransporte(TransporteDTO nuevo)
    {
        return nuevo;
    }
    
    @PUT
    @Path("{id: \\d+}")
    public TransporteDTO updateTransporte(@PathParam("id") Long id , TransporteDTO actualizar)
    {
        return actualizar;
    }
    
    @GET
    @Path("{id: \\d+}")
    public TransporteDTO getTransporte(@PathParam("id") Long id)
    {
        return null;
    }
    
    @GET
    public List<TransporteDTO> getTransportes()
    {
        return new ArrayList<>();
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransporte(@PathParam("id") Long id)
    {
        //en espera de implementacion
    }
    
    
    
}
