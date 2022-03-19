package dal.Interfaces;

import be.Coordinator;
import be.User;

import java.util.List;

public interface IUser {
    public List<User> getUsers();
    public User createUser(String name, String email, int phoneNumber, int userEventID);
    public void updateUser(User user) throws Exception;
    public boolean removeUser(User user);
}
