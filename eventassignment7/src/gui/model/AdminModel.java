package gui.model;

import be.Admin;
import bll.AdminManager;

import java.util.List;

public class AdminModel {
    private final Object AdminManager;
    AdminManager adminManager;


    public AdminModel(){
        AdminManager = new AdminManager();
    }

   

    /*
    public Admin createKoordinator(Admin admin) {
        return AdminManager.createKoordinator(admin);
    }

    public void updateKoordinator(Admin admin) throws Exception {
        AdminManager.updateKoordinator(admin);
    }

    public boolean deletekoordinator(Admin koordinatorDelete) {
        return AdminManager.deleteKoordinator(koordinatorDelete);
    }

     */

}
