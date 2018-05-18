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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author l.mejia
 */
@Entity
public class MensajeroEntity implements Serializable, Comparable {
    
    /**
     * correo electronico del mensajero
     */
    private String correo;
    
    /**
     * nombre del mensajero
     */
    private String nombre;
    
    /**
     * celular del mensajero
     */
    private String celular;
    
    /**
     * caliicacion promedio del mensajero
     */
    private Double calificacionPromedio;


    private String password;

    /**
     * atributo que define si el mensajero esta ocupado o no 
     */
    private boolean ocupado;
    
    /**
     * asociacion con cuenta bancaria
     */
    @PodamExclude
   @OneToOne(cascade= CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private CuentaBancariaEntity cuenta;
   
    /**
     * asociacion con transportes 
     */
    @PodamExclude
    @OneToMany(cascade=CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
   private List<TransporteEntity> transportes;
  
    /**
     * asociacion con calificaciones 
     */
    @PodamExclude
   @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private List<CalificacionEntity> calificaciones;

    /**
     * asociacion con envios 
     */
    @PodamExclude
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy="mensajero", fetch = FetchType.LAZY)
    private List<EnvioEntity> envios;
    
    /**
     * zonas asociadas 
     */
    @PodamExclude
    @ManyToMany(mappedBy="mensajeros", fetch = FetchType.LAZY)
    private List<ZonaEntity> zonas;
   
    /**
     * id del mensajero
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * set the id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    
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

    /**
     * 
     * @return the cuenta bancaria
     */
    public CuentaBancariaEntity getCuenta() {
        return cuenta;
    }

    /**
     * set the cuenta bancaria
     * @param cuenta 
     */
    public void setCuenta(CuentaBancariaEntity cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * 
     * @return the transportes
     */
    public List<TransporteEntity> getTransportes() {
        return transportes;
    }

    
    /**
     * set the transportes
     * @param transportes 
     */
    public void setTransportes(List<TransporteEntity> transportes) {
        this.transportes = transportes;
    }

    /**
     * 
     * @return the calificaciones
     */
    public List<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    /**
     * set the calificaciones
     * @param calificaciones 
     */
    public void setCalificaciones(List<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * 
     * @return all the envios
     */
    public List<EnvioEntity> getEnvios() {
        return envios;
    }

    /**
     * set the envios
     * @param envios 
     */
    public void setEnvios(List<EnvioEntity> envios) {
        this.envios = envios;
    }

    /**
     * 
     * @return the zonas
     */
    public List<ZonaEntity> getZonas() {
        return zonas;
    }

    /**
     * set the zonas
     * @param zonas 
     */
    public void setZonas(List<ZonaEntity> zonas) {
        this.zonas = zonas;
    }

    /**
     * 
     * @return ocupado
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * set ocupado boolean
     * @param ocupado 
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * agrega envio por param
     * @param envio 
     */
    public void agregarEnvio(EnvioEntity envio)
    {
        this.envios.add(envio);
    }
    


    

    /**
     * metodo compare to de analitica
     * @param o
     * @return un entero que verifiaca la comprobacion 
     */

    @Override
    public int compareTo(Object o) {
      MensajeroEntity  pCliente= (MensajeroEntity)o;
        return this.envios.size()<pCliente.envios.size()?-1:this.envios.size()>pCliente.envios.size()?1:0;    }
    
    public int compareTo2(MensajeroEntity pMensajero){
        return this.calificacionPromedio< pMensajero.calificacionPromedio?-1:this.calificacionPromedio>pMensajero.calificacionPromedio?1:0;
    }

    public String getPassword()
    {
        return this.password;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    

}
