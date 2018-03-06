/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;


import co.edu.uniandes.csw.correos.ejb.ZonaLogic;
import co.edu.uniandes.csw.correos.entities.ZonaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.ZonaPersistence;
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
 * @author ed.diaz11
 */
@RunWith(Arquillian.class)
public class ZonaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ZonaLogic zonaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ZonaEntity> data = new ArrayList<ZonaEntity>();


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ZonaEntity.class.getPackage())
                .addPackage(ZonaLogic.class.getPackage())
                .addPackage(ZonaPersistence.class.getPackage())
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
        em.createQuery("delete from ZonaEntity").executeUpdate();
       
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ZonaEntity entity = factory.manufacturePojo(ZonaEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }
    }

    /**
     * Prueba para crear una Zona
     *
     *
     */
    @Test
    public void createZonaTest() throws BusinessLogicException {
        ZonaEntity newEntity = factory.manufacturePojo(ZonaEntity.class);
        ZonaEntity result = zonaLogic.createZona(newEntity);
        Assert.assertNotNull(result);
        ZonaEntity entity = em.find(ZonaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getLatitud(), entity.getLatitud());
        Assert.assertEquals(newEntity.getLongitud(), entity.getLongitud());
       
    }

    /**
     * Prueba para consultar la lista de Zonas
     *
     *
     */
    @Test
    public void getZonasTest() {
        List<ZonaEntity> list = zonaLogic.getZonas();
        Assert.assertEquals(data.size(), list.size());
        for (ZonaEntity entity : list) {
            boolean found = false;
            for (ZonaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una ZOna
     *
     *
     */
    @Test
    public void getZonaTest() {
        ZonaEntity entity = data.get(0);
        ZonaEntity resultEntity = zonaLogic.getZona(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getLatitud(), resultEntity.getLatitud());
        Assert.assertEquals(entity.getLongitud(), resultEntity.getLongitud());
        
    }

    /**
     * Prueba para eliminar una Zona
     *
     *
     */
    @Test
    public void deleteZonaTest() throws BusinessLogicException {
        ZonaEntity entity = data.get(0);
        zonaLogic.deleteZona(entity);
        ZonaEntity deleted = em.find(ZonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Zona
     *
     *
     */
    @Test
    public void updateZonaTest() throws BusinessLogicException {
        ZonaEntity entity = data.get(0);
        ZonaEntity pojoEntity = factory.manufacturePojo(ZonaEntity.class);

        pojoEntity.setId(entity.getId());

        zonaLogic.updateZona(pojoEntity);

        ZonaEntity resp = em.find(ZonaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getLatitud(), resp.getLatitud());
        Assert.assertEquals(pojoEntity.getLongitud(), resp.getLongitud());
      
    }
    
}
