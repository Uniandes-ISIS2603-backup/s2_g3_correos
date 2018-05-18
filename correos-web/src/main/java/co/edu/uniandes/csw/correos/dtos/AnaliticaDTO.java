/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.*;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.silvag
 */

public class AnaliticaDTO {
    /**
     * Precio promedio de todos los envios
     */
    private Double precioPromedioTodosLosEnvios;

    /**
     * lista de clientes mas fieles
     */
    private List<ClienteEntity> clientesMasFieles;
    /**
     * lista de clientes que perdieron actividades hace un mes 
     */
    private List<ClienteEntity> clientesQuePerdieronActividadHaceUnMes;
    /**
     * promedio de tarjetas de credito por cliente
     */
    private Double promedioTarjetasDeCreditoPorCliente;
    /**
     * mensajeros mas productivos 
     */
    private List<MensajeroEntity> mensajerosMasProductivos;
  
    /**
     * promedio de volumen por paquete
     */

    private Double volumenPromedioPorPaquete;
    /**
     * promedio de eventos por envio 
     */
    private Double promedioEventosPorEnvio;

    /**
     * lisa de mejores calificaciones
     */

    private List<CalificacionDTO> mejoresCalificaciones;
      /**
     * lisa de mejores mensajeros calificaciones
     */
    private List<MensajeroDTO> mensajerosConMejorCalificacion;


    /**
     * constructor que se deja vacio por defecto 
     */
    public AnaliticaDTO(){
        // se deja vacio por defecto 
    }


  
      /**
     * constructor 
     * @param precioPromedioTodosLosEnvios
     * @param clientesMasFieles
     * @param clientesQuePerdieronActividadHaceUnMes
     * @param promedioTarjetasDeCreditoPorCliente
     * @param mensajerosMasProductivos
     * @param enviosPorHora
     * @param volumenPromedioPorPaquete
     * @param promedioEventosPorEnvio
     * @param mejoresCalificaciones 
     */
    public AnaliticaDTO(Double pPrecioPromedioTodosLosEnvios, List<ClienteEntity> pClientesMasFieles, List<ClienteEntity> pClientesQuePerdieronActividadHaceUnMes, Double pPromedioTarjetasDeCreditoPorCliente, List<MensajeroEntity> pMensajerosMasProductivos,  Double pVolumenPromedioPorPaquete, Double pPromedioEventosPorEnvio, List<CalificacionEntity> pMejoresCalificaciones, List<MensajeroEntity> brevPa2) {

        this.precioPromedioTodosLosEnvios = pPrecioPromedioTodosLosEnvios;
        this.clientesMasFieles = new ArrayList<>();
        if(pClientesMasFieles!=null){
            for (ClienteEntity x : pClientesMasFieles) {
                this.clientesMasFieles.add(new ClienteDTO(x));
            }
        }
        this.clientesQuePerdieronActividadHaceUnMes = new ArrayList<>();
        if(pClientesQuePerdieronActividadHaceUnMes!=null){
            for (ClienteEntity x : pClientesQuePerdieronActividadHaceUnMes) {
                this.clientesQuePerdieronActividadHaceUnMes.add(new ClienteDTO(x));
            }
        }
        this.promedioTarjetasDeCreditoPorCliente = pPromedioTarjetasDeCreditoPorCliente;
        this.mensajerosMasProductivos = new ArrayList<>();
                if(pMensajerosMasProductivos!=null){
            for (MensajeroEntity x : pMensajerosMasProductivos) {
                this.mensajerosMasProductivos.add(new MensajeroDTO(x));
            }
        }
        this.volumenPromedioPorPaquete = pVolumenPromedioPorPaquete;
        this.promedioEventosPorEnvio = pPromedioEventosPorEnvio;
        this.mejoresCalificaciones = new ArrayList<>();
        if(pMejoresCalificaciones!=null){
            for (CalificacionEntity x : pMejoresCalificaciones) {
                this.mejoresCalificaciones.add(new CalificacionDTO(x));
            }
        }
        this.mensajerosConMejorCalificacion = new ArrayList<>();
        if(brevPa2!=null){
             for (MensajeroEntity x : brevPa2) {
                this.mensajerosConMejorCalificacion.add(new MensajeroDTO(x));
            }
        }
    }

   



    

    
    /**
     * @return the precioPromedioTodosLosEnvios
     */
    public Double getPrecioPromedioTodosLosEnvios() {
        return precioPromedioTodosLosEnvios;
    }

