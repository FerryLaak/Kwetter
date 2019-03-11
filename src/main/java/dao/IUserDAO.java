package dao;

import domain.User;

import javax.persistence.PersistenceException;
import java.util.List;

public interface IUserDAO {

    User createUser(User user);

    User findById(long id);

    User findByUsername(String username);

    List<User> findAll();

    void update(User user);

    void delete(User user);
}
