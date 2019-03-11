package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDAOImpl implements IUserDAO {

    @PersistenceContext(name = "bankPU")
    EntityManager em;

    public User createUser(User user) {
        if(user.getUserName() != "") {
                em.persist(user);
        }
        return user;
    }

    public User findById(long id) {
        Query query = em.createQuery(
                "SELECT u FROM User u WHERE UserID = " + id + " ORDER BY timeStamp DESC");
        return (User) query.getSingleResult();
    }

    public User findByUsername(String username) {
        Query query = em.createQuery(
                "SELECT u FROM User u WHERE Username = " + username + " ORDER BY timeStamp DESC");
        return (User) query.getSingleResult();
    }

    public List<User> findAll() {
        Query query = em.createQuery(
                "SELECT u FROM User u");
        return query.getResultList();
    }

    public void update(User user) {
        try {
            em.merge(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(User user) {
        try {
            em.remove(user);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
