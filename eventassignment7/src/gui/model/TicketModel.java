package gui.model;

import be.Event;
import be.Ticket;
import be.User;
import bll.TicketManager;

import java.util.List;

public class TicketModel {

    private TicketManager ticketManager;

    public TicketModel() {
        ticketManager = new TicketManager();
    }

    public List<Ticket> getTicketsFromEvent(Event event){
        return ticketManager.getTicketsFromEvent(event);
    }

    public void createTicket(Event event, User user){
        ticketManager.createTicket(event, user);
    }
}
