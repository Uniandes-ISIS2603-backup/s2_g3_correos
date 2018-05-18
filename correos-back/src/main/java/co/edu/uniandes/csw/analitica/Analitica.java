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
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author a.silvag
 */
@Stateless
public class Analitica {
    
    
    CalificacionPersistence calificacionP;
    ClientePersistence clienteP;
    
    
    EnvioPersistence envioP;
    MensajeroPersistence mensajeroP;
    PagoPersistence pagoP;
    PaquetePersistence paqueteP;
  
    @Inject
    public Analitica(
            CalificacionPersistence cp, 
            ClientePersistence clp,  
            EnvioPersistence ep,
            MensajeroPersistence mp,
            PagoPersistence pp,
            PaquetePersistence pap,
            TransportePersistence tp){
        
        calificacionP = cp;
        clienteP = clp;
        
       
        envioP = ep;
        mensajeroP = mp;
        pagoP = pp;
        paqueteP = pap;
    }

    public Analitica() {
      
        calificacionP = null;
        clienteP = null;
       
        
        envioP = null;
        mensajeroP = null;
        pagoP = null;
        paqueteP = null;
    }
    
    
    
    public Double darPrecioPromedioTodosLosEnvios(){
        List<PagoEntity> envios = pagoP.findAll();
        Double promedio = 0.0;
        for (PagoEntity envio : envios) {
            promedio += envio.getValor();
        }
        return promedio/envios.size();
    }
    
    public List<ClienteEntity> darClientesMasFieles(){
        List<ClienteEntity> clientes = clienteP.findAll();
        Collections.sort(clientes);
        return clientes;
    }
    
    public List<ClienteEntity> darClientesQuePerdieronActividadHaceUnMes(){
        List<ClienteEntity> clientes = clienteP.findAll();
        List<ClienteEntity> ret = new ArrayList<>();
        Date aMonthAgo = new Date();
        aMonthAgo.setMonth(aMonthAgo.getMonth()-1);
        for (ClienteEntity cliente : clientes) {
            List<EnvioEntity> envios = cliente.getEnvios();
            for (EnvioEntity envio : envios) {
                if (envio.getFecha().before(aMonthAgo)){
                    ret.add(cliente);
                }
            }
        }
        return ret;
    }
    
    public Double darPromedioTarjetasDeCreditoPorCliente(){
        List<ClienteEntity> tarjetas = clienteP.findAll();
        Double promedio = 0.0;
        for (ClienteEntity tarjeta : tarjetas) {
            promedio += tarjeta.getTarjetasCredito().size();
        }
        return promedio/tarjetas.size();
    }
    
        public List<MensajeroEntity> darMensajerosMasProductivos(){
        List<MensajeroEntity> clientes = mensajeroP.findAll();
        Collections.sort(clientes);
        return clientes;
    }
         
         
        public List<MensajeroEntity> darMensajerosConMayorCalificacion(){
            List<MensajeroEntity> mensajeros = mensajeroP.findAll();
            sort(mensajeros,0,mensajeros.size()-1);
            return mensajeros;
        }
        
        public List<ArrayList<EnvioEntity>> darEnviosPorHora(){
            List<ArrayList<EnvioEntity>> lista = new ArrayList<ArrayList<EnvioEntity>>();
            for (int i =0; i<24;i++) {
                lista.add(new ArrayList<EnvioEntity>());
            }
            List<EnvioEntity> envios = envioP.findAll();
            for (EnvioEntity envio : envios) {
                lista.get(envio.getHoraInicio().intValue()).add(envio);
            }
            return lista;
        }
        
        public Double darVolumenPromedioPaquetes(){
            List<PaqueteEntity> envios = paqueteP.findAll();
            double counter = 0;
            for (PaqueteEntity envio : envios) {
               counter+= envio.getDimensionA()*envio.getDimensionB()*envio.getDimensionC();
            }
            return counter/envios.size();
        }
        
        public Double darPromedioEventosPorEnvio(){
            List<EnvioEntity> envios = envioP.findAll();
            Double counter = 0.0;
            for (EnvioEntity envio : envios) {
                counter += envio.getEventos().size();
            }
            return counter/envios.size();
        }
        
        public List<CalificacionEntity> darMejoresCalificaciones(){
            List<CalificacionEntity> clientes = calificacionP.findAll();
            Collections.sort(clientes);
            return clientes;
        }
        
        
        
        
        
        
        /////////////////////////////////////////////////////////////////Sorts y metodos auxiliares///////////////////////////////////////////////////////
        
        
        private void merge(List<MensajeroEntity> arr, int l, int m, int r){
            int n1 = m-l+1;
            int n2 = r-m;
            
            MensajeroEntity L[] = new MensajeroEntity[n1];
            MensajeroEntity R[] = new MensajeroEntity[n2];
            
            for(int i=0; i<n1;++i){
                L[i]=arr.get(i+l);
            }
            for(int j=0; j<n2; ++j){
                R[j]=arr.get(m+1+j);
            }
            
            int i=0,j=0, k=l;
            while(i<n1&&j<n2){
                if(L[i].compareTo2(R[j])<=0){
                    arr.set(k, L[i]);
                    i++;
                }
                else{
                arr.set(k, R[j]);
                j++;
                }
                k++;
            }
            while(i<n1){
                arr.set(k,L[i]);
                i++;
                k++;
            }
            while(j<n2){
                arr.set(k,R[j]);
                j++;
                k++;
            }
        }
        
        private void sort(List<MensajeroEntity> arr, int l, int r){
            if(l<r){
                int m = (l+r)/2;
                sort(arr,l,m);
                sort(arr,m+1,r);
                merge(arr,l,m,r);
            }
        }
        
    
}
