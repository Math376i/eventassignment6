package bll;

import be.Coordinator;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.CoordinatorDAO;
import dal.db.DatabaseConnector;

import java.io.IOException;
import java.util.List;

public class CoordinatorManager {
private CoordinatorDAO coordinatorDAO;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            coordinatorDAO = new CoordinatorDAO(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }



    public boolean deleteCoordinator(Coordinator coordinator){
        return coordinatorDAO.deleteCoordinator(coordinator);
    }


    public List<Coordinator> getAllCoordinators(){
        return coordinatorDAO.getCoordinators();
    }


    public Coordinator createCoordinator(String name, String username, String password) {
        return coordinatorDAO.createCoordinator(name, username, password);
    }

    public boolean getSpecificCoordinator(String username, String password){
        return coordinatorDAO.getSpecificCoordinator(username, password);
    }

    public Coordinator getCurrentCoordinator() {
        return coordinatorDAO.getCurrentCoordinator();
    }
}
