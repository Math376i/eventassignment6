package bll;

import be.Admin;
import be.Coordinator;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.AdminDAO;
import dal.db.DatabaseConnector;

import java.io.IOException;

public class AdminManager {
private AdminDAO adminDAO;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            adminDAO = new AdminDAO(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteCoordinator(Coordinator coordinatorDelete){
        return AdminDAO.deleteCoordinator(coordinatorDelete);
    }

    public Coordinator createCoordinator(Coordinator coordinator) {

        return adminDAO.createCoordinator(coordinator.getId(), coordinator.getName(), coordinator.getUsername(), coordinator.getPassword());
    }
}
