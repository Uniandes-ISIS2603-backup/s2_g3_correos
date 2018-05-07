/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;

import co.edu.uniandes.csw.correos.ejb.MensajeroLogic;
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
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
 * @author l.mejia
 */
@RunWith(Arquillian.class)
public class MensajeroLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private MensajeroLogic mensajeroLogic;
    
    
    
       @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<MensajeroEntity> data = new ArrayList<MensajeroEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MensajeroEntity.class.getPackage())
                .addPackage(MensajeroLogic.class.getPackage())
                .addPackage(MensajeroPersistence.class.getPackage())
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
        em.createQuery("delete from MensajeroEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            MensajeroEntity entity = factory.manufacturePojo(MensajeroEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un Mensajero
     *
     *
     */
    @Test
    public void createMensajeroTest() throws BusinessLogicException  {
        MensajeroEntity newEntity = factory.manufacturePojo(MensajeroEntity.class);
       
        MensajeroEntity result = mensajeroLogic.createMensajero(newEntity);
        
        Assert.assertNotNull(result);
        MensajeroEntity entity = em.find(MensajeroEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        
    }

    /**
     * Prueba para consultar la lista de Mensajeros
     *
     *
     */
    @Test
    public void getMensajerosTest() {
        List<MensajeroEntity> list = mensajeroLogic.getMensajeros();
        Assert.assertEquals(data.size(), list.size());
        for (MensajeroEntity entity : list) {
            boolean found = false;
            for (MensajeroEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Mensajero
     *
     *
     */
    @Test
    public void getMensajeroTest() {
        MensajeroEntity entity = data.get(0);
        MensajeroEntity resultEntity = mensajeroLogic.getMensajero(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
       
    }

    /**
     * Prueba para eliminar un Mensajero
     *
     *
     */
    @Test
    public void deleteMensajeroTest() {
        MensajeroEntity entity = data.get(0);
        mensajeroLogic.deleteMensajero(entity);
        MensajeroEntity deleted = em.find(MensajeroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Mensajero
     *
     *
     */
    @Test
    public void updateMensajeroTest() throws BusinessLogicException {
        MensajeroEntity entity = data.get(0);
        MensajeroEntity pojoEntity = factory.manufacturePojo(MensajeroEntity.class);

        pojoEntity.setId(entity.getId());

        mensajeroLogic.putMensajero(pojoEntity);

        MensajeroEntity resp = em.find(MensajeroEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        
    }
}
