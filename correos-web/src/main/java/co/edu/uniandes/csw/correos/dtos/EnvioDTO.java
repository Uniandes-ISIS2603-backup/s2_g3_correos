/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 package co.edu.uniandes.csw.correos.dtos;

 import co.edu.uniandes.csw.correos.entities.EnvioEntity;

 /**
  * EnvioDTO Objeto de transferencia de datos de Envios. Los DTO contienen las
  * representaciones de los JSON que se transfieren entre el cliente y el
  * servidor.
  * 
  * Al serializarse como JSON est clase implementa el siguiente modelo: <br>
  * <pre>
  *   {
  *      "id": number,
  *      "horaInicio": number,
  *      "horaFinal": number,
  *      "direccionEntrega": String,
  *      "direccionRecogida": String,
  *      "estado": String             
  *   }
  * </pre>
  * <pre>
  *   {
  *      "id": 2,
  *      "horaInicio": 0000,
  *      "horaFinal": 0030,
  *      "direccionEntrega": calle 1 # 2-4,
  *      "direccionRecogida": calle 1 # 3-4,
  *      "estado": INICIAL
  *   }
  * </pre>
  *
  *
  * @author df.rengifo
  */
 public class EnvioDTO {    

    private Long idEnvio; 
    private Long horaInicio;
    private Long horaFinal;
    private String direccionEntrega;
    private String direccionRecogida;
    private String estado;

    public EnvioDTO() {
     /**
      * Constructor basico
      */   
    }
    
    /**
     * 
     * @param entity a ser creada 
     */
    public EnvioDTO(EnvioEntity entity) {
        this.idEnvio = entity.getId();
        this.horaInicio = entity.getHoraInicio();
        this.horaFinal = entity.getHoraFinal();
        this.estado = entity.getEstado();
        this.direccionEntrega = entity.getDireccionEntrega();
        this.direccionRecogida = entity.getDireccionRecogida();        
    }
    
/**
 * 
 * @return  entidad de paquete
 */
    public EnvioEntity toEntity() {
        EnvioEntity entity = new EnvioEntity();
        entity.setId(this.idEnvio);
        entity.setEstado(this.estado);
        entity.setHoraInicio(this.horaInicio);
        entity.setHoraFinal(this.horaFinal);
        entity.setDireccionEntrega(this.direccionEntrega);
        entity.setDireccionRecogida(this.direccionRecogida);
        return entity;
    }
    /**
     * 
     * @return ID del Envio
     */     
    public Long getId() {
        return idEnvio; 
    }
    /**
     * 
     * @return hora de recogida
     */
    public Long getHoraInicio() {
        return horaInicio; 
    }
    /**
     * 
     * @return hora de entrega APROXIMADA 
     */
    public Long getHoraFinal() {
        return horaFinal; 
    }
    /**
     * 
     * @return Direccion de la Entrega
     */    
    public String getDireccionEntrega() {
        return direccionEntrega; 
    }
    /**
     * 
     * @return Direccion de la Recogida
     */    
    public String getDireccionRecogida(){
        return direccionRecogida;
    }
    /**
     * 
     * @return Estado del envio
     */    
    public String getEstado(){
        return estado;
    }
    /**
     * 
     * @param id la nueva ID del Envio (?)
     */
    public void setId(Long id) {
        idEnvio = id; 
    }
    /**
     * 
     * @param entrega nueva direccion de entrega
     */
    public void setEntrega(String entrega) {
        direccionEntrega = entrega; 
    }
    /**
     * 
     * @param recogida nueva direccion de recogida
     */
    public void setRecogida(String recogida) {
        direccionRecogida = recogida; 
    }
    /**
     * 
     * @param hora nueva hora de recojida
     */
    public void setHoraInicio(Long hora) {
        horaInicio = hora; 
    }
    /**
     * 
     * @param hora nueva aproximacion de hora final
     */
    public void setHoraFinal(Long hora) {
        horaFinal = hora; 
    }
    /**
     * 
     * @param estado Estado nuevo estado del envio
     */
    public void setEstado(String estado) {
        this.estado = estado; 
    }
}
