package dal.db;

import be.Coordinator;
import be.Event;
import be.User;
import dal.Interfaces.IEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao implements IEvent {

    private Connection con;

    public EventDao(Connection con){
        this.con = con;
    }


    /**
     * gets all events
     * @return a list of all Events
     */
    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public Event createEvent(String name, String adr, String startTime, Coordinator creator, String month, String day, String year) {
        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO Event(eventName ,address, startingTime, ownerId, month, day, year) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, adr);
            statement.setString(3, startTime );
            statement.setInt(4, creator.getId());
            statement.setString(5, month);
            statement.setString(6, day );
            statement.setString(7, year );
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Event(insertedId, name, adr, startTime, creator.getId(), month, day, year);

    }

    /**
     * remove a specific event
     * @param event that should be deleted.
     * @return true or false depending of if event was deleted.
     */
    @Override
    public boolean removeEvent(Event event) {
        try {
            String sqlStatement = "DELETE FROM Event WHERE EventID=?";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, event.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * gets all events from on Coordinator
     * @param coordinator the coordinator object which is the owner of the events
     * @return a list of all events.
     */
    @Override
    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator) {
        ObservableList<Event> allEventsFromCoordinator = FXCollections.observableArrayList();
        try {
            String sqlStatement = "SELECT eventID, eventName, address, startingTime, ownerid, [month], [day], [year] FROM Event INNER JOIN  Coordinator ON Coordinator.Coordinatorid = Event.ownerId  Where ownerid = ? ";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, coordinator.getId());

            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {

                int id = rs.getInt(1);
                String eventName = rs.getString(2);

                String address = rs.getString("address");

                String startTime = rs.getString("startingTime");

                int ownerId = rs.getInt("ownerID");

                String month = rs.getString("month");
                String day = rs.getString("day");
                String year = rs.getString("year");

                allEventsFromCoordinator.add(new Event(id, eventName, address, startTime, ownerId, month, day, year));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allEventsFromCoordinator;
    }

    
}
