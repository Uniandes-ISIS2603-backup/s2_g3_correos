/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.dtos;

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.entities.PagoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a.silvag
 */
public class CuentaBancariaDetailDTO extends CuentaBancariaDTO {

private List<PagoDTO> pagos;

public CuentaBancariaDetailDTO(){
    
}

public CuentaBancariaDetailDTO(CuentaBancariaEntity entity){
    super(entity);
        if (entity != null) {
            pagos = new ArrayList<>();
            for (PagoEntity entityPagos : entity.getPagos()) {
                pagos.add(new PagoDTO(entityPagos));
            }

        }
}
/**
 * 
 * @return la lista de pagos
 */

public CuentaBancariaEntity toEntity(){
    CuentaBancariaEntity entity = super.toEntity();
    List<PagoEntity> list = new ArrayList<>();
    for(PagoDTO pago:pagos){
        list.add(pago.toEntity());
    }
    entity.setPagos(list);
    return entity;
}
        
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
