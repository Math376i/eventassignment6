package bll;

import be.Admin;
import dal.db.AdminDAO;

public class AdminManager {


    public boolean deleteCoordinator(Admin koordinatorDelete){
        return AdminDAO.deleteCoordinator(koordinatorDelete);
    }

    public Admin createKoordinator(Admin admin) {
        System.out.println(Admin.getUsername());
        return AdminDAO.createCoordinator(admin.getUsername().getPassword());
    }
}
