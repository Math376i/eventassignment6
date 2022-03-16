package dal.db;

import be.Admin;

import java.sql.*;

public class AdminDAO {

    private Connection con;

    public AdminDAO(Connection connection) {
        con = connection;
    }

Admin admin;

    public Admin createCoordinator(String Username, String Password) {

        int insertedId = -1;
        try{
            String sqlStatement = "INSERT INTO EventAssignment(username,password) VALUES (?, ?, ?, ?, ?);";
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




    public void updateCoordiantor(Admin admin) throws Exception {

        String sql = "UPDATE eventAssignment SET username=? password=? WHERE Id=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, admin.getUsername());
        preparedStatement.setString(2, admin.getPassword());


        int affectedRows = preparedStatement.executeUpdate();
        if(affectedRows != 1) {

        }

        public boolean deleteCoordinator(Admin deleteCoordinator) {
            try{
                String sqlStatement = "DELETE FROM EventAssignment WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sqlStatement);
                statement.setObject(1,admin.());
                statement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

}
