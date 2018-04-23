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
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.BonoEntity;
import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.ReservaEntity;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que extiende de {@link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del ReservaDTO vaya a la documentacion de {@link ReservaDTO}
 *@author da.leon
 */
public class ClienteDetailDTO extends ClienteDTO
{

    
    public List<EnvioDTO> envios=new ArrayList<>();
    public List<TarjetaCreditoDTO> tarjetas=new ArrayList<>();
    public List<ReservaDTO> reservas=new ArrayList<>();
    public List<BonoDTO> bonos=new ArrayList<>();

    public ClienteDetailDTO()
    {
        super();
    }
    
    public ClienteDetailDTO(ClienteEntity cliente)
    {
        super(cliente);
        if(cliente.getEnvios()!=null)
            for(EnvioEntity x: cliente.getEnvios())
                this.envios.add(new EnvioDTO(x));
        if(cliente.getTarjetasCredito()!=null)
            for(TarjetaCreditoEntity x: cliente.getTarjetasCredito())
                this.tarjetas.add(new TarjetaCreditoDTO(x));
        if(cliente.getReservas()!=null)
            for(ReservaEntity x: cliente.getReservas())
                this.reservas.add(new ReservaDTO(x));
        if(cliente.getBonos()!=null)
            for(BonoEntity x: cliente.getBonos())
                this.bonos.add(new BonoDTO(x));
    }
    
    
    public List<EnvioDTO> getEnvios() {
        return envios;
    }

    public void setEnvios(List<EnvioDTO> envios) {
        this.envios = envios;
    }

    public List<TarjetaCreditoDTO> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaCreditoDTO> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    public List<BonoDTO> getBonos() {
        return bonos;
    }

    public void setBonos(List<BonoDTO> bonos) {
        this.bonos = bonos;
    }
    
    
    public ClienteEntity toEntity()
    {
        ClienteEntity cliente=super.toEntity();
        if(this.bonos!=null)
        {
            List<BonoEntity> bonosN=new ArrayList<>();
            for(BonoDTO x: this.bonos)
                bonosN.add(x.toEntity());
            cliente.setBonos(bonosN);
        }
        if(this.envios!=null)
        {
            List<EnvioEntity> nuevaEnvios=new ArrayList<>();
            for(EnvioDTO x: this.envios)
                nuevaEnvios.add(x.toEntity());
            cliente.setEnvio(nuevaEnvios);
        }
        if(this.reservas!=null)
        {
            List<ReservaEntity> nuevaReservas=new ArrayList<>();
            for(ReservaDTO x: this.reservas)
                nuevaReservas.add(x.toEntity());
            cliente.setReservas(nuevaReservas);
        }
        if(this.tarjetas!=null)
        {
            List<TarjetaCreditoEntity> nuevaTarjetas=new ArrayList<>();
            for(TarjetaCreditoDTO x: this.tarjetas)
                nuevaTarjetas.add(x.toEntity());
            cliente.setTarjetasCredito(nuevaTarjetas);
        }
        return cliente;
    }
}
