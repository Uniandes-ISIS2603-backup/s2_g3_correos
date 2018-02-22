/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import co.edu.uniandes.csw.correos.persistence.ZonaPersistence;
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
 * @author ed.diaz11
 */
@RunWith(Arquillian.class)
public class ZonaPersitenceTest {
 /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * 
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ZonaEntity.class.getPackage())
                .addPackage(ZonaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * Inyección de la dependencia a la clase ZonaPersistance cuyos métodos
     * se van a probar.
     */
    @Inject
    private ZonaPersistence zonaPersistence;

    /**
     * Contexto de Persostencia que se va autilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
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
        em.createQuery("delete from ZonaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<ZonaEntity> data = new ArrayList<ZonaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *PODEM crea objetos con valores random. Nos permite probar con diferentes datos todo el tiempo
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ZonaEntity entity = factory.manufacturePojo(ZonaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Zona.
     *
     *
     */
    @Test
    public void createZonaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ZonaEntity newEntity = factory.manufacturePojo(ZonaEntity.class);
        ZonaEntity result = zonaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ZonaEntity entity = em.find(ZonaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getLongitud(), entity.getLongitud());
        Assert.assertEquals(newEntity.getLatitud(), entity.getLatitud());
       
    }

    /**
     * Prueba para consultar la lista de Zonas.
     *
     */
    @Test
    public void getZonasTest() {
        List<ZonaEntity> list = zonaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ZonaEntity ent : list) {
            boolean e = false;
            for (ZonaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    e = true;
                }
            }
            Assert.assertTrue(e);
        }
    }

    /**
     * Prueba para consultar una Zona.
     *
     *
     */
    @Test
    public void getZonaTest() {
        ZonaEntity entity = data.get(0);
        ZonaEntity newEntity = zonaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getLatitud(), entity.getLatitud());
        Assert.assertEquals(newEntity.getLongitud(), entity.getLongitud());
  
    }

    /**
     * Prueba para eliminar una Zona.
     *
     *
     */
    @Test
    public void deleteZonaTest() {
        ZonaEntity entity = data.get(0);
        zonaPersistence.delete(entity);
        ZonaEntity deleted = em.find(ZonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Zona.
     *
     *
     */
    @Test
    public void updateZonaTest() {
        ZonaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ZonaEntity newEntity = factory.manufacturePojo(ZonaEntity.class);

        newEntity.setId(entity.getId());

        zonaPersistence.update(newEntity);

        ZonaEntity r = em.find(ZonaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getLatitud(), r.getLatitud());
        Assert.assertEquals(newEntity.getLongitud(), r.getLongitud());
        
    }    
  
}
