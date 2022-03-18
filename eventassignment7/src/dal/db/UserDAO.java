package dal.db;


import be.User;
import dal.Interfaces.IUser;

import java.sql.*;
import java.util.List;

public class UserDAO implements IUser {

    private Connection con;

    public UserDAO(Connection con){
        this.con = con;
    }


    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User createUser(String name, String email, int phoneNumber) {
        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO User(name,email,phoneNumber) VALUES (?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, phoneNumber);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User(insertedId,name,email,phoneNumber);
    }

    @Override
    public void updateUser(User user) throws Exception {

        String sql = "UPDATE [User] SET name = ?, email=?, phoneNumber=?, WHERE userID=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getPhoneNumber());
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
}
