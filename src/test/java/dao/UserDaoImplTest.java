/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Role;
import domain.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Ferry
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankPU");
    EntityManager em;

    public UserDaoImplTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() throws SQLException {

    }

    @Test
    public void persistCommitTest() {
        //Hier wordt de instatie aangemaakt die naar de database gaat
        User user = new User("user1","password1","bio1", "C://test", new Role("User"));
        em.getTransaction().begin();
        em.persist(user);

        //Hier wordt het commit gedeelte uitgevoerd en wordt er een lijn in de account tabel gezet
        em.getTransaction().commit();
        System.out.println("UserID: " + user.getUserID());

        assertTrue(user.getUserID() > 0L);
    }


}
