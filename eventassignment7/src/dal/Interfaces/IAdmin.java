package dal.Interfaces;

import be.Coordinator;

import java.util.List;

public interface IAdmin {
    public List<Coordinator> getCoordinators();
    public Coordinator createCoordinator(int id, String name, String username, String password);
    public void updateCoordinator(Coordinator coordinator) throws Exception;
    public boolean deleteCoordinator(Coordinator deleteCoordinator);
}
