/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.correos.entities.PaqueteEntity;
import co.edu.uniandes.csw.correos.persistence.PaquetePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
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
public class PaquetePersistenceTest {

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Paquete, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PaqueteEntity.class.getPackage())
                .addPackage(PaquetePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase PaquetePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private PaquetePersistence paquetePersistence;

    /**
     * Contexto de Persistencia que se va autilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void setUp() {
        try {
            utx.begin();
            em.joinTransaction();
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
        em.createQuery("delete from PaqueteEntity").executeUpdate();
    }

    /**
     *
     */
    private List<PaqueteEntity> data = new ArrayList<PaqueteEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     * 
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PaqueteEntity entity = factory.manufacturePojo(PaqueteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Paquete.
     *
     *
     */
    @Test
    public void createPaqueteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PaqueteEntity newEntity = factory.manufacturePojo(PaqueteEntity.class);
        PaqueteEntity result = paquetePersistence.create(newEntity);

        Assert.assertNotNull(result);

        PaqueteEntity entity = em.find(PaqueteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDimensionA(), entity.getDimensionA());
        Assert.assertEquals(newEntity.getDimensionB(), entity.getDimensionB());
        Assert.assertEquals(newEntity.getDimensionC(), entity.getDimensionC());
        Assert.assertEquals(newEntity.getPeso(), entity.getPeso());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }

    /**
     * Prueba para consultar la lista de Paquetes.
     *
     *
     */
    @Test
    public void getPaquetesTest() {
        List<PaqueteEntity> list = paquetePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PaqueteEntity ent : list) {
            boolean found = false;
            for (PaqueteEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Paquete.
     *
     *
     */
    @Test
    public void getPaqueteTest() {
        PaqueteEntity entity = data.get(0);
        PaqueteEntity newEntity = paquetePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getDimensionA(), newEntity.getDimensionA());
        Assert.assertEquals(entity.getDimensionB(), newEntity.getDimensionB());
        Assert.assertEquals(entity.getDimensionC(), newEntity.getDimensionC());
        Assert.assertEquals(entity.getPeso(), newEntity.getPeso());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getTipo(), newEntity.getTipo());
    }

    /**
     * Prueba para eliminar un Paquete.
     *
     *
     */
    @Test
    public void deletePaqueteTest() {
        PaqueteEntity entity = data.get(0);
        paquetePersistence.delete(entity.getId());
        PaqueteEntity deleted = em.find(PaqueteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Paquete.
     *
     *
     */
    @Test
    public void updatePaqueteTest() {
        PaqueteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PaqueteEntity newEntity = factory.manufacturePojo(PaqueteEntity.class);

        newEntity.setId(entity.getId());

        paquetePersistence.update(newEntity);

        PaqueteEntity resp = em.find(PaqueteEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getDimensionA(), resp.getDimensionA());
        Assert.assertEquals(newEntity.getDimensionB(), resp.getDimensionB());
        Assert.assertEquals(newEntity.getDimensionC(), resp.getDimensionC());
        Assert.assertEquals(newEntity.getPeso(), resp.getPeso());
        Assert.assertEquals(newEntity.getTipo(), resp.getTipo());
        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
}


