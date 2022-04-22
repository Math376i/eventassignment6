package dal.Interfaces;

import be.Coordinator;

import java.util.List;

public interface ICoordinator {
    public List<Coordinator> getCoordinators();
    public Coordinator createCoordinator(String name, String username, String password);
    public boolean deleteCoordinator(Coordinator deleteCoordinator);
}
