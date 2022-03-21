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



    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public Event createEvent(String name, String adr, String startTime, Coordinator creator) {
        int insertedId = -1;
        try {
            String sqlStatement = "INSERT INTO Event(eventName ,address, startingTime, ownerId) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            statement.setString(2, adr);
            statement.setString(3, startTime );
            statement.setInt(4, creator.getId());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Event(insertedId, name, adr, startTime, creator.getId());

    }

    @Override
    public void updateEvent(User user) throws Exception {

    }

    @Override
    public boolean removeEvent(User user) {
        return false;
    }

    @Override
    public ObservableList<Event> getEventFromCoordinator(Coordinator coordinator) {
        ObservableList<Event> allEventsFromCoordinator = FXCollections.observableArrayList();
        try {
            String sqlStatement = "SELECT eventID, eventName, address, startingTime, ownerid FROM Event INNER JOIN  Coordinator ON Coordinator.Coordinatorid = Event.ownerId  Where ownerid = ? ";
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

                allEventsFromCoordinator.add(new Event(id, eventName, address, startTime, ownerId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allEventsFromCoordinator;
    }
}
