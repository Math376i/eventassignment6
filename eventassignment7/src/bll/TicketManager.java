package bll;

import be.Ticket;
import dal.db.TicketDAO;

import java.sql.SQLException;

public class TicketManager {
TicketDAO ticketDAO = new TicketDAO();

    public TicketManager() throws SQLException {
    }

    public void createTicket(String eventName, String address) {
        return TicketDAO.createTicket(String eventName, String address);
    }


}
