package service;

import dao.IUserDAO;
import domain.User;

import javax.inject.Inject;
import java.util.List;

public class UserService {

    @Inject
    IUserDAO userDAO;

    public User createUser(User user){
        try {
            return userDAO.createUser(user);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public User findById(long id){
        try {
            return userDAO.findById(id);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public User findByUsername(String username){
        try {
            return userDAO.findByUsername(username);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public List<User> findAll(){
        try {
            return userDAO.findAll();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public void update(User user){
        try {
            userDAO.update(user);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    };

    public void delete(User user){
        try {
            userDAO.delete(user);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    };
}
