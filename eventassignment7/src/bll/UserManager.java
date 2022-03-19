package bll;

import be.Event;
import be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DatabaseConnector;
import dal.db.UserDAO;

import java.io.IOException;
import java.util.List;

public class UserManager {
    private UserDAO userDao;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            userDao = new UserDAO(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }

    public User createUser(String name, String email, int phoneNumber, int userEventID){
        return userDao.createUser(name, email, phoneNumber,userEventID);
    }
    public boolean deleteUser(User user){
        return userDao.removeUser(user);
    }

    public List<User> getUsersFromEvent(Event event){
        return userDao.getUsersFromEvent(event);
    }
}
