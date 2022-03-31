package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Ticket {


    private final StringProperty eventName = new SimpleStringProperty();
    private final StringProperty guestName = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty startTime = new SimpleStringProperty();

    public Ticket(String eventName, String guestName, String address, String startTime){



    }

    public void setEventName(String eventName){
        this.eventName.set(eventName);
    }

    public String getEventName() {
        return eventName.get();
    }

    public StringProperty eventNameProperty() {
        return eventName;
    }

    public void setGuestName( String guestName){
        this.guestName.set(guestName);
    }

    public String getGuestName() {
        return guestName.get();
    }

    public StringProperty guestNameProperty() {
        return guestName;
    }

    public void setAddress(String address){
        this.address.set(address);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setStartTime(String startTime){
        this.startTime.set(startTime);
    }

    public String getStartTime() {
        return startTime.get();
    }

    public StringProperty startTimeProperty() {
        return startTime;
    }
}
