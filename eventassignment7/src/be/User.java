package be;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final IntegerProperty phoneNumber= new SimpleIntegerProperty();
    private final IntegerProperty eventID = new SimpleIntegerProperty();

    public User(int id, String name, String email, int phoneNumber,int eventID){
        setId(id);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        seteventID(eventID);

    }

    public User(int id, String name, String email, int phoneNumber) {
        setId(id);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }



    public String getName() {
        return name.get();
    }

    public final void setId(int id){
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }

    public String getEmail() {
        return email.get();
    }

    public final void setName(String name){
        this.name.set(name);
    }
    public final void setEmail(String email){
        this.email.set(email);
    }
    public final void setPhoneNumber(int phoneNumber){
        this.phoneNumber.set(phoneNumber);
    }
    public final void seteventID(int eventID){
        this.eventID.set(eventID);
    }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty eventIDProperty() {
        return eventID;
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public StringProperty phoneNumberPropertyasStringProperty() {
        StringProperty stringProperty = new SimpleStringProperty();
        stringProperty.set(String.valueOf(phoneNumber.get()));
        return stringProperty;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getEventID() {
        return eventID.get();
    }

}
