/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */



/**

 *

 * @author t.vargas10

 */





import co.edu.uniandes.csw.correos.entities.DetallePaqueteEntity;
import co.edu.uniandes.csw.correos.entities.PaqueteEntity;

import co.edu.uniandes.csw.correos.persistence.DetallePaquetePersistance;

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



@RunWith(Arquillian.class)

public class DetallePaquetePersistanceTest {

    

    /**

     *

     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish

     * embebido. El jar contiene las clases de detallePaquete, el descriptor de la

     * base de datos y el archivo benas.xml para resolver la inyección de

     * dependencias.

     */

    @Deployment

    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)

                .addPackage(DetallePaqueteEntity.class.getPackage())

                .addPackage(DetallePaquetePersistance.class.getPackage())

                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")

                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

    

     /**

     * Inyección de la dependencia a la clase detallePaquetePersistence cuyos métodos

     * se van a probar.

     */

    @Inject

    private DetallePaquetePersistance detallePaquetePersistence;



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

        em.createQuery("delete from DetallePaqueteEntity").executeUpdate();

    }



    /**

     *

     */

    private List<DetallePaqueteEntity> data = new ArrayList<DetallePaqueteEntity>();
    private List<PaqueteEntity> dataPaquete = new ArrayList<PaqueteEntity>();



    /**

     * Inserta los datos iniciales para el correcto funcionamiento de las

     * pruebas.

     *

     *PODEM crea objetos con valores random. Nos permite probar con diferentes datos todo el tiempo

     */

    private void insertData() {

        PodamFactory factory = new PodamFactoryImpl();

        for (int i = 0; i < 3; i++) {

            DetallePaqueteEntity entity = factory.manufacturePojo(DetallePaqueteEntity.class);



            em.persist(entity);

            data.add(entity);

        }

    }



    /**

     * Prueba para crear un DetallePaquete.

     *

     *

     */

    @Test

    public void createDetalleTest() {

        PodamFactory factory = new PodamFactoryImpl();

        DetallePaqueteEntity newEntity = factory.manufacturePojo(DetallePaqueteEntity.class);

        DetallePaqueteEntity result = detallePaquetePersistence.create(newEntity);



        Assert.assertNotNull(result);



        DetallePaqueteEntity entity = em.find(DetallePaqueteEntity.class, result.getId());



        Assert.assertEquals(newEntity.getName(), entity.getName());

        Assert.assertEquals(newEntity.getId(), entity.getId());

        Assert.assertEquals(newEntity.getMensaje(), entity.getMensaje());

        

    }



    /**

     * Prueba para consultar la lista de DetallePaquetes.

     *

     * TENER UN ASSERT POR CADA UNO DE LOS ATRIBUTOS 

     */

    @Test

    public void getDetallesTest() {

        List<DetallePaqueteEntity> list = detallePaquetePersistence.findAll();

        Assert.assertEquals(data.size(), list.size());

        for (DetallePaqueteEntity ent : list) {

            boolean found = false;

            for (DetallePaqueteEntity entity : data) {

                if (ent.getId().equals(entity.getId())) {

                    found = true;

                }

            }

            Assert.assertTrue(found);

        }

    }



    /**

     * Prueba para consultar un Detalle.

     *

     *

     */

    @Test
    public void getDetallePaqueteTest() {
        DetallePaqueteEntity entity = data.get(0);
        DetallePaqueteEntity newEntity = detallePaquetePersistence.find(dataPaquete.get(0).getId(), entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getMensaje(), newEntity.getMensaje());
    }



    /**

     * Prueba para eliminar un Detalle.

     *

     *

     */

    @Test

    public void deleteDetalleTest() {

        DetallePaqueteEntity entity = data.get(0);

        detallePaquetePersistence.delete(entity.getId());

        DetallePaqueteEntity deleted = em.find(DetallePaqueteEntity.class, entity.getId());

        Assert.assertNull(deleted);

    }



    /**

     * Prueba para actualizar un Detalle.

     *

     *

     */

    @Test

    public void updateDetallePaqueteTest() {

        DetallePaqueteEntity entity = data.get(0);

        PodamFactory factory = new PodamFactoryImpl();

        DetallePaqueteEntity newEntity = factory.manufacturePojo(DetallePaqueteEntity.class);



        newEntity.setId(entity.getId());



        detallePaquetePersistence.update(newEntity);



        DetallePaqueteEntity resp = em.find(DetallePaqueteEntity.class, entity.getId());

        

        Assert.assertEquals(newEntity.getName(), resp.getName());

        Assert.assertEquals(newEntity.getMensaje(), resp.getMensaje());

        Assert.assertEquals(newEntity.getId(), resp.getId());

        

    }

}