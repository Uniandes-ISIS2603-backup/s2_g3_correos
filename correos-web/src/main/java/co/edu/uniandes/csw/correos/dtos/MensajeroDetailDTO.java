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

import co.edu.uniandes.csw.correos.entities.CalificacionEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
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

    }
    
    public MensajeroDetailDTO(MensajeroEntity entity)
    {
        super(entity);
        if(entity.getCalificaciones()!=null)
            for(CalificacionEntity x : entity.getCalificaciones())
                this.comentarios.add(new CalificacionDTO(x));
        if(entity.getEnvios()!=null)
            for(EnvioEntity x:entity.getEnvios())
               this.envios.add(new EnvioDTO(x));
        if(entity.getZonas() !=null)
            for(ZonaEntity x: entity.getZonas())
                this.zonas.add(new ZonaDTO(x));
        if(entity.getTransportes()!=null)
            for(TransporteEntity x: entity.getTransportes())
                this.transportes.add(new TransporteDTO(x));
        if(entity.getCuenta()!=null)
            this.cuentaBancaria=new CuentaBancariaDTO(entity.getCuenta());
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
    
    @Override
    public MensajeroEntity toEntity()
    {
        MensajeroEntity entity= super.toEntity();        
        if(this.envios!=null){
            List<EnvioEntity> nuevaEnvios=new ArrayList<>();
            for(EnvioDTO x: this.envios)
                nuevaEnvios.add(x.toEntity());
            entity.setEnvios(nuevaEnvios);
        }
        if(this.comentarios!=null){
            List<CalificacionEntity> nuevaCalificaciones=new ArrayList<>();
            for(CalificacionDTO x: this.comentarios)
                nuevaCalificaciones.add(x.toEntity());
            entity.setCalificaciones(nuevaCalificaciones);
        }
        if(this.transportes!=null){
            List<TransporteEntity> nuevaTransportes=new ArrayList<>();
            for(TransporteDTO x: this.transportes)
                nuevaTransportes.add(x.toEntity());
            entity.setTransportes(nuevaTransportes);
        }
        if(this.zonas!=null){
            List<ZonaEntity> nuevaZonas=new ArrayList<>();
            for(ZonaDTO x: this.zonas)
                nuevaZonas.add(x.toEntity());
            entity.setZonas(nuevaZonas);
        }
        if(this.cuentaBancaria!=null)
            entity.setCuenta(this.cuentaBancaria.toEntity());
        return entity;
    }

    
            
}
