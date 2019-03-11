package domain;

import domain.Kweet;
import domain.Role;
import domain.User;
import org.junit.*;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

public class KweetTest {

    private User user1 = null;
    private User user2 = null;
    private User user3 = null;
    private User user4 = null;
    private User user5 = null;
    private User user6 = null;
    private User user7 = null;
    private User user8 = null;
    private User user9 = null;
    private User user10 = null;

    private Kweet kweet1 = null;
    private Kweet kweet2 = null;
    private Kweet kweet3 = null;
    private Kweet kweet4 = null;
    private Kweet kweet5 = null;
    private Kweet kweet6 = null;
    private Kweet kweet7 = null;
    private Kweet kweet8 = null;
    private Kweet kweet9 = null;
    private Kweet kweet10 = null;

    public KweetTest(){

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp(){
        user1 = new User("gebruiker1", "password1",  "bio1", "C://test", new Role("User"));
        user2 = new User("gebruiker2", "password2",  "bio2", "C://test", new Role("User"));
        user3 = new User("gebruiker3", "password3",  "bio3", "C://test", new Role("User"));
        user4 = new User("gebruiker4", "password4",  "bio4", "C://test", new Role("User"));
        user5 = new User("gebruiker5", "password5",  "bio5", "C://test", new Role("User"));
        user6 = new User("gebruiker6", "password6",  "bio6", "C://test", new Role("User"));
        user7 = new User("gebruiker7", "password7",  "bio7", "C://test", new Role("User"));
        user8 = new User("gebruiker8", "password8",  "bio8", "C://test", new Role("User"));
        user9 = new User("gebruiker9", "password9",  "bio9", "C://test", new Role("User"));
        user10 = new User("gebruiker10", "password10",  "bio10", "C://test", new Role("User"));

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        kweet1 = new Kweet("message1", timestamp, user1);
        kweet2 = new Kweet("message2", timestamp, user2);
        kweet3 = new Kweet("message3", timestamp, user3);
        kweet4 = new Kweet("message4", timestamp, user4);
        kweet5 = new Kweet("message5", timestamp, user5);
        kweet6 = new Kweet("message6", timestamp, user6);
        kweet7 = new Kweet("message7", timestamp, user7);
        kweet8 = new Kweet("message8", timestamp, user8);
        kweet9 = new Kweet("message9", timestamp, user9);
        kweet10 = new Kweet("message10", timestamp,user10);

        user1.followUser(user2);
        user1.followUser(user3);
        user2.followUser(user3);
        user2.followUser(user4);
        user3.followUser(user4);
        user4.followUser(user1);
    }


    @Test
    public void testAddLike() {
        System.out.println("Adding a like");
        kweet1.addLike(user2);
        assertEquals("Likes should not be null", user2, kweet1.getLikedBy().get(0));
    }

    @Test
    public void testRemoveLike(){
        System.out.println("Removing a like");
        kweet1.addLike(user2);
        assertEquals("Kweets should be null", true, kweet1.getLikedBy().contains(user2));
        kweet1.removeLike(user2);
        assertEquals("Kweets should be null", false, kweet1.getLikedBy().contains(user2));
    }
}