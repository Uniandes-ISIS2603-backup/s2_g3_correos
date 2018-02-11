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
 
 import co.edu.uniandes.csw.correos.dtos.EnvioDTO;
 import co.edu.uniandes.csw.correos.dtos.EnvioDetailDTO;
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
  * @author df.rengifo
  */
@Path("envios")
 @Produces("application/json")
 @Consumes("application/json")
 @RequestScoped
 public class EnvioResource { 
	/**
     * Post
     */
     @POST
     public EnvioDetailDTO createEnvio(EnvioDetailDTO envio){
         return envio;
     }
     /**
      * Put
      */
     @PUT
     @Path("{id: \\d+}")
     public EnvioDetailDTO updateEnvio(@PathParam("id") Long id , EnvioDetailDTO envio){
         return envio;
     } 
     /**
      * Get
      */
     @GET
     @Path("{id: \\d+}")
     public EnvioDetailDTO getEnvio(@PathParam("id") Long id){
         return null;
     } 
     /**
      * Get (todos)
      */
     @GET
     public List<EnvioDTO> getEnvio(){
         return new ArrayList<>();
     }    
     /**
      * Delete
      */
     @DELETE
     @Path("{id: \\d+}")
     public void deleteEnvio(@PathParam("id") Long id){
         /**
          * vacio
          */          
     } 
}