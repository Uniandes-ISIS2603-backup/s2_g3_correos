/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
 package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.PaqueteEntity;

 /**
  * PaqueteDTO Objeto de transferencia de datos de Paquetes. Los DTO contienen las
  * represnetaciones de los JSON que se transfieren entre el cliente y el
  * servidor.
  * 
  * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
  * <pre>
  *   {
  *      "id": number,
  *      "tipo": string,
  *      "peso": number,
  *      "dimensionA": number,
  *      "dimensionB": number,
  *      "dimensionC": number,             
  *   }
  * </pre>
  * <pre>
  *   {
  *      "id": 1,
  *      "tipo": FRAGIL,
  *      "peso": 10,
  *      "dimensionA": 1,
  *      "dimensionB": 2,
  *      "dimensionC": 3,
  *   }
  * </pre>
  * @author df.rengifo
  */
 public class PaqueteDTO {
   
    private long idPaquete; 
    private String tipo;
    private double peso;    
    private double dimensionA;
    private double dimensionB;
    private double dimensionC;

    public PaqueteDTO() {
     /**
      * Constructor basico (vacio)
      */    
    }
    /**
     * 
     * @param entity a ser creada 
     */
    public PaqueteDTO(PaqueteEntity entity) {
        this.idPaquete = entity.getId();
        this.tipo = entity.getTipo();
        this.peso = entity.getPeso();
        this.dimensionA = entity.getDimensionA();
        this.dimensionB = entity.getDimensionB();
        this.dimensionC = entity.getDimensionC();        
    }
/**
 * 
 * @return  entidad de paquete
 */
    public PaqueteEntity toEntity() {
        PaqueteEntity entity = new PaqueteEntity();
        entity.setId(this.idPaquete);
        entity.setTipo(this.tipo);
        entity.setPeso(this.peso);
        entity.setDimensionA(this.dimensionA);
        entity.setDimensionB(this.dimensionB);
        entity.setDimensionC(this.dimensionC);
        return entity;
    }
/**
 * 
 * @return ID del Paquete
 */     
    public long getId() {
        return idPaquete; 
    }
    /**
     * 
     * @return Tipo de Paquete
     */    
    public String getTipo() {
        return tipo; 
    }
    /**
     * 
     * @return Peso del Paquete
     */    
    public double getPeso(){
        return peso;
    }
    /**
     * 
     * @return Dimension mas pequena del Paquete
     */    
    public double getDimensionA(){
        return dimensionA;
    }
    /**
     * 
     * @return Dimension media del Paquete
     */
    public double getDimensionB(){
        return dimensionB;
    }
    /**
     * 
     * @return Dimension mas grande del Paquete
     */
    public double getDimensionC(){
        return dimensionC;
    }
    /**
     * 
     * @param id la nueva ID del Paquete (?)
     */
    public void setId(long id) {
        idPaquete = id; 
    }
    /**
     * 
     * @param tipo nuevo tipo del Paquete
     */
    public void setTipo(String tipo) {
        this.tipo = tipo; 
    }
    /**
     * 
     * @param peso nuevo peso del Paquete
     */
    public void setPeso(double peso) {
        this.peso = peso; 
    }
    /**
     * 
     * @param a Primera Dimension  
     */
    public void setDimensionA(double a) {
        dimensionA = a;         
    } 
    /**
     * 
     * @param b Segunda Dimension  
     */
    public void setDimensionB(double b) {
        dimensionB = b;         
    }    
    /**
     * 
     * @param c Tercera Dimension  
     */
    public void setDimensionC(double c) {
        dimensionC = c;         
    }
}
