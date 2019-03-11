package rest;

import dao.IKweetDAO;
import dao.IUserDAO;
import domain.Kweet;
import domain.User;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class TweetAPI {

    @Inject
    IKweetDAO kweetDAO;

    public boolean likeKweet(Kweet kweet, User user){
       return kweetDAO.likeKweet(kweet, user);
    };

    List<User> getLikes(Kweet kweet) {
        return null;
    }

    List<Kweet> getKweetsOfFollowingUsers(User following) {
        return null;
    }

    List<Kweet> getAllKweets() {
        return null;
    }

    Kweet findKweet(Integer id) {
        return null;
    }

    List<Kweet> findKweetByContent(String content) {
        return null;
    }

    void createKweet(Kweet kweet) {

    }

    void updateKweet(Kweet kweet) {

    }

    void removeKweet(Kweet kweet) {

    }
}
