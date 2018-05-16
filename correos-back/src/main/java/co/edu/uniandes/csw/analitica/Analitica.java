/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.analitica;
import co.edu.uniandes.csw.correos.entities.*;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author a.silvag
 */
public class Analitica {
    
    BonoPersistance bonoP;
    CalificacionPersistence calificacionP;
    ClientePersistence clienteP;
    CuentaBancariaPersistence cuentaP;
    DetallePaquetePersistance detalleP;
    EnvioPersistence envioP;
    EventoPersistence eventoP;
    MensajeroPersistence mensajeroP;
    PagoPersistence pagoP;
    PaquetePersistence paqueteP;
    ReservaPersistence reservaP;
    TarjetaCreditoPersistence tarjetaP;
    TransportePersistence transporteP;
    ZonaPersistence zonaP;
  
    public Analitica(BonoPersistance bp, 
            CalificacionPersistence cp, 
            ClientePersistence clp, 
            CuentaBancariaPersistence cbp, 
            DetallePaquetePersistance dpp, 
            EnvioPersistence ep,
            EventoPersistence evp,
            MensajeroPersistence mp,
            PagoPersistence pp,
            PaquetePersistence pap,
            ReservaPersistence rp,
            TarjetaCreditoPersistence tcp,
            TransportePersistence tp,
            ZonaPersistence zp){
        bonoP = bp;
        calificacionP = cp;
        clienteP = clp;
        cuentaP = cbp;
        detalleP = dpp;
        envioP = ep;
        eventoP = evp;
        mensajeroP = mp;
        pagoP = pp;
        paqueteP = pap;
        reservaP = rp;
        tarjetaP = tcp;
        transporteP = tp;
        zonaP = zp;
    }
    
    public Double darPrecioPromedioTodosLosEnvios(){
        List<EnvioEntity> envios = envioP.findAll();
        Double promedio = 0.0;
        for (EnvioEntity envio : envios) {
            promedio += envio.getPago().getValor();
        }
        return promedio/envios.size();
    }
    
    public List<ClienteEntity> darClientesMasFieles(){
        List<ClienteEntity> clientes = clienteP.findAll();
        Collections.sort(clientes);
        return clientes;
    }
    
    public List<ClienteEntity> darClientesQuePerdieronActividadHaceUnMes(){
        List<ClienteEntity> clientes = darClientesMasFieles();
        LocalDate aMonthAgo = LocalDate.now().minusMonths(1);
        for (ClienteEntity cliente : clientes) {
            List<EnvioEntity> envios = cliente.getEnvios();
            for (EnvioEntity envio : envios) {
                //if(envio.ge)
            }
        }
        return clientes;
    }
    
}
