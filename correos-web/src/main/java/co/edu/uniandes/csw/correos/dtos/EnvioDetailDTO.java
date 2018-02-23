 /* To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package co.edu.uniandes.csw.correos.dtos;
 
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