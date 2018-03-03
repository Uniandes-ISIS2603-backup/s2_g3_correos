/*
  * To change this license header, choose License Headers in Project Properties. 
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package co.edu.uniandes.csw.correos.dtos;
 
 /**
  *
  * @author df.rengifo
  */
 public class PaqueteDetailDTO extends PaqueteDTO {	  
	    
	    private EnvioDTO envio;
	    private DetallePaqueteDTO detalle;	   
	    
	    /**
	     * Constructor por defecto
	     */
	    public PaqueteDetailDTO()
	    {
	        super();
	    }
	    
	    /**
	     * @return El detalle asociado al paquete
	     */
	    public DetallePaqueteDTO getPaquete() {
	        return detalle;
	    }
	    
	    /**
	     * @param detalle nuevo detalle para el paquete
	     */
	    public void setDetalle(DetallePaqueteDTO detalle) {
	        this.detalle = detalle;
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