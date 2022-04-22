package dal.Interfaces;

import be.Coordinator;
import be.User;

import java.util.List;

public interface IUser {
    public List<User> getUsers();
    public User createUser(String name, String email, int phoneNumber, Integer userEventID);
    public boolean removeUser(User user);
}
