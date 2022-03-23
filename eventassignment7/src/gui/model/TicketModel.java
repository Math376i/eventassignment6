package gui.model;

import be.Ticket;
import bll.TicketManager;

import java.sql.SQLException;


public class TicketModel {

    TicketManager ticketManager = new TicketManager();

    public TicketModel() throws SQLException {
    }

    public void createTicket(String eventName, String address) {
        return TicketManager.createTicket(eventName, address);
    }
}
