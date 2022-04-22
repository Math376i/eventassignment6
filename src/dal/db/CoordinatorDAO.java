package dal.db;

import be.Admin;
import be.Coordinator;
import dal.Interfaces.ICoordinator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoordinatorDAO implements ICoordinator {

    private Connection con;
    public Coordinator currentCoordinator;

    public CoordinatorDAO(Connection connection) {
        con = connection;

    }


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

                int id = rs.getInt("Coordinatorid");
                allCoordinators.add(new Coordinator(id, name, username, password));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCoordinators;
    }

    @Override
    public Coordinator createCoordinator(String name, String username, String password) {

        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO Coordinator(name,username,password) VALUES (?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, username);
            statement.setString(3, password);
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
    public boolean deleteCoordinator(Coordinator deleteCoordinator) {
        try {
            String sqlStatement = "DELETE FROM Coordinator WHERE CoordinatorId=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, deleteCoordinator.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Coordinator getSpecificCoordinator(String username, String password) {

        List<Coordinator> coordinators = new ArrayList<>();
        coordinators = getCoordinators();
        for (Coordinator coordinator : coordinators) {
            if (coordinator.getUsername().equals(username) && coordinator.getPassword().equals(password)) {
                return coordinator;
            }
        }
        return null;
    }

}
