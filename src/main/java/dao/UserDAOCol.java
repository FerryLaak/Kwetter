package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDAOCol implements IUserDAO {

    private List<User> users = null;

    public UserDAOCol() {
        users = new ArrayList();
    }

    public User createUser(User user) {
        if (!users.contains(user)) {
            this.users.add(user);
        }
        return user;
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getUserID() == id) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUserName() == username) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    public List<User> findAll() {
        if (users != null) {
            return users;
        } else {
            return null;
        }
    }

    public void update(User user) {
        for(User user2 : users) {
            if(user2.getUserID() == user.getUserID()) {
                user2 = user;
            }
        }
    }

    public void delete(User user) {
        for(User user2 : users) {
            if(user2 == user)
            users.remove(user);
            }
    }

}
