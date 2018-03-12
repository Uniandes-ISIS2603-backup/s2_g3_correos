/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import co.edu.uniandes.csw.correos.ejb.PaqueteLogic;
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.PaquetePersistence;
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
public class PaqueteLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PaqueteLogic paqueteLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PaqueteEntity> data = new ArrayList<PaqueteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PaqueteEntity.class.getPackage())
                .addPackage(PaqueteLogic.class.getPackage())
                .addPackage(PaquetePersistence.class.getPackage())
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
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() throws BusinessLogicException {
        
        for (int i = 0; i < 3; i++) {            
            PaqueteEntity entity = factory.manufacturePojo(PaqueteEntity.class);;            
            em.persist(entity);
            data.add(entity);                       
        }
    }

    /**
     * Prueba para crear un Paquete.
     */
    @Test
    public void createPaqueteTest() throws BusinessLogicException {
        PaqueteEntity newEntity = factory.manufacturePojo(PaqueteEntity.class);
        PaqueteEntity result = paqueteLogic.createPaquete(newEntity);
        Assert.assertNotNull(result);
        PaqueteEntity entity = em.find(PaqueteEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getDimensionA(), entity.getDimensionA());
        Assert.assertEquals(newEntity.getDimensionB(), entity.getDimensionB());
        Assert.assertEquals(newEntity.getDimensionC(), entity.getDimensionC());
        Assert.assertEquals(newEntity.getPeso(), entity.getPeso());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }
    
    /**
     * Prueba para consultar la lista de Paquetes.     
     */
    @Test
    public void getPaquetesTest() throws BusinessLogicException {
        List<PaqueteEntity> list = paqueteLogic.getPaquetes();
        Assert.assertEquals(data.size(), list.size());
        for (PaqueteEntity entity : list) {
            boolean found = false;
            for (PaqueteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un Paquete.    
     */
    @Test
    public void getPaqueteTest() {
        PaqueteEntity entity = data.get(0);
        PaqueteEntity resultEntity = paqueteLogic.getPaquete(entity.getId());
        Assert.assertNotNull(resultEntity);
        
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getDimensionA(), resultEntity.getDimensionA());
        Assert.assertEquals(entity.getDimensionB(), resultEntity.getDimensionB());
        Assert.assertEquals(entity.getDimensionC(), resultEntity.getDimensionC());
        Assert.assertEquals(entity.getTipo(), resultEntity.getTipo());
        Assert.assertEquals(entity.getPeso(), resultEntity.getPeso());
    }
     /**
     * Prueba para eliminar un Paquete.     
     */
    @Test
    public void deletePaqueteTest() throws BusinessLogicException {
        PaqueteEntity entity = data.get(0);
        paqueteLogic.deletePaquete(entity.getId());
        PaqueteEntity deleted = em.find(PaqueteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
     /**
     * Prueba para actualizar un Paquete.   
     */
    @Test
    public void updatePaqueteTest() throws BusinessLogicException {
        PaqueteEntity entity = data.get(0);
        PaqueteEntity pojoEntity = factory.manufacturePojo(PaqueteEntity.class);

        pojoEntity.setId(entity.getId());

        paqueteLogic.updatePaquete(pojoEntity);

        PaqueteEntity resp = em.find(PaqueteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getDimensionA(), resp.getDimensionA());
        Assert.assertEquals(pojoEntity.getDimensionB(), resp.getDimensionB());
        Assert.assertEquals(pojoEntity.getDimensionC(), resp.getDimensionC());
        Assert.assertEquals(pojoEntity.getPeso(), resp.getPeso());
        Assert.assertEquals(pojoEntity.getTipo(), resp.getTipo());
    }   
}


