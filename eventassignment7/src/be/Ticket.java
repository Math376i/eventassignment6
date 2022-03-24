package be;

public class Ticket {
    private String eventName;
    private String address;

    public Ticket( String eventName , String address){
        this.eventName = eventName;
        this.address = address;
        
    }


    public String getAddress() {
        return address;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        eventName = eventName;
    }

    public void setAddress(String address) {
        address = address;
    }
}
