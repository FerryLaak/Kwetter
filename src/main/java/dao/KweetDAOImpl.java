package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class KweetDAOImpl implements IKweetDAO {

    @PersistenceContext(name = "bankPU")
    EntityManager em;

    public KweetDAOImpl(EntityManager entityManager){
        this.em = entityManager;
    }


    public boolean likeKweet(Kweet kweet, User user) {
        return false;
    }

    public List<User> getLikes(Kweet kweet) {
        Query query = em.createQuery(
                "SELECT u FROM User u");
        return query.getResultList();
    }

    public List<Kweet> getKweetsOfFollowingUsers(User following) {
        Query query = em.createQuery(
                "SELECT t\n"
                        + "FROM User u, Tweet t\n"
                        + "INNER JOIN t.tweetedBy tb "
                        + "INNER JOIN u.following uf \n"
                        + "INNER JOIN User u2 \n"
                        + "WHERE tb.id = uf.id\n"
                        + "AND u2.id = uf.id \n"
                        + "AND u.name = :username");
        return query.getResultList();
    }

    public List<Kweet> getAllKweets() {
        Query query = em.createQuery(
                "SELECT k FROM Kweet k ORDER BY timeStamp DESC");
        return query.getResultList();
    }

    public Kweet findKweet(Integer id) {
        Query query = em.createQuery(
                "SELECT k FROM Kweet k WHERE KweetID = " + id + " ORDER BY timeStamp DESC");
        return (Kweet) query.getSingleResult();
    }

    public List<Kweet> findKweetByContent(String content) {
        Query query = em.createQuery(
                "SELECT k FROM Kweet k WHERE Message = " + content + " ORDER BY timeStamp DESC");
        return query.getResultList();
    }

    public void createKweet(Kweet kweet) {
        if(kweet.getMessage() != "") {
            if(kweet.getMessage().length() > 0 && kweet.getMessage().length() < 141) {
                em.persist(kweet);
            }
        }
    }

    public void updateKweet(Kweet kweet) {
        try {
            em.merge(kweet);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeKweet(Kweet kweet) {
        try {
            em.remove(kweet);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
