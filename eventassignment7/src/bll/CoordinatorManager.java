package bll;

import be.Coordinator;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.CoordinatorDAO;
import dal.db.DatabaseConnector;

import java.io.IOException;

public class CoordinatorManager {
private CoordinatorDAO adminDAO;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            adminDAO = new CoordinatorDAO(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }


    /*
    public boolean deleteCoordinator(Coordinator coordinatorDelete){
        return AdminDAO.deleteCoordinator(coordinatorDelete);
    }
     */

    public Coordinator createKoordinator(String name, String username, String password) {
        return adminDAO.createCoordinator(name, username, password);
    }
}
