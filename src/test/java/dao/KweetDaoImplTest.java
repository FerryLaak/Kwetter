/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Kweet;
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
public class KweetDaoImplTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bankPU");
    EntityManager em;
    User user;
    public KweetDaoImplTest() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        user = new User("gebruiker1", "password1",  "bio1", "C://test", new Role("User"));
    }

    @After
    public void tearDown() throws SQLException {

    }

    @Test
    public void persistCommitTest() {
        //Hier wordt de instatie aangemaakt die naar de database gaat
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Kweet kweet = new Kweet("TestKweet", timestamp, user);
        em.getTransaction().begin();
        em.persist(kweet);

        //Hier wordt het commit gedeelte uitgevoerd en wordt er een lijn in de account tabel gezet
        em.getTransaction().commit();
        System.out.println("KweetID: " + kweet.getKweetID());

        assertTrue(kweet.getKweetID() > 0L);
    }
}
