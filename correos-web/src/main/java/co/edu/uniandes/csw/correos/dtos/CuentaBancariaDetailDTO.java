/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import java.util.List;

/**
 *
 * @author a.silvag
 */
public class CuentaBancariaDetailDTO extends CuentaBancariaDTO {

private List<PagoDTO> pagos;

public CuentaBancariaDetailDTO(){
    
}
/**
 * 
 * @return la lista de pagos
 */
    public List<PagoDTO> getPagos() {
        return pagos;
    }
/**
 * 
 * @param pagos la lista de pagos
 */
    public void setPagos(List<PagoDTO> pagos) {
        this.pagos = pagos;
    }

    
    



}
