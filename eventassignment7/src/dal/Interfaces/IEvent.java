package dal.Interfaces;

import be.Coordinator;
import be.Event;
import be.User;

import java.util.List;

public interface IEvent {
    public List<Event> getEvents();
    public Event createEvent(String name, String adr, String startTime, Coordinator creator);
    public void updateEvent(User user) throws Exception;
    public boolean removeEvent(User user);
    public List<Event> getEventFromCoordinator(Coordinator coordinator);
}
