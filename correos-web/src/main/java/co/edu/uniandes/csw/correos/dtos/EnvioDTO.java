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
 public class EnvioDTO {
    /**
     * Constante de Estado Inicial (posterior nombramiento)
     */
    private static final String ESTADO_INICIAL = "Estado Inicial";

    private long idEnvio; 
    private long horaInicio;
    private long horaFinal;
    private String direccionEntrega;
    private String direccionRecogida;
    private String estado;
/**
 * Constructor basico (vacio)
 */
    public EnvioDTO() {
        
    }
    /**
     * 
     * @return ID del Envio
     */     
    public long getId() {
        return idEnvio; 
    }
    /**
     * 
     * @return hora de recogida
     */
    public long getHoraInicio() {
        return horaInicio; 
    }
    /**
     * 
     * @return hora de entrega APROXIMADA 
     */
    public long getHoraFinal() {
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
    public void setId(long id) {
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
    public void setHoraInicio(long hora) {
        horaInicio = hora; 
    }
    /**
     * 
     * @param hora nueva aproximacion de hora final
     */
    public void setHoraFinal(long hora) {
        horaFinal = hora; 
    }
    /**
     * 
     * @param nuevoEstado nuevo estado del envio
     */
    public void setEstado(String estado) {
        this.estado = estado; 
    }        
}
