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
package co.edu.uniandes.csw.correos.ejb;

import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author da.leon
 */
@Stateless
public class ClienteLogic {

    /**
     * logger
     */
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    /**
     * conexcion con la persistencia
     */
    private ClientePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
    /*
    conexion con la logica
    */
    @Inject
    public ClienteLogic(ClientePersistence clientePersistence)
    {
        this.persistence=clientePersistence;
    }
    
    /*
    constructor
    */
    public ClienteLogic()
    {
        this.persistence=null;
    }
    /**
     * 
     * @param entity
     * @return un nuevo cliente
     * @throws BusinessLogicException 
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de cliente");
        // Verifica la regla de negocio que dice que no puede haber dos cliente con el mismo nombre
        if (persistence.findByName(entity.getNombre()) != null) {
            throw new BusinessLogicException("Ya existe un cliente con el nombre \"" + entity.getNombre() + "\"");
        }
        // Invoca la persistencia para crear el cliente
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación del cliente");
        return entity;
    }
    
    /**
     * 
     * @return todos los clientes
     */
    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todos los clientes");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<ClienteEntity> editorials = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los clientes");
        return editorials;
    }
    
    /**
     * 
     * @param id
     * @return el cliennte con id por param
     */
    public ClienteEntity getCliente(Long id) {
        return persistence.find(id);
    }

    
    /**
     * 
     * @param entity
     * @return el nuevo cliente actualizado
     * @throws BusinessLogicException 
     */
    public ClienteEntity updateCliente(ClienteEntity entity) throws BusinessLogicException  {
        if (persistence.findByName(entity.getNombre()) != null) {
            throw new BusinessLogicException("Ya existe un cliente con el nombre \"" + entity.getNombre() + "\"");
        }
        return persistence.update(entity);
    }
    
    
    /**
     * se borra el cliente por id
     * @param id
     * @throws BusinessLogicException 
     */
    public void deleteCliente(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el cliente con id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente con id={0}", id);
    }
    
    
    /**
     * se crea una nueva tarjeta de credito
     * @param id
     * @param tarjetaCredito 
     */
    public void agregarTarjetaCredito(Long id, TarjetaCreditoEntity tarjetaCredito)
    {
        ClienteEntity agregar= persistence.find(id);
        List <TarjetaCreditoEntity> lista=agregar.getTarjetasCredito();
        lista.add(tarjetaCredito);
        agregar.setTarjetasCredito(lista);
        persistence.update(agregar);
    }
  
    /**
     * se borra la tarjeta de credito
     * @param cliente
     * @param tarjetaCredito
     * @throws BusinessLogicException 
     */
    public void borrarTarjetaCredito(Long cliente, Long tarjetaCredito) throws BusinessLogicException
    {
        ClienteEntity cambiar= getCliente(cliente);
        List<TarjetaCreditoEntity> tarjeta=cambiar.getTarjetasCredito();
        for(int i=0; i<tarjeta.size(); i++)
        {
            if(tarjeta.get(i).getId().equals(tarjetaCredito))
            {
                tarjeta.remove(i);
                break;
            }
        }
        cambiar.setTarjetasCredito(tarjeta);
        updateCliente(cambiar);
    }
    
}
