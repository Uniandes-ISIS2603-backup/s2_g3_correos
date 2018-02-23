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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author l.mejia
 */
@Entity
public class MensajeroEntity extends BaseEntity implements Serializable {
    
    private String correo;
    private String nombre;
    private String celular;
    private Double calificacionPromedio;
    
//    @OneToOne(fetch = FetchType.EAGER)
//    private CuentaBancariaEntity cuenta;
//    
//    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<TransporteEntity> transportes;
//    
//    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CalificacionEntity> calificaciones;
//    
//    @OneToMany(mappedBy="mensajero", fetch = FetchType.LAZY)
//    private List<EnvioEntity> envios;
//    
//    @ManyToMany(mappedBy="zonas", fetch = FetchType.LAZY)
//    private List<ZonaEntity> zonas;
    
    
    
    /**
     * @return  El correo del mensajero
     */
    public String getCorreo() {
        return correo;
    }
    
    /**
     * @param correo el nuevo correo del mensajero
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * @return  El nombre del mensajero
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @param nombre el nuevo nombre del mensajero
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @return  El celular del mensajero
     */
    public String getCelular() {
        return celular;
    }
    
    /**
     * @param celular el nuevo celular del mensajero
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    /**
     * @return  la calificación promedio del mensajero
     */
    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }
    
    /**
     * @param calificacionPromedio la nueva calificación promedio del mensajero
     */
    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

//    public CuentaBancariaEntity getCuenta() {
//        return cuenta;
//    }
//
//    public void setCuenta(CuentaBancariaEntity cuenta) {
//        this.cuenta = cuenta;
//    }
//
//    public List<TransporteEntity> getTransportes() {
//        return transportes;
//    }
//
//    public void setTransportes(List<TransporteEntity> transportes) {
//        this.transportes = transportes;
//    }
//
//    public List<CalificacionEntity> getCalificaciones() {
//        return calificaciones;
//    }
//
//    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
//        this.calificaciones = calificaciones;
//    }
//
//    public List<EnvioEntity> getEnvios() {
//        return envios;
//    }
//
//    public void setEnvios(List<EnvioEntity> envios) {
//        this.envios = envios;
//    }
//
//    public List<ZonaEntity> getZonas() {
//        return zonas;
//    }
//
//    public void setZonas(List<ZonaEntity> zonas) {
//        this.zonas = zonas;
//    }
    
    
    
}
