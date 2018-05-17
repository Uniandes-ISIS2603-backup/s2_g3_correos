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
    
    private Double precioPromedioTodosLosEnvios;
    private List<ClienteEntity> clientesMasFieles;
    private List<ClienteEntity> clientesQuePerdieronActividadHaceUnMes;
    private Double promedioTarjetasDeCreditoPorCliente;
    private List<MensajeroEntity> mensajerosMasProductivos;
    private List<ArrayList<EnvioEntity>> enviosPorHora;
    private Double volumenPromedioPorPaquete;
    private Double promedioEventosPorEnvio;
    private List<CalificacionEntity> mejoresCalificaciones;

    public AnaliticaDTO(){
        
    }

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
