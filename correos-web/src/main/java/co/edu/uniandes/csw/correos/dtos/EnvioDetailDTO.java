 /* To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package co.edu.uniandes.csw.correos.dtos;
 
import co.edu.uniandes.csw.correos.entities.BonoEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
 import java.util.List;
 import java.util.ArrayList;
 
 /**
  *
  * @author df.rengifo
  */
 public class EnvioDetailDTO extends EnvioDTO {
     
        private ClienteDTO cliente;
        private PagoDTO pago;
        private MensajeroDTO mensajero;
        private List<EventoDTO> eventos=new ArrayList<>();  
        private List<PaqueteDTO> paquetes=new ArrayList<>();
        private List<BonoDTO> bonos=new ArrayList<>();
        
        /**
         * Constructor por defecto
         */
        public EnvioDetailDTO()
        {
            super();
        }
        
        /**
         * 
         * @param entity El envio a ser creado
         */
        public EnvioDetailDTO(EnvioEntity entity)
        {            
        super(entity);        
        
            for(int i = 0; i< entity.getBonos().size(); i++){
                this.bonos.add(new BonoDTO(entity.getBonos().get(i)));
            }
            for(int i = 0; i< entity.getEventos().size(); i++){
                this.eventos.add(new EventoDTO(entity.getEventos().get(i)));
            }
            for(int i = 0; i< entity.getPaquetes().size(); i++){
                this.paquetes.add(new PaqueteDTO(entity.getPaquetes().get(i)));
            }
            this.cliente=new ClienteDTO(entity.getCliente());
            this.mensajero=new MensajeroDTO(entity.getMensajero());
            this.pago=new PagoDTO(entity.getPago());
        }
        
        /**
         * 
         * @return la entidad recien convertida
         */
        @Override
        public EnvioEntity toEntity()
        {
            EnvioEntity entity= super.toEntity();        
        
            List<EventoEntity> newEventos = new ArrayList<>();
            List<BonoEntity> newBonos = new ArrayList<>();
            List<PaqueteEntity> newPaquetes = new ArrayList<>();
            
            for(int i = 0; i< eventos.size(); i++){
                newEventos.add(eventos.get(i).toEntity());
            }
            for(int i = 0; i< bonos.size(); i++){
                newBonos.add(bonos.get(i).toEntity());
            }
            for(int i = 0; i< paquetes.size(); i++){
                newPaquetes.add(paquetes.get(i).toEntity());
            }
                
            entity.setEventos(newEventos);
            entity.setBonos(newBonos);
            entity.setPaquetes(newPaquetes);
            entity.setCliente(this.cliente.toEntity());
            entity.setPago(this.pago.toEntity());
            entity.setMensajero(this.mensajero.toEntity());        
        
            return entity;        
        }      
        
        /**
         * @return La lista de los eventos asociados al envio
         */
        public List<EventoDTO> getEventos() {
            return eventos;
        }
        
        /**
         * @param eventos nuevos eventos para el envio
         */
        public void setEventos(List<EventoDTO> eventos) {
            this.eventos = eventos;
        }
        
        /**
         * @return La lista de los paquetes asociados al envio
         */
        public List<PaqueteDTO> getPaquetes() {
            return paquetes;
        }
        
        /**
         * @param paquetes nuevos paquetes para el envio
         */
        public void setPaquetes(List<PaqueteDTO> paquetes) {
            this.paquetes = paquetes;
        }
        
        /**
         * @return La lista de los bonos asociados al envio
         */
        public List<BonoDTO> getBonos() {
            return bonos;
        }
        
        /**
         * @param bonos nuevos bonos para el envio
         */
        public void setBonos(List<BonoDTO> bonos) {
            this.bonos = bonos;
        }

        /**
         * @return el cliente asociado al envio
         */
        public ClienteDTO getCliente() {
            return cliente;
        }
        
        /**
         * @param cliente el nuevo cliente asociado al envio
         */
        public void setCliente(ClienteDTO cliente) {
            this.cliente = cliente;
        }
        
        /**
         * @return el mensajero asociado al envio
         */
        public MensajeroDTO getMensajero() {
            return mensajero;
        }
        
        /**
         * @param mensajero el nuevo mensajero asociado al envio
         */
        public void setMensajero(MensajeroDTO mensajero) {
            this.mensajero = mensajero;
        }
        
        /**
         * @return el pago asociado al envio
         */
        public PagoDTO getPago() {
            return pago;
        }
        
        /**
         * @param pago el nuevo pago asociado al envio
         */
        public void setPago(PagoDTO pago) {
            this.pago = pago;
        }
 }