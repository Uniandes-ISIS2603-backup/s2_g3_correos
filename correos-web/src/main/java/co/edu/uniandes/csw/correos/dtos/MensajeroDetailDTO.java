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

package co.edu.uniandes.csw.correos.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l.mejia
 */
public class MensajeroDetailDTO extends MensajeroDTO
{   
    
    private List<TransporteDTO> transportes= new ArrayList<>();
    private CuentaBancariaDTO cuentaBancaria;
    private List<EnvioDTO> envios=new ArrayList<>();
    private List<ComentarioDTO> comentarios=new ArrayList<>();
    private List<ZonaDTO> zonas= new ArrayList<>();
    
    public MensajeroDetailDTO()
    {
        super();
    }

    public List<TransporteDTO> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<TransporteDTO> transportes) {
        this.transportes = transportes;
    }

    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public List<EnvioDTO> getEnvios() {
        return envios;
    }

    public void setEnvios(List<EnvioDTO> envios) {
        this.envios = envios;
    }

    public List<ComentarioDTO> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }

    public List<ZonaDTO> getZonas() {
        return zonas;
    }

    public void setZonas(List<ZonaDTO> zonas) {
        this.zonas = zonas;
    }
    
    
            
}
