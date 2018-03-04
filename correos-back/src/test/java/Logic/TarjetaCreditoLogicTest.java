package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.correos.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.correos.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.TarjetaCreditoPersistence;
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
 * @author da.leon
 */

@RunWith(Arquillian.class)
public class TarjetaCreditoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private TarjetaCreditoLogic tarjetaCreditoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoLogic.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();       
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() throws BusinessLogicException {

        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity entity = factory.manufacturePojo(TarjetaCreditoEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }
    }

    /**
     * Prueba para crear una tarjeta de credito.
     */
    @Test
    public void createTarjetaCreditoTest() throws BusinessLogicException {
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaCreditoLogic.createTarjetaCredito(newEntity);
        Assert.assertNotNull(result);
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getFechaDeVencimiento(), entity.getFechaDeVencimiento());
        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
        Assert.assertEquals(newEntity.getSecurityCode(), entity.getSecurityCode());
      
      
    }
    
    /**
     * Prueba para consultar la lista de tarjetas.     
     */
    @Test
    public void getTarjetasCreditoTest() throws BusinessLogicException {
        List<TarjetaCreditoEntity> list = tarjetaCreditoLogic.getTarjetasCredito();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity entity : list) {
            boolean found = false;
            for (TarjetaCreditoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar una tarjeta.    
     */
    @Test
    public void getTarjetaCreditoTest() {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity resultEntity = tarjetaCreditoLogic.getTarjetaCredito(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getFechaDeVencimiento(), resultEntity.getFechaDeVencimiento());
        Assert.assertEquals(entity.getNumero(), resultEntity.getNumero());
        Assert.assertEquals(entity.getSecurityCode(), resultEntity.getSecurityCode());
  
    }
     /**
     * Prueba para eliminar una Tarjeta.     
     */
    @Test
    public void deleteTarjetaCreditoTest() throws BusinessLogicException {
        TarjetaCreditoEntity entity = data.get(0);
        tarjetaCreditoLogic.deleteTarjetaCredito(entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
     /**
     * Prueba para actualizar una Tarjeta.   
     */
    @Test
    public void updateTarjetaCreditoTest() throws BusinessLogicException {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity pojoEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        pojoEntity.setId(entity.getId());

        tarjetaCreditoLogic.updateTarjetaCredito(pojoEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getFechaDeVencimiento(), resp.getFechaDeVencimiento());
        Assert.assertEquals(pojoEntity.getNumero(), resp.getNumero());
        Assert.assertEquals(pojoEntity.getSecurityCode(), resp.getSecurityCode());
   
    }   
}


