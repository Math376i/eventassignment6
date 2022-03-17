package gui.model;

import be.Coordinator;
import bll.CoordinatorManager;

public class CoordinatorModel {
    CoordinatorManager coordinatorManager = new CoordinatorManager();



    public Coordinator createKoordinator(String name, String username, String password) {
        return coordinatorManager.createKoordinator(name, username, password);
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
