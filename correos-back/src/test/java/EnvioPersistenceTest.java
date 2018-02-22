/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import co.edu.uniandes.csw.correos.entities.EnvioEntity;
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
/**
 *
 * @author df.rengifo
 */
@RunWith(Arquillian.class)
public class EnvioPersistenceTest {   

    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Envio, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EnvioEntity.class.getPackage())
                .addPackage(EnvioPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase EnvioPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private EnvioPersistence envioPersistence;

    /**
     * Contexto de Persostencia que se va autilizar para acceder a la Base de
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
        em.createQuery("delete from EnvioEntity").executeUpdate();
    }

    /**
     *
     */
    private List<EnvioEntity> data = new ArrayList<EnvioEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     * 
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EnvioEntity entity = factory.manufacturePojo(EnvioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Envio.
     *
     *
     */
    @Test
    public void createEnvioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EnvioEntity newEntity = factory.manufacturePojo(EnvioEntity.class);
        EnvioEntity result = envioPersistence.create(newEntity);

        Assert.assertNotNull(result);

        EnvioEntity entity = em.find(EnvioEntity.class, result.getId());

        Assert.assertEquals(newEntity.getDireccionEntrega(), entity.getDireccionEntrega());
        Assert.assertEquals(newEntity.getDireccionEntrega(), entity.getDireccionEntrega());
        Assert.assertEquals(newEntity.getHoraFinal(), entity.getHoraFinal());
        Assert.assertEquals(newEntity.getHoraInicio(), entity.getHoraInicio());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getEstado(), entity.getEstado());        
    }

    /**
     * Prueba para consultar la lista de Envios.
     *
     *
     */
    @Test
    public void getEnviosTest() {
        List<EnvioEntity> list = envioPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EnvioEntity ent : list) {
            boolean found = false;
            for (EnvioEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Envio.
     *
     *
     */
    @Test
    public void getEnvioTest() {
        EnvioEntity entity = data.get(0);
        EnvioEntity newEntity = envioPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDireccionEntrega(), newEntity.getDireccionEntrega());
        Assert.assertEquals(entity.getDireccionEntrega(), newEntity.getDireccionEntrega());
        Assert.assertEquals(entity.getHoraFinal(), newEntity.getHoraFinal());
        Assert.assertEquals(entity.getHoraInicio(), newEntity.getHoraInicio());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getEstado(), newEntity.getEstado()); 
    }

    /**
     * Prueba para eliminar un Envio.
     *
     *
     */
    @Test
    public void deleteEnvioTest() {
        EnvioEntity entity = data.get(0);
        envioPersistence.delete(entity);
        EnvioEntity deleted = em.find(EnvioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Envio.
     *
     *
     */
    @Test
    public void updateEnvioTest() {
        EnvioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EnvioEntity newEntity = factory.manufacturePojo(EnvioEntity.class);

        newEntity.setId(entity.getId());

        envioPersistence.update(newEntity);

        EnvioEntity resp = em.find(EnvioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDireccionEntrega(), resp.getDireccionEntrega());
        Assert.assertEquals(newEntity.getDireccionEntrega(), resp.getDireccionEntrega());
        Assert.assertEquals(newEntity.getHoraFinal(), resp.getHoraFinal());
        Assert.assertEquals(newEntity.getHoraInicio(), resp.getHoraInicio());
        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getEstado(), resp.getEstado()); 
    }   
}
