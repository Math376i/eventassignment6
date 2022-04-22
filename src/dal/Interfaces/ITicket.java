package dal.Interfaces;

import be.Coordinator;
import be.Event;
import be.Ticket;
import be.User;

import java.util.List;

public interface ITicket {
    public List<Ticket> getTicketsFromEvent(Event event);
    public Ticket createTicket(Event event, User user);
    public boolean deleteTicket(Ticket ticket);
}
