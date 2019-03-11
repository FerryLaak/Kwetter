package dao;

import domain.Kweet;
import domain.Role;
import domain.User;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KweetDaoColTest {

    private KweetDAOCol kweetDAO = null;
    private UserDAOCol userDAO = null;

    private List<Kweet> kweets = null;
    private List<String> tags = null;
    private List<User> users = null;
    private Kweet kweet1 = null;
    private User user1 = null;
    private User user2 = null;
    private User user3 = null;

    public KweetDaoColTest(){

    }

    @Before
    public void setUp() {
        kweetDAO = new KweetDAOCol();
        userDAO = new UserDAOCol();

        users = new ArrayList();
        tags = new ArrayList();
        tags.add("#wijzijnfontys");
        tags.add("#test");
        tags.add("#jea");
        kweets = new ArrayList();

        user1 = userDAO.createUser(new User("gebruike1", "password1",  "bio1", "C://test", new Role("User")));

        user2 = userDAO.createUser(new User("gebruiker2", "password2",  "bio2", "C://test", new Role("User")));
        users.add(user2);
        user3 = userDAO.createUser(new User("gebruiker3", "password3",  "bio3", "C://test", new Role("User")));
        users.add(user3);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        kweet1 = new Kweet("Hello message", timestamp, user1);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }


    @Test
    public void TestgetLikes() {
        kweetDAO.likeKweet(kweet1, user2);
        assertEquals("Likes should not be null", user2, kweet1.getLikedBy().get(0));

    }


    @Test
    public void TestCreateUpdateDeleteKweet() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Kweet k = new Kweet("Hoi", timestamp, user3);
        kweetDAO.createKweet(k);
        assertEquals("Tweet is not created", user3, k.getUser());
        //kweetDAO.updateKweet(k);
       // kweetDAO.removeKweet(k);
    }

/*

    @Test
    public Kweet findKweet(Integer id) {
        for (Kweet kweet : kweets) {
            if (kweet.getKweetID() == id) {
                return kweet;
            } else {
                return null;
            }
        }
        return null;
    }

    @Test
    public List<Kweet> findKweetByContent(String content) {
        List<Kweet> kweetscontent = new ArrayList<Kweet>();
        for (Kweet kweet : kweets) {
            if (kweet.getMessage() == content) {
                kweetscontent.add(kweet);
            } else {

            }
        }
        return kweetscontent;
    }

    @Test
    public List<Kweet> findTagByContent(String content) {
        List<Kweet> kweetstag= new ArrayList<Kweet>();
        for (Kweet kweet : kweets) {
            if (kweet.getMessage() == content) {
                kweetstag.add(kweet);
            } else {

            }
        }
        return kweetstag;
    }

  */
}
