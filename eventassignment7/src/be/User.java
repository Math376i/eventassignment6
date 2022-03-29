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
    private final IntegerProperty Usercreator = new SimpleIntegerProperty();

    public User(int id, String name, String email, int phoneNumber,int eventID, int UserCreator){
        setId(id);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        seteventID(eventID);

        setUsercreator(UserCreator);
    }

    public User(int id, String name, String email, int phoneNumber, int userEventID) {
    }

    private void setUsercreator(int userCreator) {
    }


    public StringProperty getName() {
        return name;
    }

    public final void setId(int id){
        this.id.set(id);
    }

    public IntegerProperty getId() {
        return id;
    }

    public StringProperty getEmail() {
        return email;
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

    public IntegerProperty getPhoneNumber() {
        return phoneNumber;
    }

    public IntegerProperty getEventID() {
        return eventID;
    }
}
