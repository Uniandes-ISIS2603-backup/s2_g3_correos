/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;

import co.edu.uniandes.csw.correos.ejb.EventoLogic;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.entities.EventoEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.EventoPersistence;
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
public class EventoLogicTest {
    
      private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EventoLogic eventoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EventoEntity> data = new ArrayList<EventoEntity>();


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EventoEntity.class.getPackage())
                .addPackage(EventoLogic.class.getPackage())
                .addPackage(EventoPersistence.class.getPackage())
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
        em.createQuery("delete from EventoEntity").executeUpdate();
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            EventoEntity entity = factory.manufacturePojo(EventoEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }
    }

    /**
     * Prueba para crear un Evento
     *
     *
     */
    @Test
    public void createEventoTest() throws BusinessLogicException {
        EventoEntity newEntity = factory.manufacturePojo(EventoEntity.class);
        EventoEntity result = eventoLogic.createEvento(newEntity);
        Assert.assertNotNull(result);
        EventoEntity entity = em.find(EventoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDetalle(), entity.getDetalle());
        Assert.assertEquals(newEntity.getUbicacion(), entity.getUbicacion());
    }

    /**
     * Prueba para consultar la lista de Eventos
     *
     *
     */
    @Test
    public void getEventosTest() {
        List<EventoEntity> list = eventoLogic.getEventos();
        Assert.assertEquals(data.size(), list.size());
        for (EventoEntity entity : list) {
            boolean found = false;
            for (EventoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Evento
     *
     *
     */
    @Test
    public void getEventoTest() {
        EventoEntity entity = data.get(0);
        EventoEntity resultEntity = eventoLogic.getEvento(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getDetalle(), resultEntity.getDetalle());
        Assert.assertEquals(entity.getUbicacion(), resultEntity.getUbicacion());
    }

    /**
     * Prueba para eliminar un Evento
     *
     *
     */
    @Test
    public void deleteEventoTest() {
        EventoEntity entity = data.get(0);
        eventoLogic.deleteEvento(entity.getId());
        EventoEntity deleted = em.find(EventoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Evento
     *
     *
     */
    @Test
    public void updateEventoTest() throws BusinessLogicException {
        EventoEntity entity = data.get(0);
        EventoEntity pojoEntity = factory.manufacturePojo(EventoEntity.class);

        pojoEntity.setId(entity.getId());

        eventoLogic.updateEvento(pojoEntity);

        EventoEntity resp = em.find(EventoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getDetalle(), resp.getDetalle());
        Assert.assertEquals(pojoEntity.getUbicacion(), resp.getUbicacion());
    }
}
