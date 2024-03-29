/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.entities;

import co.edu.uniandes.csw.correos.podamstrategy.TenPlusNumericString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author a.silvag
 */
@Entity
public class CuentaBancariaEntity implements Serializable{


    /**
     * numero de la cuenta 
     */
    @PodamStrategyValue(TenPlusNumericString.class)
    private String numero;
    /**
     * string que define el banco 
     */
    private String banco;
    /**
     * string que define el tipo de tarjeta
     */
    private String tipoTarjeta;
    
    /**
     * pagos asociados
     */
    @PodamExclude
    @OneToMany(mappedBy = "cuentaBancaria", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<PagoEntity> pagos = new ArrayList<>();
    
    /**
     * cliente asociado
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    /**
     * id de la cuenta 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     * @return el id
     */
    public Long getId() {
        return id;
    }

    /**
     * setter del id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the tipoTarjeta
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * @param tipoTarjeta the tipoTarjeta to set
     */
    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     * @return the pagos
     */
    public List<PagoEntity> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<PagoEntity> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

   

}
