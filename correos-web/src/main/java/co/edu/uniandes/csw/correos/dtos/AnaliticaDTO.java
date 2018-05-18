/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.*;
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
     * lista de envios por hora 
     */
    private List<ArrayList<EnvioEntity>> enviosPorHora;
    
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
    private List<CalificacionEntity> mejoresCalificaciones;

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
    public AnaliticaDTO(Double precioPromedioTodosLosEnvios, List<ClienteEntity> clientesMasFieles, List<ClienteEntity> clientesQuePerdieronActividadHaceUnMes, Double promedioTarjetasDeCreditoPorCliente, List<MensajeroEntity> mensajerosMasProductivos, List<ArrayList<EnvioEntity>> enviosPorHora, Double volumenPromedioPorPaquete, Double promedioEventosPorEnvio, List<CalificacionEntity> mejoresCalificaciones) {
        this.precioPromedioTodosLosEnvios = precioPromedioTodosLosEnvios;
        this.clientesMasFieles = clientesMasFieles;
        this.clientesQuePerdieronActividadHaceUnMes = clientesQuePerdieronActividadHaceUnMes;
        this.promedioTarjetasDeCreditoPorCliente = promedioTarjetasDeCreditoPorCliente;
        this.mensajerosMasProductivos = mensajerosMasProductivos;
        this.enviosPorHora = enviosPorHora;
        this.volumenPromedioPorPaquete = volumenPromedioPorPaquete;
        this.promedioEventosPorEnvio = promedioEventosPorEnvio;
        this.mejoresCalificaciones = mejoresCalificaciones;
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
    public List<ClienteEntity> getClientesMasFieles() {
        return clientesMasFieles;
    }

    /**
     * @param clientesMasFieles the clientesMasFieles to set
     */
    public void setClientesMasFieles(List<ClienteEntity> clientesMasFieles) {
        this.clientesMasFieles = clientesMasFieles;
    }

    /**
     * @return the clientesQuePerdieronActividadHaceUnMes
     */
    public List<ClienteEntity> getClientesQuePerdieronActividadHaceUnMes() {
        return clientesQuePerdieronActividadHaceUnMes;
    }

    /**
     * @param clientesQuePerdieronActividadHaceUnMes the clientesQuePerdieronActividadHaceUnMes to set
     */
    public void setClientesQuePerdieronActividadHaceUnMes(List<ClienteEntity> clientesQuePerdieronActividadHaceUnMes) {
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
    public List<MensajeroEntity> getMensajerosMasProductivos() {
        return mensajerosMasProductivos;
    }

    /**
     * @param mensajerosMasProductivos the mensajerosMasProductivos to set
     */
    public void setMensajerosMasProductivos(List<MensajeroEntity> mensajerosMasProductivos) {
        this.mensajerosMasProductivos = mensajerosMasProductivos;
    }

    /**
     * @return the enviosPorHora
     */
    public List<ArrayList<EnvioEntity>> getEnviosPorHora() {
        return enviosPorHora;
    }

    /**
     * @param enviosPorHora the enviosPorHora to set
     */
    public void setEnviosPorHora(List<ArrayList<EnvioEntity>> enviosPorHora) {
        this.enviosPorHora = enviosPorHora;
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
    public List<CalificacionEntity> getMejoresCalificaciones() {
        return mejoresCalificaciones;
    }

    /**
     * @param mejoresCalificaciones the mejoresCalificaciones to set
     */
    public void setMejoresCalificaciones(List<CalificacionEntity> mejoresCalificaciones) {
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
    
    
    
}
