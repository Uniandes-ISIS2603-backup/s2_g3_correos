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
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.correos.entities;

import java.io.Serializable;

/**
 *
 * @author df.rengifo
 */
public class PaqueteEntity extends BaseEntity implements Serializable{    
    
   
   private Double dimensionA;
   private Double dimensionB;
   private Double dimensionC;
   private Double peso;
   private String tipo;

   

    /**
     * @return the dimensionA
     */
    public Double getDimensionA() {
        return dimensionA;
    }

    /**
     * @param dimensionA the dimensionA to set
     */
    public void setDimensionA(Double dimensionA) {
        this.dimensionA = dimensionA;
    }

    /**
     * @return the dimensionB
     */
    public Double getDimensionB() {
        return dimensionB;
    }

    /**
     * @param dimensionB the dimensionB to set
     */
    public void setDimensionB(Double dimensionB) {
        this.dimensionB = dimensionB;
    }

    /**
     * @return the dimensionC
     */
    public Double getDimensionC() {
        return dimensionC;
    }

    /**
     * @param dimensionC the dimensionC to set
     */
    public void setDimensionC(Double dimensionC) {
        this.dimensionC = dimensionC;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }  
}