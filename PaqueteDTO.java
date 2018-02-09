/*
 * MIT License
 
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
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
 
 package co.edu.uniandes.csw.correos.dtos;
 
 /**
  *
  * @author df.rengifo
  */
 public class PaqueteDTO {
   
    private long idPaquete; 
    private String tipo; 
    private double peso; 
    /**
     * para evitar confusiones acerca de como "voltear" el paquete para que 
     * entre en el ttransporte
     */
    private double dimensionA;
    private double dimensionB;
    private double dimensionC;
/**
 * Constructor basico (vacio)
 */
    public PaqueteDTO() {
        
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
     * @return Dimension mas pequeña del Paquete
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
     * @param A 
     * @param B
     * @param C
     */
    public void setDimensiones(double A, double B, double C) {
        
    }        
}
