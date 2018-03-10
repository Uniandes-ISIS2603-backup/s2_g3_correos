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
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.ReservaEntity;

/**
 * Clase que extiende de {@link ReservaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del ReservaDTO vaya a la documentacion de {@link ReservaDTO}
 * @author l.mejia
 */
public class ReservaDetailDTO extends ReservaDTO{
    
    private EnvioDTO envio;
    
    /**
     * constructor por defecto
     */
    public ReservaDetailDTO()
    {
        super();
    }
    public ReservaDetailDTO(ReservaEntity reserva)
    {
         super(reserva);
         if(reserva.getEnvio()!=null)
             this.envio=new EnvioDTO(reserva.getEnvio());
    }
    
    /**
     * @return El envio al que corresponde la reserva
     */
    public EnvioDTO getEnvio() {
        return envio;
    }
    
    /**
     * @param envio El nuevo envio reservado
     */
    public void setEnvio(EnvioDTO envio) {
        this.envio = envio;
    }
    
    
    
}