    /**
     * @param precioPromedioTodosLosEnvios the precioPromedioTodosLosEnvios to set
     */
    public void setPrecioPromedioTodosLosEnvios(Double precioPromedioTodosLosEnvios) {
        this.precioPromedioTodosLosEnvios = precioPromedioTodosLosEnvios;
    }

    /**
     * @return the clientesMasFieles
     */
    public List<ClienteDTO> getClientesMasFieles() {
        return clientesMasFieles;
    }

    /**
     * @param clientesMasFieles the clientesMasFieles to set
     */
    public void setClientesMasFieles(List<ClienteDTO> clientesMasFieles) {
        this.clientesMasFieles = clientesMasFieles;
    }

    /**
     * @return the clientesQuePerdieronActividadHaceUnMes
     */
    public List<ClienteDTO> getClientesQuePerdieronActividadHaceUnMes() {
        return clientesQuePerdieronActividadHaceUnMes;
    }

    /**
     * @param clientesQuePerdieronActividadHaceUnMes the clientesQuePerdieronActividadHaceUnMes to set
     */
    public void setClientesQuePerdieronActividadHaceUnMes(List<ClienteDTO> clientesQuePerdieronActividadHaceUnMes) {
        this.clientesQuePerdieronActividadHaceUnMes = clientesQuePerdieronActividadHaceUnMes;
    }

    /**
     * @return the promedioTarjetasDeCreditoPorCliente
     */
    public Double getPromedioTarjetasDeCreditoPorCliente() {
        return promedioTarjetasDeCreditoPorCliente;
    }

    /**
     * @param promedioTarjetasDeCreditoPorCliente the promedioTarjetasDeCreditoPorCliente to set
     */
    public void setPromedioTarjetasDeCreditoPorCliente(Double promedioTarjetasDeCreditoPorCliente) {
        this.promedioTarjetasDeCreditoPorCliente = promedioTarjetasDeCreditoPorCliente;
    }

    /**
     * @return the mensajerosMasProductivos
     */
    public List<MensajeroDTO> getMensajerosMasProductivos() {
        return mensajerosMasProductivos;
    }

    /**
     * @param mensajerosMasProductivos the mensajerosMasProductivos to set
     */
    public void setMensajerosMasProductivos(List<MensajeroDTO> mensajerosMasProductivos) {
        this.mensajerosMasProductivos = mensajerosMasProductivos;
    }



    /**
     * @return the promedioEventosPorEnvio
     */
    public Double getPromedioEventosPorEnvio() {
        return promedioEventosPorEnvio;
    }

    /**
     * @param promedioEventosPorEnvio the promedioEventosPorEnvio to set
     */
    public void setPromedioEventosPorEnvio(Double promedioEventosPorEnvio) {
        this.promedioEventosPorEnvio = promedioEventosPorEnvio;
    }

    /**
     * @return the mejoresCalificaciones
     */
    public List<CalificacionDTO> getMejoresCalificaciones() {
        return mejoresCalificaciones;
    }

    /**
     * @param mejoresCalificaciones the mejoresCalificaciones to set
     */
    public void setMejoresCalificaciones(List<CalificacionDTO> mejoresCalificaciones) {
        this.mejoresCalificaciones = mejoresCalificaciones;
    }

    /**
     * @return the volumenPromedioPorPaquete
     */
    public Double getVolumenPromedioPorPaquete() {
        return volumenPromedioPorPaquete;
    }

    /**
     * @param volumenPromedioPorPaquete the volumenPromedioPorPaquete to set
     */
    public void setVolumenPromedioPorPaquete(Double volumenPromedioPorPaquete) {
        this.volumenPromedioPorPaquete = volumenPromedioPorPaquete;
    }

    /**
     * @return the mensajerosConMejorCalificacion
     */
    public List<MensajeroDTO> getMensajerosConMejorCalificacion() {
        return mensajerosConMejorCalificacion;
    }

    /**
     * @param mensajerosConMejorCalificacion the mensajerosConMejorCalificacion to set
     */
    public void setMensajerosConMejorCalificacion(List<MensajeroDTO> mensajerosConMejorCalificacion) {
        this.mensajerosConMejorCalificacion = mensajerosConMejorCalificacion;
    }

   
    
    
    
}
