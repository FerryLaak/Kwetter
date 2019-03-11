package dao;

import domain.Kweet;
import domain.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class KweetDAOCol implements IKweetDAO {

    private  List<Kweet> kweets = null;
    private Kweet kweet = null;

    public KweetDAOCol() {
        this.kweets = new ArrayList();
        kweet = new Kweet();
    }

    public boolean likeKweet(Kweet kweet, User user) {
        if (kweet != null && user != null) {
            kweet.addLike(user);
            return true;
        } else {
            return false;
        }
    }

    public List<User> getLikes(Kweet kweet) {
        if (kweet != null) {
            return kweet.getLikedBy();
        } else {
            return null;
        }
    }

    public List<Kweet> getKweetsOfFollowingUsers(User following) {
        if (following != null) {
            return following.getKweets();
        } else {
            return null;
        }
    }

    public List<Kweet> getAllKweets() {
        if (kweets != null) {
            return kweets;
        } else {
            return null;
        }
    }

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


    public void createKweet(Kweet kweet) {
        if (!kweets.contains(kweet)) {
            this.kweets.add(kweet);

        }
    }

    public void updateKweet(Kweet kweet) {
        for(Kweet kweet2 : kweets) {
            if(kweet2.getKweetID() == kweet.getKweetID()) {
                kweet2 = kweet;
            }
        }
    }

    public void removeKweet(Kweet tweet) {
        for(Kweet kweet : kweets) {
            if(kweet.getKweetID() == tweet.getKweetID()) {
                kweets.remove(tweet);
            }
        }
    }
}
