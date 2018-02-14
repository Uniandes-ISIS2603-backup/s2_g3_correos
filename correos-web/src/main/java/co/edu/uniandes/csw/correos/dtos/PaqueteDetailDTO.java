/*

  * To change this license header, choose License Headers in Project Properties. 
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package co.edu.uniandes.csw.correos.dtos;
 
 import java.util.ArrayList;
 import java.util.List;
 
 /**
  *
  * @author df.rengifo
  */
 public class PaqueteDetailDTO extends PaqueteDTO {	  
	    
	    private EnvioDTO envio;
	    private List<DetallePaqueteDTO> detalles=new ArrayList<>();	   
	    
	    /**
	     * Constructor por defecto
	     */
	    public PaqueteDetailDTO()
	    {
	        super();
	    }
	    
	    /**
	     * @return La lista de los detalles asociados al paquete
	     */
	    public List<DetallePaqueteDTO> getPaquete() {
	        return detalles;
	    }
	    
	    /**
	     * @param detalles nuevos detalles para el paquete
	     */
	    public void setDetalles(List<DetallePaqueteDTO> detalles) {
	        this.detalles = detalles;
	    }

	    /**
	     * @return el envio asociado al paquete
	     */
	    public EnvioDTO getEnvio() {
	        return envio;
	    }
	    
	    /**
	     * @param envio el nuevo envio asociado al paquete
	     */
	    public void setEnvio(EnvioDTO envio) {
	        this.envio = envio;
	    }    

 }