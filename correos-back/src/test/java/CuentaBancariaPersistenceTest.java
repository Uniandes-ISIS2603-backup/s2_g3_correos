/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.persistence.CuentaBancariaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author a.silvag
 */
public class CuentaBancariaPersistenceTest {
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de CuentaBancaria, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaBancariaEntity.class.getPackage())
                .addPackage(CuentaBancariaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase CuentaBancariaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CuentaBancariaPersistence cuentaBancariaPersistence;

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
        em.createQuery("delete from CuentaBancariaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<CuentaBancariaEntity> data = new ArrayList<CuentaBancariaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     * 
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CuentaBancariaEntity entity = factory.manufacturePojo(CuentaBancariaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un CuentaBancaria.
     *
     *
     */
    @Test
    public void createCuentaBancariaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaBancariaEntity newEntity = factory.manufacturePojo(CuentaBancariaEntity.class);
        CuentaBancariaEntity result = cuentaBancariaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CuentaBancariaEntity entity = em.find(CuentaBancariaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getBanco(), entity.getBanco());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNumero(), entity.getNumero());
        Assert.assertEquals(newEntity.getTipoTarjeta(), entity.getTipoTarjeta());
    }

    /**
     * Prueba para consultar la lista de CuentaBancarias.
     *
     *
     */
    @Test
    public void getCuentaBancariasTest() {
        List<CuentaBancariaEntity> list = cuentaBancariaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaBancariaEntity ent : list) {
            boolean found = false;
            for (CuentaBancariaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un CuentaBancaria.
     *
     *
     */
    @Test
    public void getCuentaBancariaTest() {
        CuentaBancariaEntity entity = data.get(0);
        CuentaBancariaEntity newEntity = cuentaBancariaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getBanco(), newEntity.getBanco());
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getNumero(), newEntity.getNumero());
        Assert.assertEquals(entity.getTipoTarjeta(), newEntity.getTipoTarjeta());
    }

    /**
     * Prueba para eliminar un CuentaBancaria.
     *
     *
     */
    @Test
    public void deleteCuentaBancariaTest() {
        CuentaBancariaEntity entity = data.get(0);
        cuentaBancariaPersistence.delete(entity);
        CuentaBancariaEntity deleted = em.find(CuentaBancariaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un CuentaBancaria.
     *
     *
     */
    @Test
    public void updateCuentaBancariaTest() {
        CuentaBancariaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CuentaBancariaEntity newEntity = factory.manufacturePojo(CuentaBancariaEntity.class);

        newEntity.setId(entity.getId());

        cuentaBancariaPersistence.update(newEntity);

        CuentaBancariaEntity resp = em.find(CuentaBancariaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getBanco(), resp.getBanco());
        Assert.assertEquals(newEntity.getNumero(), resp.getNumero());
        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getTipoTarjeta(), resp.getTipoTarjeta());
    }
}
