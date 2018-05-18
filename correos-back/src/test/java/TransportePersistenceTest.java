
import co.edu.uniandes.csw.correos.entities.TransporteEntity;
import co.edu.uniandes.csw.correos.persistence.TransportePersistence;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author l.mejia
 */
@RunWith(Arquillian.class)
public class TransportePersistenceTest {
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de transporte, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase TransportePersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private TransportePersistence transportePersistence;
    
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
        em.createQuery("delete from TransporteEntity").executeUpdate();
    }
    
    /**
     * lista de transportes 
     */
    private List<TransporteEntity> data = new ArrayList<TransporteEntity>();
    
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TransporteEntity entity = factory.manufacturePojo(TransporteEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Transporte.
     */
    @Test
    public void createTransporteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);
        TransporteEntity result = transportePersistence.create(newEntity);

        Assert.assertNotNull(result);

        TransporteEntity entity = em.find(TransporteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(newEntity.isActivo(), entity.isActivo());

    }
    
    /**
     * Prueba para consultar la lista de Transportes.
     */
    @Test
    public void getTransportesTest() {
        List<TransporteEntity> list = transportePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TransporteEntity ent : list) {
            boolean found = false;
            for (TransporteEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Transporte
     */
    @Test
    public void getTransporteTest() {
        TransporteEntity entity = data.get(0);
        TransporteEntity newEntity = transportePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
        Assert.assertEquals(newEntity.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(newEntity.isActivo(), entity.isActivo());
    }
    
    /**
     * Prueba para eliminar un Transporte.
     */
    @Test
    public void deleteTransporteTest() {
        TransporteEntity entity = data.get(0);
        transportePersistence.delete( entity.getId());
        TransporteEntity deleted = em.find(TransporteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Transporte.
     */
    @Test
    public void updateTransporteTest() {
        TransporteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);

        newEntity.setId(entity.getId());

        transportePersistence.update(newEntity);

        TransporteEntity resp = em.find(TransporteEntity.class, entity.getId());

        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getTipo(), resp.getTipo());
        Assert.assertEquals(newEntity.getCapacidad(), resp.getCapacidad());
        Assert.assertEquals(newEntity.isActivo(), resp.isActivo());
    }
    
}
