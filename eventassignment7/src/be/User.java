package be;

public class User {
    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private int eventID;

    public User(int id, String userName, String email, int phoneNumber, int userEventId) {
        this.id = id;
        this.name = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.eventID = userEventId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getEventID() {
        return eventID;
    }
}
