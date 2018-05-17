/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.entities.PagoEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EnvioPersistence;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author df.rengifo
 */
@Stateless
public class EnvioLogic {
    
    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(EnvioLogic.class.getName());

    /**
     * relacion con la persistencia de envio
     */
    private EnvioPersistence persistence;

    /**
     * relacion con la logica de mensajero
     */
    private MensajeroLogic mensajeroLogic;
    
    /**
     * relacion con la persistencia de mensajero
     */
    private MensajeroPersistence mensajeroP;

    /**
     * se inyeta la logica
     * @param persistence
     * @param mensajeroLogic
     * @param mensajeroP 
     */
    @Inject
    public EnvioLogic(EnvioPersistence persistence, MensajeroLogic mensajeroLogic, MensajeroPersistence mensajeroP)
    {
        this.persistence=persistence;
        this.mensajeroP=mensajeroP;
        this.mensajeroLogic=mensajeroLogic;
    }
    
    /**
     * constructor
     */
    public EnvioLogic()
    {
        this.persistence=null;
        this.mensajeroP=null;
        this.mensajeroLogic=null;
    }
    

    /**
     * @param entity el envio a ser creado
     * @return el envio recien creado
     * @throws BusinessLogicException 
     */
    public EnvioEntity createEnvio(EnvioEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Se comienza a crear un Envio "); 
        
        if (entity.getHoraInicio()>entity.getHoraFinal()){
            throw new BusinessLogicException("La Hora Final es anterior a la Hora Incial.");
        }
        else if (entity.getEstado()==null){
            throw new BusinessLogicException("No se reconoce un estado.");
        }      

        persistence.create(entity);
        asignarMensajero(entity);
        MensajeroEntity mensajero = entity.getMensajero();
        TarjetaCreditoEntity tarjeta = entity.getCliente().getTarjetaCredito();
        asignarPago(entity, mensajero, );

        LOGGER.info("Se termina de crear un Envio");
        return entity;
    }
    
    /**
     * 
     * @param id ID del envio buscado
     * @return el envio buscado
     */
    public EnvioEntity getEnvio(Long id){
        return persistence.find(id);
    }
    
    /**
     * 
     * @return todos los envios del sistema
     * @throws BusinessLogicException 
     */
    public List<EnvioEntity> getEnvios() throws BusinessLogicException 
    {        
        LOGGER.info("Se comienzan a buscar todos los Envios"); 

        List<EnvioEntity> envios = persistence.findAll();

        for(EnvioEntity x:envios)
        {
            if(!("FINALIZADO").equals(x.getEstado()))
                asignarMensajero(x);
        } 
        
        LOGGER.info("Se terminan de buscar todos los Envios");
        return envios;
    } 
    
    /**
     * 
     * @param entity el envio a ser actualizado
     * @return el envio atualizado
     * @throws BusinessLogicException 
     */
    public EnvioEntity updateEnvio(EnvioEntity entity) throws BusinessLogicException  {
        
        LOGGER.info("se comienza a actualizar un envio");
        
        if (entity.getHoraInicio()>entity.getHoraFinal()){
            throw new BusinessLogicException("La Hora Final es anterior a la Hora Incial.");
        }
        else if (entity.getEstado()==null){
            throw new BusinessLogicException("No se reconoce un estado.");
        }
        
        return persistence.update(entity);
    }
    
    /**
     * 
     * @param id ID del envio a ser borrado
     * @throws BusinessLogicException 
     */
    public void deleteEnvio(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Comienza a borrar el envio de id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina a borrar el envio de id={0}", id);
    }   
    
    /**
     * 
     * @param id el ID del evento al que se le va a anadir el nuevo detalle
     * @param evento el evento a ser anadido
     */
    public void agregarEvento(Long id, EventoEntity evento)
    {
       EnvioEntity envio= persistence.find(id);
       evento.setEnvio(envio);
       List<EventoEntity> eventos = envio.getEventos();
       eventos.add(evento);
       envio.setEventos(eventos);
       
       persistence.update(envio);
    }
    
    /**
     * 
     * @param id el ID del envio al que se le va a anadir el nuevo paquete
     * @param paquete el paquete a ser anadido
     */
    public void agregarPaquete(Long id, PaqueteEntity paquete)
    {
       EnvioEntity envio= persistence.find(id);
       List<PaqueteEntity> paquetes = envio.getPaquetes();
       paquetes.add(paquete);
       envio.setPaquetes(paquetes);
       persistence.update(envio);
       LOGGER.info(envio.getPaquetes().get(envio.getPaquetes().size()-1).getTipo());
       LOGGER.info(persistence.find(id).getPaquetes().get(envio.getPaquetes().size()-1).getTipo());
    }
    
    /**
     * se llama cuando se crea un envio y crea un pago asociado al envio
     * @param envio que se esta creando 
     * @param mensajero mensajero a quien se va a consignar el pago
     * @param tarjeta tarjeta de la cual se paga
     */
    public void asignarPago(EnvioEntity envio, MensajeroEntity mensajero, TarjetaCreditoEntity tarjeta)          
    {
        EnvioEntity envioPago = new EnvioEntity();
        PagoEntity nuevoPago = new PagoEntity();
        nuevoPago.setValor(100000.0);
        nuevoPago.setCuentaBancaria(mensajero.getCuenta());
        nuevoPago.setTarjetaCredito(tarjeta);
        nuevoPago.setFecha(new Date());
        
        envioPago.setPago(nuevoPago);
        
    }
    
    /**
     * se le asigna mensajero al envio
     * @param envio 
     */
    public void asignarMensajero(EnvioEntity envio)
    {
        for(MensajeroEntity x:mensajeroLogic.getMensajeros())
        {
            if(!x.isOcupado())
            {
                for(TransporteEntity w:x.getTransportes() ){
                    if(w.isActivo()){
                        envio.setMensajero(x);
                        x.agregarEnvio(envio);
                        x.setOcupado(true);
                        mensajeroP.update(x);
                        break;
                    }
                }
                if(x.isOcupado())
                    break;
            }
        }
        persistence.update(envio);
    }
    
    /**
     * se porra el evento por param
     * @param envio
     * @param evento
     * @throws BusinessLogicException 
     */
    public void borrarEvento(Long envio, Long evento) throws BusinessLogicException{
        EnvioEntity cambiar = getEnvio(envio);
        List<EventoEntity> trans = cambiar.getEventos();
        for(int i=0; i<trans.size(); i++)
        {
            if(trans.get(i).getId().equals(evento))
            {
                trans.remove(i);
                break;
            }
        }       
        cambiar.setEventos(trans);
        updateEnvio(cambiar);
    }
}

