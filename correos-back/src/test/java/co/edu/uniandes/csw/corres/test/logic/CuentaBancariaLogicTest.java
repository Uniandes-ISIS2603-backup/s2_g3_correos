/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;

import co.edu.uniandes.csw.correos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.correos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.CuentaBancariaPersistence;
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
 * @cuentaBancaria a.silvag
 */
@RunWith(Arquillian.class)
public class CuentaBancariaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private CuentaBancariaLogic cuentaBancariaLogic;
    
    
    
       @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<CuentaBancariaEntity> data = new ArrayList<CuentaBancariaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaBancariaEntity.class.getPackage())
                .addPackage(CuentaBancariaLogic.class.getPackage())
                .addPackage(CuentaBancariaPersistence.class.getPackage())
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
        em.createQuery("delete from CuentaBancariaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            CuentaBancariaEntity entity = factory.manufacturePojo(CuentaBancariaEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un CuentaBancaria
     *
     *
     */
    @Test
    public void createCuentaBancariaTest() throws BusinessLogicException  {
        CuentaBancariaEntity newEntity = factory.manufacturePojo(CuentaBancariaEntity.class);
       
        CuentaBancariaEntity result = cuentaBancariaLogic.createCuentaBancaria(newEntity);
        
        Assert.assertNotNull(result);
        CuentaBancariaEntity entity = em.find(CuentaBancariaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCliente(), entity.getCliente());
    }

    /**
     * Prueba para consultar la lista de CuentaBancarias
     *
     *
     */
    @Test
    public void getCuentaBancariasTest() {
        List<CuentaBancariaEntity> list = cuentaBancariaLogic.getCuentasBancarias();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaBancariaEntity entity : list) {
            boolean found = false;
            for (CuentaBancariaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un CuentaBancaria
     *
     *
     */
    @Test
    public void getCuentaBancariaTest() {
        CuentaBancariaEntity entity = data.get(0);
        CuentaBancariaEntity resultEntity = cuentaBancariaLogic.getCuentaBancaria(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCliente(), resultEntity.getCliente());
    }

    /**
     * Prueba para eliminar un CuentaBancaria
     *
     *
     */
    @Test
    public void deleteCuentaBancariaTest() {
        CuentaBancariaEntity entity = data.get(0);
        cuentaBancariaLogic.deleteCuentaBancaria(entity.getId());
        CuentaBancariaEntity deleted = em.find(CuentaBancariaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un CuentaBancaria
     *
     *
     */
    @Test
    public void updateCuentaBancariaTest() throws BusinessLogicException {
        CuentaBancariaEntity entity = data.get(0);
        CuentaBancariaEntity pojoEntity = factory.manufacturePojo(CuentaBancariaEntity.class);

        pojoEntity.setId(entity.getId());

        cuentaBancariaLogic.updateCuentaBancaria(pojoEntity);

        CuentaBancariaEntity resp = em.find(CuentaBancariaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCliente(), resp.getCliente());
    }
}
