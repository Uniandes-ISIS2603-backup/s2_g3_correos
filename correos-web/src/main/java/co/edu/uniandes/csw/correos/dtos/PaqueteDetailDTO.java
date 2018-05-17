/*
  * To change this license header, choose License Headers in Project Properties. 
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package co.edu.uniandes.csw.correos.dtos;
 
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;

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
             * @param entity El paquete a ser creado
             */
            public PaqueteDetailDTO(PaqueteEntity entity)
            {            
                super(entity);         
                if (entity.getDetalle()!=null){
                this.detalle=new DetallePaqueteDTO(entity.getDetalle());
                }
                if (entity.getEnvio()!=null){
                this.envio=new EnvioDTO(entity.getEnvio());
                }
            }
        
            /**
             * 
             * @return la entidad recien convertida
             */
            @Override
            public PaqueteEntity toEntity()
            {
                PaqueteEntity entity= super.toEntity();
            
                if(envio != null){
                entity.setEnvio(this.envio.toEntity());
                }
                if(detalle != null){
                entity.setDetalle(this.detalle.toEntity());
                }
        
                return entity;        
            }  
            
	    /**
	     * @return El detalle asociado al paquete
	     */
	    public DetallePaqueteDTO getDetalle() {
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