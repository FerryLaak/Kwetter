package rest;

import dao.IUserDAO;
import domain.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/User")

public class UserAPI {

    @Inject
    IUserDAO userDao;

    @POST
    @Path("/Create")
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user){
        return userDao.createUser(user);
    }

    @GET
    @Path("/GetUserByID")
    @Produces(MediaType.APPLICATION_JSON)
    public User findById(long id){
        return userDao.findById(id);
    }

    @GET
    @Path("/GetUserByUserName")
    @Produces(MediaType.APPLICATION_JSON)
    public User findByUsername(String username){
        return userDao.findByUsername(username);
    }


    @GET
    @Path("/FindAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll(){
        return userDao.findAll();
    }


    @POST
    @Path("/Update")
    @Produces(MediaType.APPLICATION_JSON)
    public void update(User user){
        userDao.update(user);
    }

    @DELETE
    @Path("/Delete")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(User user){
        userDao.delete(user);
    }

}
