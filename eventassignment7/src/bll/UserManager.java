package bll;

import be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DatabaseConnector;
import dal.db.UserDAO;

import java.io.IOException;

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

    public User createUser(String name, String email, int phoneNumber){
        return userDao.createUser(name, email, phoneNumber);
    }
    public boolean deleteUser(User user){
        return userDao.removeUser(user);
    }

}
