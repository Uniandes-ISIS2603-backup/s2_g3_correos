/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.test.logic;

import co.edu.uniandes.csw.correos.ejb.DetallePaqueteLogic;
import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.DetallePaquetePersistance;
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
 * @author t.vargas10
 */

@RunWith(Arquillian.class)
public class DetallePaqueteLogicTest {
    
     private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private DetallePaqueteLogic detalleLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<DetallePaqueteEntity> data = new ArrayList<DetallePaqueteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DetallePaqueteEntity.class.getPackage())
                .addPackage(DetallePaqueteLogic.class.getPackage())
                .addPackage(DetallePaquetePersistance.class.getPackage())
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
        em.createQuery("delete from DetallePaqueteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            DetallePaqueteEntity entity = factory.manufacturePojo(DetallePaqueteEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un detalle
     *
     *
     */
    @Test
    public void createDetallePaqueteTest() throws BusinessLogicException {
        DetallePaqueteEntity newEntity = factory.manufacturePojo(DetallePaqueteEntity.class);
        DetallePaqueteEntity result = detalleLogic.createDetallePaquete(newEntity);
        Assert.assertNotNull(result);
        DetallePaqueteEntity entity = em.find(DetallePaqueteEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getMensaje(), entity.getMensaje());
    }

    /**
     * Prueba para consultar un detalle
     *
     *
     */
    @Test
    public void getDetallePaqueteTest() {
        DetallePaqueteEntity entity = data.get(0);
        DetallePaqueteEntity resultEntity = detalleLogic.getDetallePaquete(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getMensaje(), resultEntity.getMensaje());
    }

    /**
     * Prueba para eliminar un detalle
     *
     *
     */
    @Test
    public void deleteDetallePaqueteTest() {
        DetallePaqueteEntity entity = data.get(0);
        detalleLogic.deleteDetallePaquete(entity.getId());
        DetallePaqueteEntity deleted = em.find(DetallePaqueteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un detalle
     *
     * 
     */
 @Test
    public void updateDetallePaqueteTest() throws BusinessLogicException {
        DetallePaqueteEntity entity = data.get(0);
        DetallePaqueteEntity pojoEntity = factory.manufacturePojo(DetallePaqueteEntity.class);

        pojoEntity.setId(entity.getId());

        detalleLogic.updateDetallePaquete(pojoEntity);

        DetallePaqueteEntity resp = em.find(DetallePaqueteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getMensaje(), resp.getMensaje());
    }
}
