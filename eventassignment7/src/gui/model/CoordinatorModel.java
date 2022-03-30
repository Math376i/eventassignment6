package gui.model;

import be.Coordinator;
import be.Event;
import bll.CoordinatorManager;

import java.util.List;

public class CoordinatorModel {
    CoordinatorManager coordinatorManager = new CoordinatorManager();


    public Coordinator createCoordinator(String name, String username, String password) {
        return coordinatorManager.createCoordinator(name, username, password);
    }

    public List<Coordinator> getAllCoordinators(){
        return coordinatorManager.getAllCoordinators();
    }

    public boolean removeCoordinator(Coordinator coordinator){
        return coordinatorManager.deleteCoordinator(coordinator);
    }

    public Coordinator getSpecificCoordinator(String username, String password) {
        return coordinatorManager.getSpecificCoordinator(username,password);
    }


    public Coordinator getCurrentCoordinator() {
        return coordinatorManager.getCurrentCoordinator();
    }
/*
    public void updateKoordinator(Admin admin) throws Exception {
        AdminManager.updateKoordinator(admin);
    }

    public boolean deletekoordinator(Admin koordinatorDelete) {
        return AdminManager.deleteKoordinator(koordinatorDelete);
    }

     */

}
