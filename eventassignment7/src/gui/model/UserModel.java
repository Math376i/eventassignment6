package gui.model;

import be.Event;
import be.User;
import bll.UserManager;

import java.util.List;

public class UserModel {

    private UserManager userManager;

    public UserModel(){
        userManager = new UserManager();
    }


    public List<User> getAllUsers(){
        return userManager.getAllUsers();
    }

    public User createUser(String name, String email, Integer phoneNumber, Integer userEventID){
        return userManager.createUser(name, email, phoneNumber, userEventID);
    }
    public boolean deleteUser(User user){
        return userManager.deleteUser(user);
    }

    public List<User> getUsersFromEvent(Event event){
        return userManager.getUsersFromEvent(event);
    }

}
