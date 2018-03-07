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

import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link MensajeroDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del mensajero vaya a la documentacion de {@link MensajeroDTO}
 * @author l.mejia
 */
public class MensajeroDetailDTO extends MensajeroDTO
{   
    
    private List<TransporteDTO> transportes= new ArrayList<>();
    private CuentaBancariaDTO cuentaBancaria;
    private List<EnvioDTO> envios=new ArrayList<>();
    private List<CalificacionDTO> comentarios=new ArrayList<>();
    private List<ZonaDTO> zonas= new ArrayList<>();
    
    /**
     * Constructor por defecto
     */
    public MensajeroDetailDTO()
    {
        super();
    }
    
    /**
     * @return La lista de los trasnportes asociados al mensajero
     */
    public List<TransporteDTO> getTransportes() {
        return transportes;
    }
    
    /**
     * @param transportes los nuevos transportes asociados del mensajero
     */
    public void setTransportes(List<TransporteDTO> transportes) {
        this.transportes = transportes;
    }

    /**
     * @return La cuenta bancaria del mensajero
     */
    public CuentaBancariaDTO getCuentaBancaria() {
        return cuentaBancaria;
    }
    
    /**
     * @param cuentaBancaria la nueva cuenta bancaria del mensajero
     */
    public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    /**
     * @return La lista de los envios realizados/por realizar del mensajero
     */
    public List<EnvioDTO> getEnvios() {
        return envios;
    }
    
    /**
     * @param envios los nuevos envios del mensajero
     */
    public void setEnvios(List<EnvioDTO> envios) {
        this.envios = envios;
    }
    
    /**
     * @return La lista de los comentarios que los usuarios le dan al mensajero
     */
    public List<CalificacionDTO> getComentarios() {
        return comentarios;
    }
    
    /**
     * @param comentarios los nuevos comentarios asociados del mensajero
     */
    public void setComentarios(List<CalificacionDTO> comentarios) {
        this.comentarios = comentarios;
    }
    
    /**
     * @return La lista de las zonas a las que realiza envios el mensajero
     */
    public List<ZonaDTO> getZonas() {
        return zonas;
    }
    
    /**
     * @param zonas las nuevas zonas asociados del mensajero
     */
    public void setZonas(List<ZonaDTO> zonas) {
        this.zonas = zonas;
    }
    
    public MensajeroEntity toEntity()
    {
        MensajeroEntity entity=new MensajeroEntity();
        entity.setCalificacionPromedio(getCalificacionPromedio());
        entity.setNombre(getNombre());
        entity.setCelular(getCelular());
        entity.setCorreo(getCorreo());
        entity.setId(getId());
        ArrayList<EnvioEntity> nuevaEnvios=new ArrayList<>();
        return entity;
    }
            
}
