package bll;

import be.Coordinator;
import be.Event;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DatabaseConnector;
import dal.db.EventDao;
import dal.db.UserDAO;

import java.io.IOException;

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

    public Event createEvent(String name, String adr, String startTime, Coordinator creator){
       return eventDao.createEvent(name,adr,startTime,creator);
    }

}
