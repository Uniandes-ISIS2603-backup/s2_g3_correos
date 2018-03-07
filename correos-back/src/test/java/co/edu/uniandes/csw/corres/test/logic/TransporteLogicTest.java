/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;

import co.edu.uniandes.csw.correos.ejb.TransporteLogic;
import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.TransportePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author l.mejia
 */
public class TransporteLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private TransporteLogic transporteLogic;
    
    
    
       @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<TransporteEntity> data = new ArrayList<TransporteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransporteLogic.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     *
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
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from TransporteEntity").executeUpdate();
        em.createQuery("delete from BookEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            TransporteEntity entity = factory.manufacturePojo(TransporteEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un Transporte
     *
     *
     */
    @Test
    public void createTransporteTest() throws BusinessLogicException  {
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);
       
        TransporteEntity result = transporteLogic.createTransporte(newEntity);
        
        Assert.assertNotNull(result);
        TransporteEntity entity = em.find(TransporteEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        
    }

    /**
     * Prueba para consultar la lista de Transportes
     *
     *
     */
    @Test
    public void getTransportesTest() {
        List<TransporteEntity> list = transporteLogic.getTransportes();
        Assert.assertEquals(data.size(), list.size());
        for (TransporteEntity entity : list) {
            boolean found = false;
            for (TransporteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Transporte
     *
     *
     */
    @Test
    public void getTransporteTest() {
        TransporteEntity entity = data.get(0);
        TransporteEntity resultEntity = transporteLogic.getTransporte(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
       
    }

    /**
     * Prueba para eliminar un Transporte
     *
     *
     */
    @Test
    public void deleteTransporteTest() {
        TransporteEntity entity = data.get(0);
        transporteLogic.deleteTransporte(entity);
        TransporteEntity deleted = em.find(TransporteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Transporte
     *
     *
     */
    @Test
    public void updateTransporteTest() throws BusinessLogicException {
        TransporteEntity entity = data.get(0);
        TransporteEntity pojoEntity = factory.manufacturePojo(TransporteEntity.class);

        pojoEntity.setId(entity.getId());

        transporteLogic.putTransporte(pojoEntity);

        TransporteEntity resp = em.find(TransporteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        
    }
}
