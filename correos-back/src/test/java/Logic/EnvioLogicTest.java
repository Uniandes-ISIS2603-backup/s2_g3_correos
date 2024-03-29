package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.correos.ejb.EnvioLogic;
import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EnvioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author df.rengifo
 */

@RunWith(Arquillian.class)
public class EnvioLogicTest {
    
    /**
     * factory
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * envioLogic 
     */
    @Inject
    private EnvioLogic envioLogic;   

    /**
     * entity manager 
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * user transaction 
     */
    @Inject
    private UserTransaction utx;

    /**
     * lista de envios 
     */
    private List<EnvioEntity> data = new ArrayList<EnvioEntity>();
    /**
     * lista de paquetes 
     */
    private List<PaqueteEntity> dataPaquetes = new ArrayList<PaqueteEntity>();
    /**
     * lista de clientes 
     */
    private List<ClienteEntity> dataClientes = new ArrayList<ClienteEntity>();
    
    /**
     * crea el deployement 
     * @return 
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EnvioEntity.class.getPackage())
                .addPackage(EnvioLogic.class.getPackage())
                .addPackage(EnvioPersistence.class.getPackage())                
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
     /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from PaqueteEntity").executeUpdate();
        em.createQuery("delete from EnvioEntity").executeUpdate();       
        em.createQuery("delete from ClienteEntity").executeUpdate(); 
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() throws BusinessLogicException {        
            
        for (int i = 0; i < 3; i++) {
            ClienteEntity cliente = factory.manufacturePojo(ClienteEntity.class);
            em.persist(cliente);
            dataClientes.add(cliente);
        }        
        for (int i = 0; i < 3; i++) {
            
            EnvioEntity entity = factory.manufacturePojo(EnvioEntity.class);
             
            for (int j = 0; j < 3; j++) {
                PaqueteEntity paquete = factory.manufacturePojo(PaqueteEntity.class);
                em.persist(paquete);
                dataPaquetes.add(paquete);
            }  
           
            entity.setCliente(dataClientes.get(i));
            entity.setPaquetes(dataPaquetes);

            em.persist(entity);
            data.add(entity);
            
            List<ClienteEntity> dataClientes = new ArrayList<ClienteEntity>();
        }
    }

    /**
     * Prueba para crear un Envio.
     */
    @Test
    public void createEnvioTest() throws BusinessLogicException {        
        
        EnvioEntity newEntity = factory.manufacturePojo(EnvioEntity.class);        
        newEntity.setCliente(dataClientes.get(0));                
        newEntity.setPaquetes(dataPaquetes);
        
        EnvioEntity result = envioLogic.createEnvio(newEntity);
        
        Assert.assertNotNull(result);
        EnvioEntity entity = em.find(EnvioEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getHoraInicio(), entity.getHoraInicio());
        Assert.assertEquals(newEntity.getHoraFinal(), entity.getHoraFinal());
        Assert.assertEquals(newEntity.getEstado(), entity.getEstado());
        Assert.assertEquals(newEntity.getDireccionRecogida(), entity.getDireccionRecogida());
        Assert.assertEquals(newEntity.getDireccionEntrega(), entity.getDireccionEntrega());
    }
    
    /**
     * Prueba para consultar la lista de Envios.     
     */
    @Test
    public void getEnviosTest() throws BusinessLogicException {
        List<EnvioEntity> list = envioLogic.getEnvios();
        Assert.assertEquals(data.size(), list.size());
        for (EnvioEntity entity : list) {
            boolean found = false;
            for (EnvioEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un Envio.    
     */
    @Test
    public void getEnvioTest() {
        EnvioEntity entity = data.get(0);
        EnvioEntity resultEntity = envioLogic.getEnvio(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getHoraFinal(), resultEntity.getHoraFinal());
        Assert.assertEquals(entity.getHoraInicio(), resultEntity.getHoraInicio());
        Assert.assertEquals(entity.getEstado(), resultEntity.getEstado());
        Assert.assertEquals(entity.getDireccionRecogida(), resultEntity.getDireccionRecogida());
        Assert.assertEquals(entity.getDireccionEntrega(), resultEntity.getDireccionEntrega());
    }
     /**
     * Prueba para eliminar un Envio.     
     */
    @Test
    public void deleteEnvioTest() throws BusinessLogicException {
        EnvioEntity entity = data.get(0);
        envioLogic.deleteEnvio(entity.getId());
        EnvioEntity deleted = em.find(EnvioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
     /**
     * Prueba para actualizar un Envio.   
     */
    @Test
    public void updateEnvioTest() throws BusinessLogicException {
        EnvioEntity entity = data.get(0);
        EnvioEntity pojoEntity = factory.manufacturePojo(EnvioEntity.class);
        pojoEntity.setId(entity.getId());
        pojoEntity.setCliente(entity.getCliente());
        pojoEntity.setPaquetes(entity.getPaquetes());

        envioLogic.updateEnvio(pojoEntity);

        EnvioEntity resp = em.find(EnvioEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getHoraFinal(), resp.getHoraFinal());
        Assert.assertEquals(pojoEntity.getHoraInicio(), resp.getHoraInicio());
        Assert.assertEquals(pojoEntity.getEstado(), resp.getEstado());
        Assert.assertEquals(pojoEntity.getDireccionRecogida(), resp.getDireccionRecogida());
        Assert.assertEquals(pojoEntity.getDireccionEntrega(), resp.getDireccionEntrega());
    }   
}





