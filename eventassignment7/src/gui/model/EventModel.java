package gui.model;

import be.Coordinator;
import be.Event;
import bll.EventManager;
import javafx.collections.ObservableList;

import java.util.List;

public class EventModel {

    private EventManager eventManager;

    public List<Event> getEvents() {
        return eventManager.getMovies();
    }

    public EventModel(){
        eventManager = new EventManager();
    }

    public Event createEvent(String name, String adr, String startTime, Coordinator creator){
        return eventManager.createEvent(name,adr,startTime,creator);
    }
    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator){
        return eventManager.getEventFromCoordinator(coordinator);
    }
    public Boolean removeEvent(Event event){
        return eventManager.removeEvent(event);
    }
}
