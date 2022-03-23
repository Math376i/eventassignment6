package be;

public class Ticket {
    private String EventName;
    private String Address;



    public String getAddress() {
        return Address;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
