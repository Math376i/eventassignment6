package bll;

import be.Admin;
import dal.db.AdminDAO;

public class AdminManager {


    public boolean deletekoordinator(Admin koordinatorDelete){
        return AdminDAO.deletekoordinator(koordinatorDelete);
    }

    public Admin createKoordinator(Admin admin) {
        System.out.println(Admin.getUsername());
        return AdminDAO.createKoordinator(admin.getUsername().getPassword());
    }
}
