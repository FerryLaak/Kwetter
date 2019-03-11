package dao;

import domain.Kweet;
import domain.User;

import java.util.List;

public interface IKweetDAO {

    boolean likeKweet(Kweet kweet, User user);

    List<User> getLikes(Kweet kweet);

    List<Kweet> getKweetsOfFollowingUsers(User following);

    List<Kweet> getAllKweets();

    Kweet findKweet(Integer id);

    List<Kweet> findKweetByContent(String content);

    void createKweet(Kweet kweet);

    void updateKweet(Kweet kweet);

    void removeKweet(Kweet kweet);
}
