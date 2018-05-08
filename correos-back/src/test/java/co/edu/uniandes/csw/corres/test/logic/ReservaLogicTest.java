/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.corres.test.logic;

import co.edu.uniandes.csw.correos.ejb.ReservaLogic;
import co.edu.uniandes.csw.correos.entities.ReservaEntity;
import co.edu.uniandes.csw.correos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.correos.persistence.ReservaPersistence;
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
 * @author l.mejia
 */
@RunWith(Arquillian.class)
public class ReservaLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private ReservaLogic reservaLogic;
    
    
    
       @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaLogic.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
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
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un Reserva
     *
     *
     */
    @Test
    public void createReservaTest() throws BusinessLogicException  {
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
       
        ReservaEntity result = reservaLogic.createReserva(newEntity);
        
        Assert.assertNotNull(result);
        ReservaEntity entity = em.find(ReservaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        
    }

    /**
     * Prueba para consultar la lista de Reservas
     *
     *
     */
    @Test
    public void getReservasTest() {
        List<ReservaEntity> list = reservaLogic.getReservas();
        Assert.assertEquals(data.size(), list.size());
        for (ReservaEntity entity : list) {
            boolean found = false;
            for (ReservaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Reserva
     *
     *
     */
    @Test
    public void getReservaTest() {
        ReservaEntity entity = data.get(0);
        ReservaEntity resultEntity = reservaLogic.getReserva(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
       
    }

    /**
     * Prueba para eliminar un Reserva
     *
     *
     */
    @Test
    public void deleteReservaTest() {
        ReservaEntity entity = data.get(0);
        reservaLogic.deleteReserva(entity);
        ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Reserva
     *
     *
     */
    @Test
    public void updateReservaTest() throws BusinessLogicException {
        ReservaEntity entity = data.get(0);
        ReservaEntity pojoEntity = factory.manufacturePojo(ReservaEntity.class);

        pojoEntity.setId(entity.getId());

        reservaLogic.putReserva(pojoEntity);

        ReservaEntity resp = em.find(ReservaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        
    }
}
