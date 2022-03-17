package dal.db;

import be.Admin;
import be.Coordinator;
import dal.Interfaces.IAdmin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements IAdmin {

    private Connection con;

    public AdminDAO(Connection connection) {
        con = connection;
    }

    Admin admin;

    public List<Coordinator> getCoordinators() {
        List<Coordinator> allCoordinators = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM [EventAssignment].[dbo].[Coordinator]";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String name = rs.getString("name");

                String username = rs.getString("username");

                String password = rs.getString("password");

                int id = rs.getInt("id");
                allCoordinators.add(new Coordinator(id, name, username, password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCoordinators;
    }

    @Override
    public Coordinator createCoordinator(int id, String name, String username, String password) {

        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO EventAssignment(username,password) VALUES (?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Coordinator(insertedId, name, username, password);

    }

    @Override
    public void updateCoordinator(Coordinator coordinator) throws Exception {
        String sql = "UPDATE eventAssignment SET username=? password=? WHERE Id=?;";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, admin.getUsername());
        preparedStatement.setString(2, admin.getPassword());

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows != 1) {

        }

    }

    @Override
    public boolean deleteCoordinator(Coordinator deleteCoordinator) {
        try {
            String sqlStatement = "DELETE FROM Coordinator WHERE Id=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, deleteCoordinator.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
