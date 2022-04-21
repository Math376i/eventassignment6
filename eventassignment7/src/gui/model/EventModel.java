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

    public Event createEvent(String name, String adr, String startTime, Coordinator creator, String month, String day, String year){
        return eventManager.createEvent(name,adr,startTime,creator, month, day, year);
    }
    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator){
        return eventManager.getEventFromCoordinator(coordinator);
    }
    public Boolean removeEvent(Event event){
        return eventManager.removeEvent(event);
    }
}
