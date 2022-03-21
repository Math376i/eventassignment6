package gui.model;

import be.Coordinator;
import be.Event;
import bll.EventManager;
import javafx.collections.ObservableList;

import java.util.List;

public class EventModel {

    private EventManager eventManager;

    public EventModel(){
        eventManager = new EventManager();
    }

    public Event createEvent(String name, String adr, String startTime, Coordinator creator){
        return eventManager.createEvent(name,adr,startTime,creator);
    }
    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator){
        return eventManager.getEventFromCoordinator(coordinator);
    }
}
