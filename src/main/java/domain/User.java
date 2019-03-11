package domain;


import javax.enterprise.inject.Model;
import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Model
@Entity
@NamedQueries({
        @NamedQuery(name = "User.getAll", query = "select a from User as a")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;

    private String userName;
    private String password;
    private String role;
    private String bio;
    private String imagePath;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_follow")
    private List<User> following = new ArrayList<User>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "User_follow")
    private List<User> followers = new ArrayList<User>();

    private List<Kweet> kweets = new ArrayList<Kweet>();

    public User(){

    }

    public User(String userName, String password, String bio, String imagePath, Role role) {
        this.userName = userName;
        this.password = password;
        this.bio = bio;
        this.imagePath = imagePath;
        this.role = role.toString();
    }

    //All Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Kweet> getKweets() {
        return kweets;
    }

    public void setKweets(List<Kweet> kweets) {
        this.kweets = kweets;
    }

    public void followUser(User user){
        if(!followers.contains(user)){
            following.add(user);
        }
    }

    public void removeUser(User user) {
        following.remove(user);
    }

    public void addKweet(Kweet kweet) {
        kweets.add(kweet);
    }

    public void removeKweet(Kweet kweet) {
        kweets.remove(kweet);
    }

}
