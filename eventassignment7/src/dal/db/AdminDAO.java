package dal.db;

import be.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {
Admin admin;

    public static Admin createKoordinator(String Username, String Password) {

        int insertedId = -1;
        try{
            String sqlStatement = "INSERT INTO eventassignment(username,password) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,Username);
            statement.setFloat(2, Float.parseFloat(Password));
            statement.execute();
            ResultSet rs =statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Admin(Username,Password);
    }




    public void updateKoordiantor(Admin admin) throws Exception {

        String sql = "UPDATE eventassignment SET username=? password=? WHERE Id=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, admin.getUsername());
        preparedStatement.setFloat(2, admin.getPassword());


        int affectedRows = preparedStatement.executeUpdate();
        if(affectedRows != 1) {

        }

        public static boolean deletekoordinator(Admin admin) {
            try{
                String sqlStatement = "DELETE FROM eventassignment WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sqlStatement);
                statement.setInt(1,koordinatorDelete.getUsername());
                statement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }



}
