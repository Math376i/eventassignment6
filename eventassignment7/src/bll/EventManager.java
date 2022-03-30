package bll;

import be.Coordinator;
import be.Event;
import be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DatabaseConnector;
import dal.db.EventDao;
import dal.db.UserDAO;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class EventManager {
    private EventDao eventDao;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            eventDao = new EventDao(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }
    public List<Event> getMovies() {
        return EventDao.getEventFromCoordinator();
    }

    public Event createEvent(String name, String adr, String startTime, Coordinator creator){
       return eventDao.createEvent(name,adr,startTime,creator);
    }

    public void updateEvent(Event event){return EventDao.updateEvent;}

    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator){
        return eventDao.getEventFromCoordinator(coordinator);
    }
    public Boolean removeEvent(Event event){
        return eventDao.removeEvent(event);
    }


}
