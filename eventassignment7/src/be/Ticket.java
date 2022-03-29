package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ticket {

    private final StringProperty EventName = new SimpleStringProperty();
    private final StringProperty Address = new SimpleStringProperty();

    public Ticket( String EventName, String Address,int TicketCreator){

        setEventName(EventName);
        setAddress(Address);
        setTicketCreater(TicketCreator);
    }

    private void setTicketCreater(int ticketCreator) {
    }


    public StringProperty getAddress() {
        return Address;
    }

    public StringProperty getEventName() {
        return EventName;
    }

    public final void setEventName(String EventName){
        this.EventName.set(EventName);
    }

    public final void setAddress(String Address){
        this.Address.set(Address);
    }

}
