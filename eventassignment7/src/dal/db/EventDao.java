package dal.db;

import be.Coordinator;
import be.Event;
import be.User;
import dal.Interfaces.IEvent;

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
    public List<Event> getEventFromCoordinator(Coordinator coordinator) {
        List<Event> allEventsFromCoordinator = new ArrayList<>();
        try {
            String sqlStatement = "SELECT * FROM [EventAssignment].[dbo].[Coordinator] Where ownerid = ? ";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, coordinator.getId());

            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                String eventName = rs.getString("eventName");

                String address = rs.getString("address");

                String startTime = rs.getString("startTime");

                int ownerId = rs.getInt("ownerID");
                int id = rs.getInt("EventId");
                allEventsFromCoordinator.add(new Event(id, eventName, address, startTime, ownerId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allEventsFromCoordinator;
    }
}
