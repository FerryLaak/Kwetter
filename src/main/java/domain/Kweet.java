package domain;

import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Model
@Entity
public class Kweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kweetID;

    private String message;
    private Timestamp timestamp;
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Kweet_likedby")
    private List<User> likedBy = new ArrayList<User>();

    public Kweet(){

    }

    public Kweet(String message, Timestamp timestamp, User user) {
        this.message = message;
        this.timestamp = timestamp;
        this.user = user;
    }

    public int getKweetID() {
        return kweetID;
    }

    public void setKweetID(int kweetID) {
        this.kweetID = kweetID;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<User> likedBy) {
        this.likedBy = likedBy;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addLike(User u) {
        if (!likedBy.contains(u)) {
            likedBy.add(u);
        }
    }

    public void removeLike(User u) {
        if (likedBy.contains(u)) {
            likedBy.remove(u);
        }
    }
}
