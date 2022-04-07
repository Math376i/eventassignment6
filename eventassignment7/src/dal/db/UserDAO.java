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

    @Override
    public void updateUser(User user) throws Exception {


        String sql = "UPDATE [User] SET name = ?, email=?, phoneNumber=?, userEventID=? WHERE userID=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getPhoneNumber());
        if (user.getEventID() != -1){
            preparedStatement.setInt(4, user.getEventID());
        }else{
            preparedStatement.setNull(4, Types.INTEGER);
        }
        preparedStatement.executeUpdate();
    }

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
