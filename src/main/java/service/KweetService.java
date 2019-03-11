package service;

import dao.IKweetDAO;
import domain.Kweet;
import domain.User;
import jdk.jfr.internal.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;
import java.util.logging.Level;

@Stateless
public class KweetService {


    @Inject
    IKweetDAO kweetDAO;

    public boolean likeKweet(Kweet kweet, User user){
        try {
            return kweetDAO.likeKweet(kweet, user);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return false;
        }
    };

    public List<User> getLikes(Kweet kweet){
        try {
            return kweetDAO.getLikes(kweet);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public List<Kweet> getKweetsOfFollowingUsers(User following){
        try {
            return kweetDAO.getKweetsOfFollowingUsers(following);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public List<Kweet> getAllKweets(){
        try {
            return kweetDAO.getAllKweets();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public Kweet findKweet(Integer id){
        try {
            return kweetDAO.findKweet(id);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public List<Kweet> findKweetByContent(String content){
        try{
        return kweetDAO.findKweetByContent(content);}
        catch (Exception ex){
            System.out.println(ex.toString());
            return null;
        }
    };

    public void createKweet(Kweet kweet){
        try {
            kweetDAO.createKweet(kweet);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    };

    public void updateKweet(Kweet kweet){
        try {
            kweetDAO.updateKweet(kweet);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    };

    public void removeKweet(Kweet kweet){
        try {
            kweetDAO.removeKweet(kweet);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    };
}
