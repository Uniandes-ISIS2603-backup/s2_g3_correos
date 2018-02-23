
import co.edu.uniandes.csw.correos.entities.MensajeroEntity;
import co.edu.uniandes.csw.correos.persistence.MensajeroPersistence;
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
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

/**
 *
 * @author l.mejia
 */
@RunWith(Arquillian.class)
public class MensajeroPersistenceTest {
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de mensajero, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MensajeroEntity.class.getPackage())
                .addPackage(MensajeroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Inyección de la dependencia a la clase MensajeroPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private MensajeroPersistence mensajeroPersistence;
    
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
        em.createQuery("delete from MensajeroEntity").executeUpdate();
    }
    
    private List<MensajeroEntity> data = new ArrayList<MensajeroEntity>();
    
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MensajeroEntity entity = factory.manufacturePojo(MensajeroEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Mensajero.
     */
    @Test
    public void createMensajeroTest() {
        PodamFactory factory = new PodamFactoryImpl();
        MensajeroEntity newEntity = factory.manufacturePojo(MensajeroEntity.class);
        MensajeroEntity result = mensajeroPersistence.create(newEntity);

        Assert.assertNotNull(result);

        MensajeroEntity entity = em.find(MensajeroEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
        Assert.assertEquals(newEntity.getCelular(), entity.getCelular());
        Assert.assertEquals(newEntity.getCalificacionPromedio(), entity.getCalificacionPromedio(),0.0);
    }
    
    /**
     * Prueba para consultar la lista de Mensajeros.
     */
    @Test
    public void getMensajerosTest() {
        List<MensajeroEntity> list = mensajeroPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MensajeroEntity ent : list) {
            boolean found = false;
            for (MensajeroEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Mensajero
     */
    @Test
    public void getMensajeroTest() {
        MensajeroEntity entity = data.get(0);
        MensajeroEntity newEntity = mensajeroPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
        Assert.assertEquals(newEntity.getCelular(), entity.getCelular());
        Assert.assertEquals(newEntity.getCalificacionPromedio(), entity.getCalificacionPromedio(),0.0);
    }
    
    /**
     * Prueba para eliminar un Mensajero.
     */
    @Test
    public void deleteMensajeroTest() {
        MensajeroEntity entity = data.get(0);
        mensajeroPersistence.delete( entity.getId());
        MensajeroEntity deleted = em.find(MensajeroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Mensajero.
     */
    @Test
    public void updateMensajeroTest() {
        MensajeroEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MensajeroEntity newEntity = factory.manufacturePojo(MensajeroEntity.class);

        newEntity.setId(entity.getId());

        mensajeroPersistence.update(newEntity);

        MensajeroEntity resp = em.find(MensajeroEntity.class, entity.getId());

        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getCorreo(), resp.getCorreo());
        Assert.assertEquals(newEntity.getCelular(), resp.getCelular());
        Assert.assertEquals(newEntity.getCalificacionPromedio(), resp.getCalificacionPromedio(),0.0);
    }
    
}
