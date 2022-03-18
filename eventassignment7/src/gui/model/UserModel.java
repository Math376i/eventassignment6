package gui.model;

import be.User;
import bll.UserManager;

public class UserModel {

    private UserManager userManager;

    public UserModel(){
        userManager = new UserManager();
    }

    public User createUser(String name, String email, int phoneNumber){
        return userManager.createUser(name, email, phoneNumber);
    }
    public boolean deleteUser(User user){
        return userManager.deleteUser(user);
    }
}
