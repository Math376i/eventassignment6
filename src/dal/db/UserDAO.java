package dal.db;

import be.Event;
import be.User;
import dal.Interfaces.IUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUser {

    private Connection con;

    public UserDAO(Connection con){
        this.con = con;
    }


    /**
     * gets a list of all users.
     * @return list of users.
     */
    @Override
    public List<User> getUsers() {
        List<User> allUser = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM [EventAssignment].[dbo].[User]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                int phoneNumber = rs.getInt("phoneNumber");
                int userEventID = rs.getInt("userEventID");

                int id = rs.getInt("UserID");
                allUser.add(new User(id, name, email, phoneNumber,userEventID ));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allUser;
    }

    /**
     * creates users / guest
     * @param name of the user
     * @param email of the user
     * @param phoneNumber of the user
     * @param userEventID the event that the user is going to.
     * @return the user/guest  object.
     *
     * will set null as userEventID if no event was selected by getting -1 as userEventID
     */
    @Override
    public User createUser(String name, String email, int phoneNumber, Integer userEventID) {
        int insertedId = -1;
        if (userEventID.equals(-1)){userEventID = null;}
        try {
            String sqlStatement = "INSERT INTO [User](name,email,phoneNumber, userEventID) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, phoneNumber);
            if(userEventID!= null){statement.setInt(4,userEventID);}
            else {statement.setNull(4,Types.INTEGER); userEventID = -1;}
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(insertedId,name,email,phoneNumber, userEventID);
    }

    /**
     * removes a user/guest.
     * @param user the user object
     * @return true or false. true if user was deleted.
     */
    @Override
    public boolean removeUser(User user) {
        try {
            String sqlStatement = "DELETE FROM [USER] WHERE userId=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, user.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * gets all users from a Event.
     * @param event the event searching for guest/user.
     * @return list of user object that is attending that specific event.
     */
    public List<User> getUsersFromEvent(Event event) {
        List<User> allUsersFromEvent = new ArrayList<>();
        try {
            String sqlStatement = "SELECT userID, name , email, phoneNumber, userEventID FROM [User] INNER JOIN  Event ON Event.eventID = [User].userEventID  Where userEventID = ? ";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, event.getId());

            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {

                int id = rs.getInt(1);
                String userName = rs.getString(2);

                String email = rs.getString(3);

                int phoneNumber = rs.getInt(4);

                int userEventId = rs.getInt(5);

                allUsersFromEvent.add(new User(id,userName,email,phoneNumber, userEventId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allUsersFromEvent;
    }


}
