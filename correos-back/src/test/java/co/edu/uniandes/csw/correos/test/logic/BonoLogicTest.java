/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.correos.test.logic;

import co.edu.uniandes.csw.correos.ejb.BonoLogic;
import co.edu.uniandes.csw.correos.entities.BonoEntity;
import co.edu.uniandes.csw.correos.entities.ClienteEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.BonoPersistance;
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
public class BonoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private BonoLogic bonoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<BonoEntity> data = new ArrayList<BonoEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(BonoEntity.class.getPackage())
                .addPackage(BonoLogic.class.getPackage())
                .addPackage(BonoPersistance.class.getPackage())
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
        em.createQuery("delete from BonoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() throws BusinessLogicException {

        for (int i = 0; i < 3; i++) {
            BonoEntity entity = factory.manufacturePojo(BonoEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }
    }

     /**
     * Prueba para crear un Review
     *
     * 
     */
    @Test
    public void createBonoTest() throws BusinessLogicException {
        BonoEntity newEntity = factory.manufacturePojo(BonoEntity.class);
        BonoEntity result = bonoLogic.createBono(newEntity);
        Assert.assertNotNull(result);
        BonoEntity entity = em.find(BonoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCondicion(), entity.getCondicion());
        Assert.assertEquals(newEntity.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(newEntity.getDescuento(), entity.getDescuento());
        Assert.assertEquals(newEntity.getFechaDeVencimiento(), entity.getFechaDeVencimiento());
    }
    
    /**
     * Prueba para consultar la lista de bonos
     *
     * 
     */
    
    @Test
    public void getBonosTest() throws BusinessLogicException {
        List<BonoEntity> list = bonoLogic.getBonos();        
        Assert.assertEquals(data.size(), list.size());
        for (BonoEntity entity : list) {
            boolean found = false;
            for (BonoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar un Bono
     *
     *
     */
    @Test
    public void getBonoTest() {
        BonoEntity entity = data.get(0);
        BonoEntity resultEntity = bonoLogic.getBono(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCondicion(), resultEntity.getCondicion());
        Assert.assertEquals(entity.getDescripcion(), resultEntity.getDescripcion());
        Assert.assertEquals(entity.getDescuento(), resultEntity.getDescuento());
        Assert.assertEquals(entity.getFechaDeVencimiento(), resultEntity.getFechaDeVencimiento());
    }
    /**
     * Prueba para eliminar un bono
     *
     * 
     */
 
    @Test
    public void deleteBonoTest() {
        BonoEntity entity = data.get(0);
        bonoLogic.deleteBono(entity.getId());
        BonoEntity deleted = em.find(BonoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
     /**
     * Prueba para actualizar un Bono
     *
     * 
     */
 @Test
    public void updateBonoTest() throws BusinessLogicException {
        BonoEntity entity = data.get(0);
        BonoEntity pojoEntity = factory.manufacturePojo(BonoEntity.class);

        pojoEntity.setId(entity.getId());

        bonoLogic.updateBono(pojoEntity);

        BonoEntity resp = em.find(BonoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCondicion(), resp.getCondicion());
        Assert.assertEquals(pojoEntity.getDescripcion(), resp.getDescripcion());
        Assert.assertEquals(pojoEntity.getFechaDeVencimiento(), resp.getFechaDeVencimiento());
        Assert.assertEquals(pojoEntity.getDescuento(), resp.getDescuento());
    }
    
    }


