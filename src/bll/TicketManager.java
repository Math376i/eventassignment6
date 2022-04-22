package bll;

import be.Event;
import be.Ticket;
import be.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.db.DatabaseConnector;
import dal.db.EventDao;
import dal.db.TicketDao;

import java.io.IOException;
import java.util.List;

public class TicketManager {
    private TicketDao ticketDao;
    private DatabaseConnector connector;
    {
        try {
            connector = new DatabaseConnector();
            ticketDao = new TicketDao(connector.getConnection());
        } catch (SQLServerException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getTicketsFromEvent(Event event){
        return ticketDao.getTicketsFromEvent(event);
    }

    public void createTicket(Event event, User user){
        ticketDao.createTicket(event, user);
    }

}
