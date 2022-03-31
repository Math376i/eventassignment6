package dal.db;

import be.Event;
import be.Ticket;
import be.User;
import dal.Interfaces.ITicket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class TicketDao implements ITicket {

    private Connection con;

    public TicketDao(Connection con){
        this.con = con;
    }

    @Override
    public List<Ticket> getTicketsFromEvent(Event event) {
        ObservableList<Ticket> allTicketsFromEvent = FXCollections.observableArrayList();
        try {
            String sqlStatement = "SELECT teventID,tuserID, eventName,guestName, address, startingTime FROM Ticket Where teventID = ? ";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, event.getId());

            statement.execute();

            ResultSet rs = statement.getResultSet();
            while (rs.next()) {

                int tEventId = rs.getInt(1);
                int tUserId = rs.getInt(2);
                String eventName = rs.getString(3);
                String userName = rs.getString(4);

                String address = rs.getString("address");

                String startTime = rs.getString("startingTime");


                allTicketsFromEvent.add(new Ticket(tEventId, tUserId,eventName,userName, address, startTime));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allTicketsFromEvent;
    }

    @Override
    public List<Ticket> getTicketsFromEventAndGuest(Event event, User user) {
        return null;
    }

    @Override
    public Ticket createTicket(Event event, User user) {
        int insertedId1 = -1;
        int insertedId2 = -1;
        try {
            String sqlStatement = "INSERT INTO Ticket( teventID, tuserID, eventName , guestName, address, startingTime) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sqlStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, event.getId());
            statement.setInt(2, user.getId());
            statement.setString(3, event.getName());
            statement.setString(4, user.getName());
            statement.setString(5, event.getStartTime());
            statement.setString(6, event.getStartTime());
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            insertedId1 = rs.getInt(1);
            insertedId2 = rs.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Ticket(insertedId1, insertedId2, event.getName(), user.getName(), event.getAddress(), event.getStartTime());
    }

    @Override
    public boolean deleteTicket(Ticket ticket) {
        try {
            String sqlStatement = "DELETE FROM Ticket WHERE teventID=? AND tuserID=? ";
            PreparedStatement statement = con.prepareStatement(sqlStatement);
            statement.setInt(1, ticket.getTeventid());
            statement.setInt(2, ticket.getTuserID());
            statement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
